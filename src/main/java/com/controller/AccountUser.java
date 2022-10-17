package com.controller;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;


public class AccountUser {
	
	private int userNo;
	
	private String userName;
	
	
	private UserAccount userAccount;
	
	
	
	public AccountUser() {
		super();
	}
	public AccountUser(int userNo, String userName, UserAccount userAccount) {
		super();
		this.userNo = userNo;
		this.userName = userName;
		this.userAccount = userAccount;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public UserAccount getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}
	@Override
	public String toString() {
		return "AccountUser [userNo=" + userNo + ", userName=" + userName + ", account=" + userAccount + "]";
	}
	
	
	
	
}
