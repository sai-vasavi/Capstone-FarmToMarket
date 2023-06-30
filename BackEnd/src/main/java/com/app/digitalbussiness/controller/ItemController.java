package com.app.digitalbussiness.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.digitalbussiness.model.ItemsModel;
import com.app.digitalbussiness.model.User;
import com.app.digitalbussiness.repository.ItemRepository;
import com.app.digitalbussiness.repository.RegistartionRepository;
import com.app.digitalbussiness.service.ItemsService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ItemController {
	Logger logger = LoggerFactory.getLogger(ItemController.class);
	@Autowired
	public ItemRepository itemRepository;

	@Autowired
	public RegistartionRepository userRepository;

	@Autowired
	public ItemsService itemService;
	
    /*********Creating ItemData*************/
	@PostMapping("/data")
	public ResponseEntity<ItemsModel>  createItem(@RequestBody @Valid ItemsModel item, @RequestParam("emailId") String emailId) {
		User user = userRepository.findByemailId(emailId);
		logger.info(emailId + "email");
		if (user == null || !user.getRole().equals("Farmer")) {
			throw new IllegalArgumentException("Only farmers can add items.");
		}
		item.setUser(user);
		return new ResponseEntity<>( itemRepository.save(item),HttpStatus.CREATED);
	}
	
	/*********get all ItemData*************/
	@GetMapping("/getItems")
	public ResponseEntity<List<ItemsModel>> getItems() {
		return ResponseEntity.ok(itemService.getAllItems());
	}
	
	/*********get ItemData*************/
	@GetMapping("/getItems/{id}")
	private ResponseEntity<ItemsModel> getEquipmentById(@PathVariable("id") Long id) {
		return ResponseEntity.ok(itemService.getItemById(id)) ;
	}
	
	/*********update ItemData*************/

	@PutMapping("/updateItem/{id}")
	public ResponseEntity<ItemsModel> updateEquipment(@PathVariable Long id, @RequestBody @Valid ItemsModel itemDetails) {
		ItemsModel item = itemService.getItemById(id);

		item.setName(itemDetails.getName());
		item.setPhoto(itemDetails.getPhoto());
		item.setDescription(itemDetails.getDescription());
		item.setQuantityavailable(itemDetails.getQuantityavailable());

		ItemsModel updatedEquipment = itemService.save(item);
		return ResponseEntity.ok(updatedEquipment);
	}

	/*********delete ItemData*************/
	// delete employee rest api
	@DeleteMapping("/item/{id}")
	public void deleteEquipment(@PathVariable Long id) {
		ItemsModel item = itemService.getItemById(id);

		itemService.delete(item);

	}

}
