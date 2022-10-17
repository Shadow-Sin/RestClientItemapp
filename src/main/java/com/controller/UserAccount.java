package com.controller;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserAccount {

	private String emailId;
	private String password;
	
	private AccountUser accountUser;

	public UserAccount() {
		super();
	}

	public UserAccount(String emailId, String password, AccountUser user) {
		super();
		this.emailId = emailId;
		this.password = password;
		this.accountUser = user;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public AccountUser getAccountUser() {
		return accountUser;
	}

	public void setAccountUser(AccountUser user) {
		this.accountUser = user;
	}

	@Override
	public String toString() {
		return "UserAccount [emailId=" + emailId + ", password=" + password + ", user=" + accountUser + "]";
	}
	

}
