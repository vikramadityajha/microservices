package com.example.microservices.currencycrudservice;

import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "currency-exchange-service")
@RibbonClient(name = "currency-exchange-service")
public interface CurrencyExchangeServiceProxy {

	@GetMapping("/exchange-values")
	public List<ExchangeValueBean> getAllExchangeValue();

	@PostMapping("/exchange-value")
	public ResponseEntity<ExchangeValueBean> createExchangeValue(@RequestBody ExchangeValueBean exchangeValue);

	@DeleteMapping("/exchange-value/{conversionCode}")
	public ResponseEntity<Void> deleteExchangeValue(@PathVariable("conversionCode") String conversionCode);
}
