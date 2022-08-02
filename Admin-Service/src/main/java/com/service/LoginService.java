package com.service;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Admin;
import com.model.Signup;
import com.repository.AdminRepository;


@Service
public class LoginService {
	@Autowired
	private AdminRepository adminRepository;

	public String adminLogin(Admin login) {
		ArrayList<Admin> list = (ArrayList<Admin>) adminRepository.findAll();
		int count = 0;

		for (int i = 0; i < list.size(); i++) {

			if (list.get(i).getName().equals(login.getName())
					&& list.get(i).getPassword().equals(login.getPassword())) {

				count++;
			}
		}

		if (count == 1) {
			return "logged in";
		} else {
			return "wrong credentials";
		}

	}

	
	

}

