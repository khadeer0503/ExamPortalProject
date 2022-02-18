package com.exam.examportal.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.examportal.Repository.RoleRepository;
import com.exam.examportal.Repository.UserRepository;
import com.exam.examportal.model.User;
import com.exam.examportal.model.UserRoles;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
			
	//creating User
	@Override
	public User createUser(User user, Set<UserRoles> userRoles) throws Exception {
		
		User local=this.userRepository.findByUsername(user.getUsername());
		if(local != null) {
		System.out.println("User Already Exists !!");	
		throw new Exception("User Already Exists !!");
		} else {
			for(UserRoles ur:userRoles) {
				this.roleRepository.save(ur.getRole());
			}
			
			user.getUserRoles().addAll(userRoles);
			 local=this.userRepository.save(user);
		}
		
		
		return local;
	}

}
