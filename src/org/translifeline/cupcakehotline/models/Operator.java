package org.translifeline.cupcakehotline.models;

import org.translifeline.cupcakehotline.annotations.RestrictToAdmins;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class Operator {
	@Id private Long id;
	@RestrictToAdmins private String email;
	private String name;
	@RestrictToAdmins private Long phone;
	private boolean isOnCall;
	@RestrictToAdmins private boolean isAdmin;
	@RestrictToAdmins private boolean isTrained;
	
	public Long getId() {
		return id;
	}
}
