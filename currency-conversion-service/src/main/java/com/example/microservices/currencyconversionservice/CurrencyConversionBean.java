package com.example.microservices.currencyconversionservice;

import java.math.BigDecimal;

public class CurrencyConversionBean {

	private Long id;
	private String fromId;
	private String fromName;
	private String toId;
	private String toName;
	private String conversionCode;
	private BigDecimal conversionFactor;
	private BigDecimal quantity;
	private BigDecimal totalCalculatedAmount;

	public CurrencyConversionBean() {
		super();
	}

	public CurrencyConversionBean(Long id, String fromId, String fromName, String toId, String toName,
			String conversionCode, BigDecimal conversionFactor, BigDecimal quantity, BigDecimal totalCalculatedAmount) {
		super();
		this.id = id;
		this.fromId = fromId;
		this.fromName = fromName;
		this.toId = toId;
		this.toName = toName;
		this.conversionCode = conversionCode;
		this.conversionFactor = conversionFactor;
		this.quantity = quantity;
		this.totalCalculatedAmount = totalCalculatedAmount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFromId() {
		return fromId;
	}

	public void setFromId(String fromId) {
		this.fromId = fromId;
	}

	public String getFromName() {
		return fromName;
	}

	public void setFromName(String fromName) {
		this.fromName = fromName;
	}

	public String getToId() {
		return toId;
	}

	public void setToId(String toId) {
		this.toId = toId;
	}

	public String getToName() {
		return toName;
	}

	public void setToName(String toName) {
		this.toName = toName;
	}

	public String getConversionCode() {
		return conversionCode;
	}

	public void setConversionCode(String conversionCode) {
		this.conversionCode = conversionCode;
	}

	public BigDecimal getConversionFactor() {
		return conversionFactor;
	}

	public void setConversionFactor(BigDecimal conversionFactor) {
		this.conversionFactor = conversionFactor;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getTotalCalculatedAmount() {
		return totalCalculatedAmount;
	}

	public void setTotalCalculatedAmount(BigDecimal totalCalculatedAmount) {
		this.totalCalculatedAmount = totalCalculatedAmount;
	}

}
