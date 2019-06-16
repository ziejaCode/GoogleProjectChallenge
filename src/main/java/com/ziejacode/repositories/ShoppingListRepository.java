package com.ziejacode.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ziejacode.model.ShoppingList;

public interface ShoppingListRepository extends CrudRepository<ShoppingList, Integer>{

}
