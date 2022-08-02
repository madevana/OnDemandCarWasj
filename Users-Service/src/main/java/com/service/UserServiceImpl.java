package com.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Exception.PaymentNotFoundException;
import com.Exception.UserAlreadyExistException;
import com.Exception.UserNotFoundException;
import com.model.Payment;
import com.model.Signup;
import com.repository.UserRepository;



@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepository;

	private Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	public Signup addUser(Signup user) {
		LOGGER.info("Add User-START!");
		Optional<Signup> savedUser = userRepository.findById(user.getId());
		if (savedUser.isPresent()) {
			LOGGER.info("User Already Exist");
			throw new UserAlreadyExistException();
		} else
			LOGGER.info("Saving...!!!");
		LOGGER.info("Add User-END!");
		return userRepository.save(user);
	}

	@Override
	public void deleteUserById(int id) {
		LOGGER.info("Delete User -START!");
		Optional<Signup> optionalUser = userRepository.findById(id);
		if (optionalUser == null) {
			LOGGER.info("User not found");
			throw new UserNotFoundException();
		} else {
			LOGGER.info("Deleting User");
			userRepository.deleteById(id);
			LOGGER.info("Delete User -END!");
		}

	}

	@Override
	public List<Signup> getAllUsers() {
		LOGGER.info("Fetch User-START!");
		List<Signup> users = userRepository.findAll();
		if (users == null) {
			LOGGER.info("User Not Found");
			throw new UserNotFoundException();
		} else
			LOGGER.info("Fetching...");
		LOGGER.info("Fetch Users -END!");
		return users;
	}
	@Override
	public Signup getUserById(int id) {
		LOGGER.info("View User (Service) -START!");
		Optional<Signup> optionalUser = userRepository.findById(id);

		if (optionalUser == null) {
			LOGGER.error("User cannot be Found!");
			throw new UserNotFoundException("User not exising with id: " + id);
		}

		Signup signup = optionalUser.get();

		LOGGER.info("Displaying User!");
		LOGGER.info("View User  (Service) -END!");

		return signup;
	}
	@Override
	public Signup updateUserAccount(Signup user) {
		LOGGER.info("Update Account -START!");
		Optional<Signup> optionaluser = userRepository.findById(user.getId());

		if (optionaluser == null) {
			LOGGER.info("Account Not Found");
			throw new UserNotFoundException("Account not exising with id: " + user.getId());
		}

		Signup updatedAccount = userRepository.save(user);
		LOGGER.info("Payment updated Successfully!");
		LOGGER.info("Update Payment -End!");
		return updatedAccount;

	
	}


}

