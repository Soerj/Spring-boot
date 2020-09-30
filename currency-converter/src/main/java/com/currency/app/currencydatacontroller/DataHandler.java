package com.currency.app.currencydatacontroller;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.jibx.runtime.BindingDirectory;
import org.jibx.runtime.IBindingFactory;
import org.jibx.runtime.IUnmarshallingContext;

import com.currency.app.entity.ValCurs;
import com.currency.app.entity.Valute;
import com.currency.app.repository.ValCursRepo;

public class DataHandler {
	
	private static final String urlBaseString = "http://www.cbr.ru/scripts/XML_daily.asp";
	
	public static boolean isInDb(ValCursRepo Db, LocalDate date) {
		
		if (Db.findByDate(date) != null)
			return true;
		
		return false;
	}
	
	/**
	 * Get data for specified date from CB-api in xml format and write it to Db
	 * @param db
	 * @param date
	 */
	public static void dataAtDateToDb(ValCursRepo db, LocalDate date) {
		
		try {
			
			String xDate = date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			URL url = new URL("http://www.cbr.ru/scripts/XML_daily.asp" + "?date_req=" + xDate);
			URLConnection connection = url.openConnection();
			InputStream inputStream = connection.getInputStream();
			
			// unmarshall xml data and write to db
			IBindingFactory bfact = BindingDirectory.getFactory(ValCurs.class);
			IUnmarshallingContext uctx = bfact.createUnmarshallingContext();

			InputStreamReader freader;

			freader = new InputStreamReader(inputStream, "windows-1251");
			
			Object obj = uctx.unmarshalDocument(freader);
			
			// add RUB valute
			Valute rub = new Valute("RRRRRR", 643, "RUB", 1, "Российский рубль", 1);

			if (obj instanceof ValCurs)
				
				((ValCurs)obj).getValutes().add(rub);
				db.save((ValCurs) obj);
				
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
}
