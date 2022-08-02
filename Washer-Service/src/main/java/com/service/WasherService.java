package com.service;

import java.time.Duration;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;


import com.model.Washer;



public interface WasherService {

	Washer getWasherById(int id);

	Washer addWasher(Washer washer);

	List<Washer> getAllWashers();

	void deleteWasherById(int id);

	 Washer updateWasher(@Valid Washer washer);
	
}
