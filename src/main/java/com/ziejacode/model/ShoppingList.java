package com.ziejacode.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="shoppinglist")
public class ShoppingList {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="shoppinglist_id")
	private int shoppinglistId;	
	
    @Column(name="shoppinglist_name")
	private String shoppinglistName;
	
    @OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="shoppinglist_id", nullable=false)
	private List<Item>items;

    
   
    
    
	public int getShoppinglistId() {
		return shoppinglistId;
	}

	public void setShoppinglistId(int shoppinglistId) {
		this.shoppinglistId = shoppinglistId;
	}

	public String getShoppinglistName() {
		return shoppinglistName;
	}

	public void setShoppinglistName(String shoppinglistName) {
		this.shoppinglistName = shoppinglistName;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	
	
	
	

}
