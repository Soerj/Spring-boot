package com.currency.app.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="val_curs")
public class ValCurs {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="date")
	private LocalDate date;
	
	@Column(name="name")
	private String name;
	
	@OneToMany(
	        cascade = CascadeType.ALL, 
	        fetch = FetchType.EAGER, 
	        orphanRemoval = true
	    )
	@JoinColumn(name="date_id")
	private List<Valute> valutes;

	public ValCurs() {}

	public ValCurs(int id, LocalDate date, String name, List<Valute> valutes) {
		super();
		this.id = id;
		this.date = date;
		this.name = name;
		this.valutes = valutes;
	}
	
	public ValCurs(LocalDate date, String name, List<Valute> valutes) {
		super();
		this.date = date;
		this.name = name;
		this.valutes = valutes;
	}
	
	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Valute> getValutes() {
		return valutes;
	}

	public void setValutes(List<Valute> valutes) {
		this.valutes = valutes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		ValCurs other = (ValCurs) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ValCurs [id=" + id + ", date=" + date + ", name=" + name + "]";
	}

	
	
}
