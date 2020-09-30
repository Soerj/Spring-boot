package com.currency.app.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="convertation_history")
public class Convertation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="date")
	private LocalDate date;
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="convert_from")
	private String charCodeFrom;
	
	@Column(name="convert_to")
	private String charCodeTo;
	
	@Column(name="result")
	private double result;
	
	public Convertation(LocalDate date, int quantity, String charCodeFrom, String charCodeTo, double result) {
		super();
		this.date = date;
		this.quantity = quantity;
		this.charCodeFrom = charCodeFrom;
		this.charCodeTo = charCodeTo;
		this.result = result;
	}	

	public Convertation() {}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getCharCodeFrom() {
		return charCodeFrom;
	}

	public void setCharCodeFrom(String charCodeFrom) {
		this.charCodeFrom = charCodeFrom;
	}

	public String getCharCodeTo() {
		return charCodeTo;
	}

	public void setCharCodeTo(String charCodeTo) {
		this.charCodeTo = charCodeTo;
	}

	public double getResult() {
		return result;
	}

	public void setResult(double result) {
		this.result = result;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((charCodeFrom == null) ? 0 : charCodeFrom.hashCode());
		result = prime * result + ((charCodeTo == null) ? 0 : charCodeTo.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		long temp;
		temp = Double.doubleToLongBits(quantity);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(this.result);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Convertation other = (Convertation) obj;
		if (charCodeFrom == null) {
			if (other.charCodeFrom != null)
				return false;
		} else if (!charCodeFrom.equals(other.charCodeFrom))
			return false;
		if (charCodeTo == null) {
			if (other.charCodeTo != null)
				return false;
		} else if (!charCodeTo.equals(other.charCodeTo))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (Double.doubleToLongBits(quantity) != Double.doubleToLongBits(other.quantity))
			return false;
		if (Double.doubleToLongBits(result) != Double.doubleToLongBits(other.result))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ConvertationHistory [id=" + id + ", date=" + date + ", quantity=" + quantity + ", charCodeFrom="
				+ charCodeFrom + ", charCodeTo=" + charCodeTo + ", result=" + result + "]";
	}
	
	
}
