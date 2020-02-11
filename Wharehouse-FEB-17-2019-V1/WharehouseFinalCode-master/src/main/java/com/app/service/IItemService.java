package com.app.service;

import java.util.List;
import java.util.Map;

import com.app.model.Item;

public interface IItemService {

	public Integer saveItem(Item item);
	public void updateItem(Item item);
	public void deleteItem(Integer itemId);
	public Item getItemById(Integer itemId);
	public List<Item> getAllItems();
	public boolean isItemCodeExist(String itemCode);
	public Map<Integer, String> getItemIdNameCode();
	
}
