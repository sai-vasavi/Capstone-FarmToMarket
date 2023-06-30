package com.app.digitalbussiness;

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

import com.app.digitalbussiness.model.User;
import com.app.digitalbussiness.repository.RegistartionRepository;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class DigitalBussinessApplicationTests {

//	@Test
//	void contextLoads() {
//	}

	@Autowired
	RegistartionRepository repo;

	@Test
	@Order(1)
	public void testCreate() {
		User user = new User();
		user.setId(1L);
		user.setEmailId("saivasavi@gmail.com");
		user.setPassword("vasavi");
		user.setPhonenumber("75482146");
		user.setCity("dhone");
		user.setState("Andhrapradesh");
		user.setRole("Farmer");
		user.setPincode(215333L);
		repo.save(user);
		assertNotNull(repo.findById(1L).get());
	}

	@Test
	@Order(2)
	public void testReadAllUsers() {
		List<User> list = repo.findAll();
		assertThat(list).size().isGreaterThan(0);
	}

	@Test
	@Order(3)
	public void testReadSingleUser() {
		User user = repo.findById(1L).get();
		assertEquals("saivasavi@gmail.com", user.getEmailId());
	}

	@Test
	@Order(4)
	public void testUpdateUser() {
		User user = repo.findById(1L).get();
		user.setPhonenumber("8374129148");
		repo.save(user);
		assertNotEquals("8374129148", repo.findById(1l).get());
	}

	@Test
	@Order(5)
	public void testDeleteUser() {
		repo.deleteById(1l);
		assertThat(repo.existsById(1L)).isFalse();

	}
}
