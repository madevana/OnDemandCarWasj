package com.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Exception.AdminAlreadyExistException;
import com.Exception.AdminNotFoundException;
import com.Exception.WashPackAlreadyExistException;
import com.Exception.WashPackNotFoundException;
import com.model.Admin;
import com.model.UserRating;
import com.model.WashPack;
import com.model.Washer;
import com.repository.AdminRepository;
import com.repository.RatingRepsitory;
import com.repository.WashPackRepository;






@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	private RatingRepsitory ratingRepository;
	@Autowired
	private WashPackRepository washpackRepository;

	private Logger LOGGER = LoggerFactory.getLogger(AdminServiceImpl.class);

//	@Override
//	public Admin addAdmin(Admin admin) {
//		LOGGER.info("Add Admin -START!");
//		Optional<Admin> savedAdmin = adminRepository.findById(admin.getId());
//		if (savedAdmin.isPresent()) {
//			LOGGER.info("Admin Already Exist");
//			throw new AdminAlreadyExistException();
//		} else
//			LOGGER.info("Saving...!!!");
//		LOGGER.info("Add Admin -END!");
//		return adminRepository.save(admin);
//	}
//
//	@Override
//	public void deleteAdminById(int id) {
//		LOGGER.info("Delete Admin -START!");
//		Optional<Admin> optionalAdmin = adminRepository.findById(id);
//		if (optionalAdmin == null) {
//			LOGGER.info("Admin not found");
//			throw new AdminNotFoundException();
//		} else {
//			LOGGER.info("Deleting Admin");
//			adminRepository.deleteById(id);
//			LOGGER.info("Delete Admin -END!");
//		}
//		
//}
//
//	@Override
//	public List<Admin> getAllAdmins() {
//		LOGGER.info("Fetch Admin -START!");
//		List<Admin> admins = adminRepository.findAll();
//		if (admins == null) {
//			LOGGER.info("Admin Not Found");
//			throw new AdminNotFoundException();
//		} else
//			LOGGER.info("Fetching...");
//		LOGGER.info("Fetch Admin -END!");
//		return admins;
//	}
//	@Override
//	public Admin getAdminById(int id) {
//		LOGGER.info("View Admin (Service) -START!");
//		Optional<Admin> optionalAdmin = adminRepository.findById(id);
//
//		if (optionalAdmin == null) {
//			LOGGER.error("Admin cannot be Found!");
//			throw new AdminNotFoundException("Admin not exising with id: " + id);
//		}
//
//		Admin admin = optionalAdmin.get();
//
//		LOGGER.info("Displaying Order!");
//		LOGGER.info("View Order  (Service) -END!");
//
//		return admin;
//	}
//	@Override
//	public Admin updateAdmin(Admin admin) {
//		LOGGER.info("Update admin -START!");
//		Optional<Admin> optionalAdmin =adminRepository.findById(admin.getId());
//
//		if (optionalAdmin == null) {
//			LOGGER.info("Admin Not Found");
//			throw new AdminNotFoundException("Admin not exising with id: " + admin.getId());
//		}
//
//		Admin updatedAdmin= adminRepository.save(admin);
//		LOGGER.info("Admin updated Successfully!");
//		LOGGER.info("Update Admin -End!");
//		return updatedAdmin;
//
//
//}
//*********************************************WASKPACK****************************************************************
	@Override
	public WashPack addWashPack(WashPack Wpack) {
		LOGGER.info("Add Washpack -START!");
		Optional<WashPack> savedWpack = washpackRepository.findById(Wpack.getId());
		if (savedWpack.isPresent()) {
			LOGGER.info("WashPack Already Exist");
			throw new WashPackAlreadyExistException();
		} else
			LOGGER.info("Saving...!!!");
		LOGGER.info("Add Washpack -END!");
		return washpackRepository.save(Wpack);
	}

	@Override
	public void deleteWashPackById(int id) {
		LOGGER.info("Delete Washpack -START!");
		Optional<WashPack> optionalpack = washpackRepository.findById(id);
		if (optionalpack == null) {
			LOGGER.info("Washpack not found");
			throw new WashPackNotFoundException();
		} else {
			LOGGER.info("Deleting washpack");
			washpackRepository.deleteById(id);
			LOGGER.info("Delete washpack -END!");
		}

	}

	@Override
	public List<WashPack> getAllWashPacks() {
		LOGGER.info("Fetch Washpack -START!");
		List<WashPack> pack = washpackRepository.findAll();
		if (pack == null) {
			LOGGER.info("Washpack Not Found");
			throw new WashPackNotFoundException();
		} else
			LOGGER.info("Fetching...");
		LOGGER.info("Fetch Washpack -END!");
		return pack;
	}
	@Override
	public WashPack getWashPackById(int id) {
		LOGGER.info("View Washpack (Service) -START!");
		Optional<WashPack> optionalpack = washpackRepository.findById(id);

		if (optionalpack == null) {
			LOGGER.error("Washpack cannot be Found!");
			throw new WashPackNotFoundException("Washpack not exising with id: " + id);
		}

		WashPack wPack = optionalpack.get();

		LOGGER.info("Displaying Washpack!");
		LOGGER.info("View Washpack  (Service) -END!");

		return wPack;
	}
	@Override
	public WashPack updateWashPack(WashPack wPack) {
		LOGGER.info("Update Washpack -START!");
		Optional<WashPack> optionalpack =washpackRepository.findById(wPack.getId());

		if (optionalpack == null) {
			LOGGER.info("Washpack Not Found");
			throw new WashPackNotFoundException("Admin not exising with id: " + wPack.getId());
		}

		WashPack updatedWashPack= washpackRepository.save(wPack);
		LOGGER.info("WashPack updated Successfully!");
		LOGGER.info("Update  Washpack -End!");
		return updatedWashPack;

	
}
//	********************************Uasers Rating**********************************
	
	@Override
	public List<UserRating> getAllUserRatings() {
		
		List<UserRating> rating=ratingRepository.findAll();
		return rating;
	}
	
}

