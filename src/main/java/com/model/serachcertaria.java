package com.model;

import org.hibernate.validator.constraints.NotBlank;

public class serachcertaria {

	public class SearchCriteria {

	    @NotBlank(message = "username can't empty!")
	    String username;

	    public String getUsername() {
	        return username;
	    }

	    public void setUsername(String username) {
	        this.username = username;
	    }
	    

}}
