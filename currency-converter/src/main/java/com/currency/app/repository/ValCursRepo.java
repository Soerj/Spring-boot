package com.currency.app.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.currency.app.entity.ValCurs;

public interface ValCursRepo extends JpaRepository<ValCurs, Integer> {
	
	@Query("SELECT v FROM ValCurs v WHERE date = :date")
	public List<ValCurs> findByDateList(@Param("date") LocalDate date);
	
	default public ValCurs findByDate(LocalDate date) {
		
		if (findByDateList(date).size() > 0) {
			
			ValCurs v = findByDateList(date).get(0);
			return v;
		}
		
		return null;
	}
}
