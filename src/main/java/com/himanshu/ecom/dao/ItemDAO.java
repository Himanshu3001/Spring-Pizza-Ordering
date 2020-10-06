package com.himanshu.ecom.dao;

import java.util.List;

import com.himanshu.ecom.entity.Item;


public interface ItemDAO {
	
	List<Item> displayItems();
	
	List<Item> findItemById(List<Integer> itemIDs);

}
