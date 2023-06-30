/**
 * 
 */
package com.app.digitalbussiness.controller;

import java.util.List;

import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.RestController;

import com.app.digitalbussiness.model.Equipment;
import com.app.digitalbussiness.service.EquipmentService;

/**
 * @author BasaniVa
 *
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EqupimentController {

	@Autowired
	private EquipmentService equipmentService;

	@PostMapping("/equipment")
	public ResponseEntity<Object> equipment(@RequestBody @Valid Equipment equipment) {
		
		equipment = equipmentService.saveEquipment(equipment);
		return new ResponseEntity<>(
				"Employee is created successfully with Id = " + equipment.getEquipmentId(),
				HttpStatus.CREATED);
		//return new ResponseEntity<>(equipmentService.saveEquipment(equipment),HttpStatus.CREATED);
	}

	@GetMapping("/allequipments")
	public ResponseEntity<List<Equipment>> getEquipments() {
		return ResponseEntity.ok(equipmentService.getAllEquipments());
	}

	@GetMapping("/equipment/{equipmentId}")
	private ResponseEntity<Object> getEquipmentById(@PathVariable("equipmentId") Long equipmentId) {
		return ResponseEntity.ok(equipmentService.getEquipmentById(equipmentId));
	}

	@PutMapping("/equipment/{id}")
	public ResponseEntity<Equipment> updateEquipment(@PathVariable Long id, @RequestBody @Valid Equipment equipmentDetails) {
		Equipment equipment = equipmentService.getEquipmentById(id);

		equipment.setEquipmentname(equipmentDetails.getEquipmentname());
		equipment.setEpincode(equipmentDetails.getEpincode());
		equipment.setEcity(equipmentDetails.getEcity());
		equipment.seteImage(equipmentDetails.geteImage());
		equipment.setEstate(equipmentDetails.getEstate());
		equipment.setEvillage(equipmentDetails.getEvillage());
		equipment.setEcontact(equipmentDetails.getEcontact());
		equipment.setRentDay(equipmentDetails.getRentDay());
		equipment.setEnumber(equipmentDetails.getEnumber());
		equipment.setEcount(equipmentDetails.getEcount());

		Equipment updatedEmployee = equipmentService.save(equipment);
		return ResponseEntity.ok(updatedEmployee);
	}

	// delete employee rest api
	@DeleteMapping("/equipment/{id}")
	public void deleteEquipment(@PathVariable Long id) {
		Equipment equipment = equipmentService.getEquipmentById(id);

		equipmentService.delete(equipment);

	}

}
