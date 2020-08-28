package com.example.microservices.currencyexchangeservice;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class CurrencyExchangeController {

	@Autowired
	ExchangeValueRepository exchangeValueRepository;

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	@HystrixCommand(fallbackMethod = "fallbackRetrieveExchangeValue")
	public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {

		String conversionCode1 = "INR" + from;
		String conversionCode2 = "INR" + to;
		ExchangeValue response1 = exchangeValueRepository.findByConversionCode(conversionCode1);
		ExchangeValue response2 = exchangeValueRepository.findByConversionCode(conversionCode2);

		return new ExchangeValue(response1.getId(), response1.getToId(), response1.getToName(), response2.getToId(),
				response2.getToName(), from + to,
				response2.getConversionFactor().divide(response1.getConversionFactor(), 3, RoundingMode.HALF_EVEN));
	}

	public ExchangeValue fallbackRetrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
		return new ExchangeValue(1000L, from, "Unknown", to, "Unknown", from + to, BigDecimal.ONE);
	}

	@GetMapping("/exchange-values")
	public List<ExchangeValue> getAllExchangeValue() {
		return exchangeValueRepository.findAll();
	}

	@PostMapping("/exchange-value")
	public ResponseEntity<ExchangeValue> createExchangeValue(@RequestBody ExchangeValue exchangeValue) {

		String conversionCode = exchangeValue.getFromId() + exchangeValue.getToId();
		ExchangeValue exchangeValueExits = exchangeValueRepository.findByConversionCode(conversionCode);

		if (exchangeValueExits == null) {
			ExchangeValue createdExchangeValue = exchangeValueRepository.save(exchangeValue);
			return new ResponseEntity<ExchangeValue>(createdExchangeValue, HttpStatus.OK);
		}

		exchangeValueExits.setConversionFactor(exchangeValue.getConversionFactor());
		ExchangeValue updatedExchangeValue = exchangeValueRepository.save(exchangeValueExits);
		return new ResponseEntity<ExchangeValue>(updatedExchangeValue, HttpStatus.OK);
	}

	@DeleteMapping("/exchange-value/{conversionCode}")
	public ResponseEntity<Void> deleteExchangeValue(@PathVariable String conversionCode) {

		ExchangeValue exchangeValueExits = exchangeValueRepository.findByConversionCode(conversionCode);

		if (exchangeValueExits != null) {
			exchangeValueRepository.deleteById(exchangeValueExits.getId());

			return ResponseEntity.noContent().build();
		}

		return ResponseEntity.notFound().build();
	}
}
