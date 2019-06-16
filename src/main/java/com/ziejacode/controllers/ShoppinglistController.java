package com.ziejacode.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ziejacode.model.Item;
import com.ziejacode.model.ShoppingList;
import com.ziejacode.model.User;
import com.ziejacode.services.ItemService;
import com.ziejacode.services.ShoppingListService;
import com.ziejacode.services.UserService;

@Controller
public class ShoppinglistController {
	
	private final UserService userService;
	private final ShoppingListService shoppingListService;
	private final ItemService itemService;
	private Integer userId;
	private Integer lId;
	
	public ShoppinglistController(UserService userService, ShoppingListService shoppingListService, ItemService itemService) {		
		this.userService = userService;
		this.shoppingListService = shoppingListService;
		this.itemService = itemService;
	}

	@GetMapping
	@RequestMapping("/user/{id}/showShoppingLists")
	public String getAllShoppingLists(@PathVariable Integer id,  Model model ) {
		
		model.addAttribute("user", userService.getUserByUserId(id));
		return "user/shoppingList/showShoppingLists";
	}
	
	
	@GetMapping
	@RequestMapping("/user/{id}/shoppingList/{listId}/showShoppingList")
	public String getIndividualShoppingList(@PathVariable Integer id, @PathVariable Integer listId, Model model ) {		
		
		model.addAttribute("user", userService.getUserByUserId(id));
		model.addAttribute("shoppingList", shoppingListService.getShoppingListById(listId));
		
		return "/user/shoppingList/showShoppingList";
	}
	
	@GetMapping
    @RequestMapping("/user/{id}/createShoppingList")
    public String  createShoppingList(@PathVariable Integer id, Model model) {
		userId = id;
		User user = userService.getUserByUserId(id);
    	model.addAttribute("shoppingList", new ShoppingList());
    	model.addAttribute("user", user); 
    	return "user/shoppingList/createShoppingList";
    } 
	
	
	@GetMapping
    @RequestMapping("/createShoppingList")
    public String saveShoppingList(@ModelAttribute ShoppingList newList) {
    	
		List<ShoppingList>shoppingLists;
		
		User user = userService.getUserByUserId(userId);
		shoppingLists = user.getShoppingLists();
		shoppingLists.add(newList);
		
		userService.saveUser(user);
		shoppingLists = null;
		
		userService.getUserByUserId(userId);
		shoppingLists = user.getShoppingLists();
		
		int localId = userId;
		
		userId = null;
    	
    	return "redirect:/user/" + localId + "/showShoppingLists/"; 
		
    } 
	
	
	
	
	@GetMapping
    @RequestMapping("/user/{id}/shoppingList/{listId}/createItem")
    public String  createItem(@PathVariable Integer id, @PathVariable Integer listId,  Model model) {
		//@PathVariable Integer id,
		userId = id;
		lId = listId;
		User user = userService.getUserByUserId(id);
		model.addAttribute("user", user); 
    	model.addAttribute("shoppingList", shoppingListService.getShoppingListById(listId));
    	model.addAttribute("item", new Item()); 
    	
    	return "/user/shoppingList/createItem";
    } 
	
	
	@GetMapping
    @RequestMapping("/createItem")
    public String saveItem(@ModelAttribute Item newItem) {
    	
		List<Item>items;
		ShoppingList shoppingList = null;
		List<ShoppingList>shoppingLists;
		
		User user = userService.getUserByUserId(userId);
		shoppingLists = user.getShoppingLists();
		
		System.out.println("First size is " + shoppingLists.size());
		
		for(ShoppingList sL: shoppingLists) {
			if(sL.getShoppinglistId() == lId){
				shoppingList = sL;
				break;
			}
		}
		
		items = shoppingList.getItems();
		
		items.add(newItem);
		
		userService.saveUser(user);
		
		shoppingLists = null;
		
		userService.getUserByUserId(userId);
		
		shoppingLists = user.getShoppingLists();
		
		int localId = userId;		
		userId = null;
		int locallId = lId;
		lId = null;
    	
    	return "redirect:/user/" + localId + "/shoppingList/" + locallId + "/showShoppingList/"; 
		
    }
	
	
	
	// User deleting methods   
    @GetMapping
    @RequestMapping("/user/{id}/shoppingList/{listId}/delete")
    public String deleteShoppingListById(@PathVariable Integer id, @PathVariable Integer listId) {
    	
    	System.out.println("List to delete is " + listId + " for user no " + id); 
    	
    	shoppingListService.deleteList(listId);    	
    	//return "redirect:/user/shoppingList/showShoppingLists/"; 
    	return "redirect:/user/{id}/showShoppingLists";
    }
    
    //@Transactional
    @GetMapping
    @RequestMapping("/user/{id}/shoppingList/{listId}/deleteItem/{itemId}")
    public String deleteItemByUserName(@PathVariable Integer id, @PathVariable Integer listId, @PathVariable Integer itemId) {
    	
    	System.out.println("deleting item no " + itemId);
    	
    	itemService.deleteByItemId(itemId);    	    	
    	
    	return "redirect:/user/" + id + "/shoppingList/" + listId + "/showShoppingList/"; 
    }  
	
	
	
	
	
	
	

}
