package com.service;

import java.util.List;

import javax.validation.Valid;

import com.model.Signup;

public interface UserService {

Signup getUserById(int id);
void deleteUserById(int id);
Signup addUser(Signup user);
List<Signup> getAllUsers();
Signup updateUserAccount(@Valid Signup user);


}
