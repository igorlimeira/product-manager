package br.com.product.app.models;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table
public class Product{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonProperty("id")
	private Long id;
	@JsonProperty("barCode")
	private String barCode;
	@JsonProperty("description")
	private String description;
	@JsonProperty("price")
	private BigDecimal price;

	public String getBarCode() {
		return barCode;
	}
	
	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public Long getId() {
		return id;
	}
}
