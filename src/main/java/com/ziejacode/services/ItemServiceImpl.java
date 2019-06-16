package com.ziejacode.services;

import org.springframework.stereotype.Service;

import com.ziejacode.model.Item;
import com.ziejacode.repositories.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService{

	ItemRepository itemRepository;
	
	public ItemServiceImpl(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}

	@Override
	public String saveUser(Item item) {
		return null;
	}

	@Override
	public String deleteByItemId(Integer itemId) {
		itemRepository.deleteById(itemId);
		return null;
	}
	

}
