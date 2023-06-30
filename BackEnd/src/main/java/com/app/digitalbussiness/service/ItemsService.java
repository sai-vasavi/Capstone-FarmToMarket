/**
 * 
 */
package com.app.digitalbussiness.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.digitalbussiness.model.ItemsModel;
import com.app.digitalbussiness.repository.ItemRepository;

/**
 * @author BasaniVa
 *
 */
@Service
public class ItemsService {

	@Autowired
	public ItemRepository itemRepository;

	public List<ItemsModel> getAllItems() {
		// TODO Auto-generated method stub
		return itemRepository.findAll();
	}

	public ItemsModel getItemById(Long id) {

		return itemRepository.findById(id).orElseThrow();
	}

	public ItemsModel save(ItemsModel item) {
		// TODO Auto-generated method stub
		return itemRepository.save(item);
	}

	public void delete(ItemsModel item) {
		// TODO Auto-generated method stub
		itemRepository.delete(item);
	}

}
