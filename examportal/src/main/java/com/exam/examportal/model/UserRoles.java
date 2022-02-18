package com.exam.examportal.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


// the UserRole has both User and Role , which is UserRole is mapping both.
@Entity
public class UserRoles {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long UserRoleId;
	
	// Role has single user
	@ManyToOne(fetch = FetchType.EAGER)
		private User  user;
	
	@ManyToOne
	private Role role;

	public UserRoles(long userRoleId, User user, Role role) {
		super();
		UserRoleId = userRoleId;
		this.user = user;
		this.role = role;
	}

	public UserRoles() {
		// TODO Auto-generated constructor stub
	}

	public long getUserRoleId() {
		return UserRoleId;
	}

	public void setUserRoleId(long userRoleId) {
		UserRoleId = userRoleId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}



}
