package com.himanshu.ecom.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.himanshu.ecom.dao.ItemDAO;
import com.himanshu.ecom.entity.Item;


@Service
public class ItemServiceImpl implements ItemService {

	private final ItemDAO itemDao;
	
	public ItemServiceImpl(ItemDAO dao)
	{
		this.itemDao=dao;
	}
	
	@Transactional
	@Override
	public List<Item> displayItems() {
		
		return itemDao.displayItems();
	}

	@Transactional
	@Override
	public List<Item> findItemById(List<Integer> itemIDs) {
		
		return itemDao.findItemById(itemIDs);
	}

}
