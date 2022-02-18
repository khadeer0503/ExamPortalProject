package com.exam.examportal.Service;

import java.util.Set;

import com.exam.examportal.model.User;
import com.exam.examportal.model.UserRoles;

public interface UserService {
 
	public  User CreateUser(User user, Set<UserRoles> userRoles);
	
	
	
}
