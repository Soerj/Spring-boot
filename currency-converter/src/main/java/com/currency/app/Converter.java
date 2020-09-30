package com.currency.app;

import com.currency.app.entity.Valute;

public class Converter {

	public static double convert(int quantity, Valute from, Valute to) {
		
		double fromWeight = from.getNominal() * from.getValue();
		double toWeight = to.getNominal() * to.getValue();
		return (fromWeight / toWeight * quantity);
	}
}
