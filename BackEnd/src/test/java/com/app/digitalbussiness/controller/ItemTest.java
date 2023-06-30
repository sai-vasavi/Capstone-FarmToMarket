/**
 * 
 */
package com.app.digitalbussiness.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.app.digitalbussiness.model.ItemsModel;
import com.app.digitalbussiness.model.User;
import com.app.digitalbussiness.repository.ItemRepository;
import com.app.digitalbussiness.repository.RegistartionRepository;

/**
 * @author BasaniVa
 *
 */
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class ItemTest {

	@Autowired
	ItemRepository repo;

	@Autowired
	RegistartionRepository userRepo;

	@Test
	@Order(1)
	public void testCreate() {
		ItemsModel item = new ItemsModel();
		User user = new User();
		user.setId(1L);
		user.setEmailId("saivasavi@gmail.com");
		user.setPassword("vasavi");
		user.setPhonenumber("75482146");
		user.setCity("dhone");
		user.setState("Andhrapradesh");
		user.setRole("Farmer");
		user.setPincode(215333L);
		userRepo.save(user);

		item.setId(1L);
		item.setName("rice");
		item.setPhoto("/vasavi.png");
		item.setDescription("Rice quality is good");
		item.setUser(user);
		repo.save(item);

		assertNotNull(repo.findById(1L).get());
	}

	@Test
	@Order(2)
	public void testReadAllItems() {
		List<ItemsModel> itemlist = repo.findAll();
		assertThat(itemlist).size().isGreaterThan(0);
	}

	@Test
	@Order(3)
	public void testReadSingleItem() {
		ItemsModel item = repo.findById(1L).get();
		assertEquals("rice", item.getName());
	}

	@Test
	@Order(4)
	public void testUpdateItem() {
		ItemsModel item = repo.findById(1L).get();
		item.setName("Tomato");
		repo.save(item);
		assertNotEquals("Tomato", repo.findById(1l).get());
	}

	@Test
	@Order(5)
	public void testDeleteItem() {
		repo.deleteById(1l);
		assertThat(repo.existsById(1L)).isFalse();

	}

}
