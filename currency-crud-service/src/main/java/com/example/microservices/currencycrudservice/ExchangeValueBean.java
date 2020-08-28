package com.example.microservices.currencycrudservice;

import java.math.BigDecimal;

public class ExchangeValueBean {

	private String fromId;
	private String fromName;
	private String toId;
	private String toName;
	private String conversionCode;
	private BigDecimal conversionFactor;

	public ExchangeValueBean() {
		super();
	}

	public ExchangeValueBean(String fromId, String fromName, String toId, String toName, String conversionCode,
			BigDecimal conversionFactor) {
		super();
		this.fromId = fromId;
		this.fromName = fromName;
		this.toId = toId;
		this.toName = toName;
		this.conversionCode = conversionCode;
		this.conversionFactor = conversionFactor;
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
}
