package com.exam.examportal.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.examportal.model.Role;
import com.exam.examportal.model.User;
import com.exam.examportal.model.UserRoles;
import com.exam.examportal.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/")
	public User CreateUser(@RequestBody User user) throws Exception {
		
		Set<UserRoles> roles=new HashSet<>();
		
		Role role=new Role();
		role.setRoleId(01L);
		role.setRoleName("ADMIN");
		
		UserRoles userRole=new UserRoles();
		userRole.setRole(role);
		userRole.setUser(user);
		
		roles.add(userRole);
		
		return this.userService.createUser(user,roles);
		
		
		
	}
	
	
	

}
