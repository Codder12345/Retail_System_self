package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.UserModel;
import com.example.demo.Repository.UserRepo;

@Service("userservice")
public class UserService {
   	@Autowired
   	UserRepo userRepo;
  public boolean isAddNewUser(UserModel model) {
	    
	  return userRepo.isAddNewUser(model);
  }
  
  
  
public List<UserModel> getAllUser()
{

	 return userRepo.getAllUser();
}
public UserModel  searchUserByID(int id)
{
	return userRepo.searchUserByID(id);
}

public boolean isDeleteUserByID(int id)
{

	return userRepo.isDeleteUserByID(id);
}

}
