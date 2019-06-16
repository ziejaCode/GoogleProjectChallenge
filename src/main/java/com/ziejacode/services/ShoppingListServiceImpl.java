package com.ziejacode.services;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.ziejacode.model.ShoppingList;
import com.ziejacode.model.User;
import com.ziejacode.repositories.ShoppingListRepository;
import com.ziejacode.repositories.UserRepository;


@Service
public class ShoppingListServiceImpl implements ShoppingListService{
	
	private final UserRepository userRepository;
	private final ShoppingListRepository shoppingListRepository;
	
	
	public ShoppingListServiceImpl(UserRepository userRepository, ShoppingListRepository shoppingListRepository) {
		this.shoppingListRepository = shoppingListRepository;
		this.userRepository = userRepository;
	}



	@Override
	public ShoppingList getShoppingListById(int id) {
		
		Optional<ShoppingList> shoppingListOptional = shoppingListRepository.findById(id);
		
		if (!shoppingListOptional.isPresent()) {
            throw new RuntimeException("shoppingList not Found! " + id);
        }		
		ShoppingList shoppingList = shoppingListOptional.get();
		
		return shoppingList;
	}

	@Override
	public String saveShoppingList(ShoppingList newList) {
		shoppingListRepository.save(newList);
		return "List saved";
	}


	@Override
	public String deleteList(Integer id) {
		shoppingListRepository.deleteById(id);
		return "Usere no. " + id + " was deleted";
	}
	
	
	@Override
	public String deleteItem(Integer id) {
		shoppingListRepository.deleteById(id);
		return "Usere no. " + id + " was deleted";
	}
	


}
