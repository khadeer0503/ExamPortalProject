package com.exam.examportal.model;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity

public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
 private Long id;
 private String username;
 private String password;
 private String firstname;
 private String lastname;
 private String email;
 private String phone;
 private String image;
 private boolean enabled=true;
 
 // user can have many UserRoles
 //cascade will hold the userRoles details.if we delete user it will delete the userRole
 //fetch, when user fetch his ROles can also be visible at the same time using (EAGER) Automatically.
 //mappedBy,UserRole will create the table and track the user
 
 @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER, mappedBy = "user")
 @JsonIgnore
 private Set<UserRoles> userRoles= new HashSet<>(); 
 
public Set<UserRoles> getUserRoles() {
	return userRoles;
}

public void setUserRoles(Set<UserRoles> userRoles) {
	this.userRoles = userRoles;
}

public User() {
	super();
	// TODO Auto-generated constructor stub
}

public User(Long id, String username, String password, String firstname, String lastname, String email, String phone,
		String image, boolean enabled) {
	super();
	this.id = id;
	this.username = username;
	this.password = password;
	this.firstname = firstname;
	this.lastname = lastname;
	this.email = email;
	this.phone = phone;
	this.image = image;
	this.enabled = enabled;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getFirstname() {
	return firstname;
}

public void setFirstname(String firstname) {
	this.firstname = firstname;
}

public String getLastname() {
	return lastname;
}

public void setLastname(String lastname) {
	this.lastname = lastname;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPhone() {
	return phone;
}

public void setPhone(String phone) {
	this.phone = phone;
}

public String getImage() {
	return image;
}

public void setImage(String image) {
	this.image = image;
}
public boolean isEnabled() {
	return enabled;
}

public void setEnabled(boolean enabled) {
	this.enabled = enabled;
}

@Override
public String toString() {
	return "User [id=" + id + ", username=" + username + ", password=" + password + ", firstname=" + firstname
			+ ", lastname=" + lastname + ", email=" + email + ", phone=" + phone + ", image=" + image + ", enabled="
			+ enabled + "]";
}




 

 
}
