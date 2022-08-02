package com.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Exception.WasherAlreadyExistException;
import com.Exception.WasherNotFoundException;

import com.model.OrderDetails;
import com.model.Washer;
import com.repository.WasherRepository;


@Service
public class WasherServiceImpl implements WasherService{
	@Autowired
	private WasherRepository washerRepository;

	private Logger LOGGER = LoggerFactory.getLogger(WasherServiceImpl.class);

	@Override
	public Washer addWasher(Washer washer) {
		LOGGER.info("Add Washer -START!");
		Optional<Washer> savedWasher = washerRepository.findById(washer.getId());
		if (savedWasher.isPresent()) {
			LOGGER.info("Washer Already Exist");
			throw new WasherAlreadyExistException();
		} else
			LOGGER.info("Saving...!!!");
		LOGGER.info("Add Washer -END!");
		return washerRepository.save(washer);
	}

	@Override
	public void deleteWasherById(int id) {
		LOGGER.info("Delete Washer -START!");
		Optional<Washer> optionalWasher = washerRepository.findById(id);
		if (optionalWasher == null) {
			LOGGER.info("Washer not found");
			throw new WasherNotFoundException();
		} else {
			LOGGER.info("Deleting Washer");
			washerRepository.deleteById(id);
			LOGGER.info("Delete washer -END!");
		}

	}

	@Override
	public List<Washer> getAllWashers() {
		LOGGER.info("Fetch Washer -START!");
		List<Washer> washers = washerRepository.findAll();
		if (washers == null) {
			LOGGER.info("Washer Not Found");
			throw new WasherNotFoundException();
		} else
			LOGGER.info("Fetching...");
		LOGGER.info("Fetch Washer -END!");
		return washers;
	}
	@Override
	public Washer getWasherById(int id) {
		LOGGER.info("View Washer (Service) -START!");
		Optional<Washer> optionalWasher = washerRepository.findById(id);

		if (optionalWasher == null) {
			LOGGER.error("Washer cannot be Found!");
			throw new WasherNotFoundException("Washer not exising with id: " + id);
		}

		Washer washer = optionalWasher.get();

		LOGGER.info("Displaying Washer!");
		LOGGER.info("View Washer  (Service) -END!");

		return washer;
	}
	@Override
	public Washer updateWasher(Washer washer) {
		LOGGER.info("Update Washer -START!");
		Optional<Washer> optionalWasher = washerRepository.findById(washer.getId());

		if (optionalWasher == null) {
			LOGGER.info("Washer Not Found");
			throw new WasherNotFoundException("Washer not exising with id: " + washer.getId());
		}

		Washer updatedWasher= washerRepository.save(washer);
		LOGGER.info("Washer updated Successfully!");
		LOGGER.info("Update Washer -End!");
		return updatedWasher;


}



}
