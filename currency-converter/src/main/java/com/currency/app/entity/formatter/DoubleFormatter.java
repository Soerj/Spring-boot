package com.currency.app.entity.formatter;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;

public class DoubleFormatter {

	public static double toDouble(String s) throws ParseException {
		
		DecimalFormat df = new DecimalFormat();
		DecimalFormatSymbols symbols = new DecimalFormatSymbols();
		symbols.setDecimalSeparator(',');
		symbols.setGroupingSeparator(' ');
		df.setDecimalFormatSymbols(symbols);
		return df.parse(s).doubleValue();
	}

	public static String toString(double d) {
		return Double.toString(d);
	}
}
