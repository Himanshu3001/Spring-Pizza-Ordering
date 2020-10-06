package com.himanshu.ecom.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.himanshu.ecom.entity.Item;

@Service
public interface ItemService {
	
	List<Item> displayItems();
	
	List<Item> findItemById(List<Integer> itemIDs);

}
