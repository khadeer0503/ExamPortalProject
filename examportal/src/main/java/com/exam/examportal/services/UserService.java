package com.exam.examportal.services;

import java.util.Set;

import com.exam.examportal.model.User;
import com.exam.examportal.model.UserRoles;

public interface UserService {
	public User createUser(User user,Set<UserRoles> userRoles) throws Exception;

}
