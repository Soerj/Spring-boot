package com.currency.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Valute")
public class Valute {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="true_id")
	private Long true_id;

	@Column(name="id")
	private String id;
	
	@Column(name="num_code")
	private int numCode;
	
	@Column(name="char_code")
	private String charCode;
	
	@Column(name="nominal")
	private int nominal;
	
	@Column(name="name")
	private String name;
	
	@Column(name="value")
	private double value;

	public Valute(String id, int numCode, String charCode, int nominal, String name, double value) {
		super();
		this.id = id;
		this.numCode = numCode;
		this.charCode = charCode;
		this.nominal = nominal;
		this.name = name;
		this.value = value;
	}

	public Valute() {}

	public String getId() {
		return id;
	}
	
	public Long getTrue_id() {
		return true_id;
	}

	public void setTrue_id(Long true_id) {
		this.true_id = true_id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getNumCode() {
		return numCode;
	}

	public void setNumCode(int numCode) {
		this.numCode = numCode;
	}

	public String getCharCode() {
		return charCode;
	}

	public void setCharCode(String charCode) {
		this.charCode = charCode;
	}

	public int getNominal() {
		return nominal;
	}

	public void setNominal(int nominal) {
		this.nominal = nominal;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((charCode == null) ? 0 : charCode.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + nominal;
		result = prime * result + numCode;
		long temp;
		temp = Double.doubleToLongBits(value);
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
		Valute other = (Valute) obj;
		if (charCode == null) {
			if (other.charCode != null)
				return false;
		} else if (!charCode.equals(other.charCode))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (nominal != other.nominal)
			return false;
		if (numCode != other.numCode)
			return false;
		if (Double.doubleToLongBits(value) != Double.doubleToLongBits(other.value))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Valute [id=" + id + ", numCode=" + numCode + ", charCode=" + charCode
				+ ", nominal=" + nominal + ", name=" + name + ", value=" + value + "]";
	}

	
	
}
