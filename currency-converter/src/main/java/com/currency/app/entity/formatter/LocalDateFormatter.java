package com.currency.app.entity.formatter;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateFormatter {

	public static LocalDate toLocalDate(String s) throws ParseException {

		return LocalDate.parse(s, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
	}

	public static String toString(LocalDate d) {
		return d.toString();
	}
}
