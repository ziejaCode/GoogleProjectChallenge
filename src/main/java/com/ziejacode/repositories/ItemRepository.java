package com.ziejacode.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ziejacode.model.Item;

public interface ItemRepository extends CrudRepository<Item, Integer>{

}
