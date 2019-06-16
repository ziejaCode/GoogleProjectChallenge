package com.ziejacode.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="user")
public class User {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="user_id")
    private Integer userId;

    @Column(name="user_name")    
    private String userName;
    
    @Column(name="user_email")
    private String user_email;

    @Column(name="password")
	private String password;
	
//    @JsonIgnore
//	@OneToMany(cascade=CascadeType.ALL)
//	@JoinColumn(name="user_id", nullable=false)
//	private List<ItemName>  itemNamesList = new ArrayList<ItemName>();
    
	
	@JsonIgnore
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="user_id", nullable=false)
	private List<ShoppingList>shoppingLists = new ArrayList<ShoppingList>();

	
	
	

	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getUser_email() {
		return user_email;
	}


	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


//	public List<ItemName> getItemNames() {
//		return  itemNamesList;
//	}
//
//
//	public void setItemNames(List<ItemName> itemNames) {
//		this. itemNamesList = itemNames;
//	}


	public List<ShoppingList> getShoppingLists() {
		return shoppingLists;
	}


	public void setShoppingLists(List<ShoppingList> shoppingLists) {
		this.shoppingLists = shoppingLists;
	}


	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", user_email=" + user_email + ", password="
				+ password + ", shoppingLists=" + shoppingLists + "]";
	}

	
	
	
}
	
	