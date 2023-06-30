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

import com.app.digitalbussiness.model.Equipment;
import com.app.digitalbussiness.repository.EqupimentRepository;




/**
 * @author BasaniVa
 * @param <User>
 *
 */
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class EquipmentTest {


	@Autowired
	EqupimentRepository repo;
	
	@Test
	@Order(1)
	public void testCreate() {
		Equipment equipment= new Equipment();
		
equipment.setEquipmentId(1L);
equipment.setEquipmentname("saivasavi");
equipment.seteImage("/vasavi.png");
equipment.setEcount(754);
equipment.setEcity("dhone");
equipment.setRentDay(365L);
equipment.setEnumber(8374129148L);
equipment.setEpincode(215333L);
equipment.setEstate("Ap");
equipment.setEvillage("dhone");
		repo.save(equipment);
		assertNotNull(repo.findById(1L).get());
	}
	
	@Test
	@Order(2)
	public void testReadAllEquipmentss() {
		List<Equipment> equipmentlist = repo.findAll();
		assertThat(equipmentlist).size().isGreaterThan(0);
	}
	
	@Test
	@Order(3)
	public void testReadSingleEquipment() {
		Equipment equipment = repo.findById(1L).get();
		assertEquals("saivasavi", equipment.getEquipmentname());
	}

	@Test
	@Order(4)
	public void testUpdateEquipment() {
		Equipment equipment = repo.findById(1L).get();
		equipment.setEnumber(8374129148L);
		repo.save(equipment);
		assertNotEquals("8374129148", repo.findById(1l).get());
	}
	
	@Test
	@Order(5)
	public void testDeleteEquipment() {
		repo.deleteById(1l);
		assertThat(repo.existsById(1L)).isFalse();
		
	}
	
}
