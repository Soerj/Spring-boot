package com.currency.app.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.currency.app.Converter;
import com.currency.app.currencydatacontroller.DataHandler;
import com.currency.app.entity.Convertation;
import com.currency.app.entity.ValCurs;
import com.currency.app.entity.Valute;
import com.currency.app.repository.ConvertationRepo;
import com.currency.app.repository.ValCursRepo;

import java.time.format.DateTimeFormatter;
import java.util.Map;

@Controller
public class MainController {
	
	@Autowired
	ValCursRepo valCursRepo;
	
	@Autowired
	ConvertationRepo convertationRepo;
	
	@GetMapping("/")
    public String home(Map<String, Object> model) {
		
		try {
			
			LocalDate today = LocalDate.now();		
			
			// check if data is already in database
			if (!DataHandler.isInDb(valCursRepo, today)) {
				
				DataHandler.dataAtDateToDb(valCursRepo, today);
			}
			
			ValCurs val = valCursRepo.findByDate(today);
			
			// display convertation form
			model.put("date", val.getDate());
			model.put("valutes", val.getValutes());
			
			// display history as list
			if (convertationRepo.findAll().size() > 0) {
				
				model.put("notEmpty", true);
				model.put("convertations", convertationRepo.findAll());
			}

			
			return "converter_page";
			
		} catch (Exception ex) {
			
			ex.printStackTrace();
		}
		
        return "error";
    }
	
	@PostMapping("/")
	public String homePost(
			@RequestParam(name="fromValute") String fromValute, 
			@RequestParam(name="quantity") String quantity,
			@RequestParam(name="toValute") String toValute,
			@RequestParam(name="date") String date,
			Map<String, Object> model) {
		
		LocalDate dbDate;
		if (!date.equals("")) {
			
			dbDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		} else {
			
			dbDate = LocalDate.now();
		}
		
		
		if (dbDate.isAfter(LocalDate.now())) {
			return "error";
		}
		
		// retrieve new data, if not exist
		if (!DataHandler.isInDb(valCursRepo, dbDate)) {
			
			DataHandler.dataAtDateToDb(valCursRepo, dbDate);
		}
		
		ValCurs val = valCursRepo.findByDate(dbDate);
		
		// kekw
		LocalDate temp = dbDate;
		int counter = 7;
		
		while (val == null && counter > 0) {
			
			counter--;
			temp = temp.minusDays(1);
			val = valCursRepo.findByDate(temp);
			
		}
		
		if (val == null)
			return "error";
		
		Valute from = null;
		Valute to = null;
		
		for (Valute v : val.getValutes()) {
			
			if (v.getId().equals(fromValute)) {
				
				from = v;
			}
			
			if (v.getId().equals(toValute)) {
				
				to = v;
			}
		}
		
		
		if (from != null && to != null)
		{
			double convertResult = Converter.convert(Integer.parseInt(quantity), from, to);
			
			Convertation convertation = new Convertation(val.getDate(), Integer.parseInt(quantity), 
					from.getCharCode(), to.getCharCode(), convertResult);
			
			convertationRepo.save(convertation);
			
			// display convertation form
			model.put("date", val.getDate());
			model.put("valutes", val.getValutes());
		
			// display history as list
			model.put("notEmpty", true);
			model.put("convertations", convertationRepo.findAll());
			model.put("date", val.getDate());
			model.put("quantity", quantity);
			model.put("fromValute", from);
			model.put("toValute", to);
			model.put("result", convertResult);
			

			
			return "converter_page";
		}
		
		return "error";
	}
	
	@GetMapping("/history")
	public String getConvertionHistory(Map<String, Object> model) {
		
		// display history as list
		model.put("notEmpty", true);
		model.put("convertations", convertationRepo.findAll());
		
		return "convertation_history";
	}

}
