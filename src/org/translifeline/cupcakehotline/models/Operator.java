package org.translifeline.cupcakehotline.models;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class Operator {
	@Id Long id;
	String email;
	String name;
	Long phone;
	boolean isOnCall;
	boolean isAdmin;
	boolean isTrained;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getPhone() {
		return phone;
	}
	public void setPhone(Long phone) {
		this.phone = phone;
	}
	public boolean isOnCall() {
		return isOnCall;
	}
	public void setOnCall(boolean isOnCall) {
		this.isOnCall = isOnCall;
	}
	public boolean isAdmin() {
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	public boolean isTrained() {
		return isTrained;
	}
	public void setTrained(boolean isTrained) {
		this.isTrained = isTrained;
	}
}
