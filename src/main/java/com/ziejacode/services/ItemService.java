package com.ziejacode.services;

import org.springframework.stereotype.Service;

import com.ziejacode.model.Item;

@Service
public interface ItemService {
	
	public String saveUser(Item item);
	
	public String deleteByItemId(Integer item);
	
}