package com.example.microservices.currencyexchangeservice;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ExchangeValue {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String fromId;
	private String fromName;
	private String toId;
	private String toName;

	@Column(updatable = false, unique = true)
	private String conversionCode;
	private BigDecimal conversionFactor;

	public ExchangeValue() {
		super();
	}

	public ExchangeValue(Long id, String fromId, String fromName, String toId, String toName, String conversionCode,
			BigDecimal conversionFactor) {
		super();
		this.id = id;
		this.fromId = fromId;
		this.fromName = fromName;
		this.toId = toId;
		this.toName = toName;
		this.conversionCode = conversionCode;
		this.conversionFactor = conversionFactor;
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

}
