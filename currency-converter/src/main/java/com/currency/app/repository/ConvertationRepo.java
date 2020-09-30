package com.currency.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.currency.app.entity.Convertation;

public interface ConvertationRepo extends JpaRepository<Convertation, Long> {

	
}
