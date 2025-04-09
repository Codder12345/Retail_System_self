package com.example.demo.Controllers;


import java.util.ArrayList;
import java.util.List;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ExceptionHandel.ErrorMessage;
import com.example.demo.ExceptionHandel.ExceptionNotFound;
import com.example.demo.Model.UserModel;
import com.example.demo.Service.UserService;

@RestController
public class UserController {
	
	 @Autowired
	 UserService userservice;

	 @PostMapping("/save")
	  public String createUser(@RequestBody  UserModel model )
	  {
		  boolean b=userservice.isAddNewUser(model);
		  return b?"User Added":"not Added";
	  }
	 
	 List<UserModel> list=new ArrayList<>();
	 
	 @GetMapping("/getalluser")
	  public List<UserModel> getAllUser( )
	  {
		 List<UserModel>list=userservice.getAllUser();
		if(list.size()!=0)
		{
		  return list;	
		}
		else {
			throw new ExceptionNotFound( "their is no data fond");//custom exception;
		}
	  }
	 
	 @ExceptionHandler(value=ExceptionNotFound.class)
	 @ResponseStatus(HttpStatus.NOT_FOUND)
	 public ErrorMessage handelNotFoundException(ExceptionNotFound exception)
	 {
		 return new ErrorMessage(HttpStatus.NOT_FOUND.value(),exception.getMessage());
	 }
	 
	  @GetMapping("/searchuserbyid/{userID}")
	 public UserModel searchUserByID(@PathVariable("userID")  Integer id)
	 {
		   UserModel mm=userservice.searchUserByID(id);
		   if(mm!=null)
		   {
			   return mm;
		   }
		   else {
			   throw new ExceptionNotFound("UserNot found"+id);
		   }
	
		 
	 }
	  
	  
	  @GetMapping("/updateuserbyid/{uid}")
	  
	  public UserModel updateUserByID(int id) {
		
		    
		  return null;
	  }
	  
	  
	  @GetMapping("/deleteuserbyid/{uid}")
	  public String  isDeleteUserByID(@PathVariable("uid") Integer id)
	  {
		   boolean b=userservice.isDeleteUserByID(id);
		   if(b)
		   {
			return "Employee deleted";   
		   }
		   else {
			   throw  new ExceptionNotFound("no employee found");
		   }
		
	  }
	 

}
