package com.ziejacode.services;

import org.springframework.stereotype.Service;

import com.ziejacode.model.ShoppingList;

@Service
public interface ShoppingListService {

	public ShoppingList getShoppingListById(int anyInt2);

	public String saveShoppingList(ShoppingList newList);
	
	public String deleteList(Integer id);
	
	public String deleteItem(Integer id);

	
	
}
