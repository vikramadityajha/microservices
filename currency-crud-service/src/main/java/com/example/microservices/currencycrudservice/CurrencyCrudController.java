package com.example.microservices.currencycrudservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.microservices.currencycrudservice.CurrencyExchangeServiceProxy;

@RestController
public class CurrencyCrudController {
	@Autowired
	private CurrencyExchangeServiceProxy proxy;

	@GetMapping("/currency-crud/exchange-values")
	public List<ExchangeValueBean> getAllExchangeValue() {
		return proxy.getAllExchangeValue();
	};

	@PostMapping("/currency-crud/exchange-value")
	public ResponseEntity<ExchangeValueBean> createExchangeValue(@RequestBody ExchangeValueBean exchangeValue) {
		return proxy.createExchangeValue(exchangeValue);
	};

	@DeleteMapping("/currency-crud/exchange-value/{conversionCode}")
	public ResponseEntity<Void> deleteExchangeValue(@PathVariable("conversionCode") String conversionCode) {
		return proxy.deleteExchangeValue(conversionCode);
	};
}
