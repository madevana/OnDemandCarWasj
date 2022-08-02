package com.service;

import java.util.List;

import javax.validation.Valid;

import com.model.Admin;
import com.model.UserRating;
import com.model.WashPack;

public interface AdminService {

//	void deleteAdminById(int id);
//
//	Admin getAdminById(int id);
//
//	Admin addAdmin(Admin admin);
//
//	List<Admin> getAllAdmins();
//
//	Admin updateAdmin(@Valid Admin admin);
	
//*****************WASHPACK****************************
	
	WashPack addWashPack(WashPack wpack);

	List<WashPack> getAllWashPacks();

	void deleteWashPackById(int id);

	WashPack updateWashPack(@Valid WashPack wpack);

	WashPack getWashPackById(int id);
	
//************************Users Ratings***********************
	List<UserRating> getAllUserRatings();

	

	

	

	
}
