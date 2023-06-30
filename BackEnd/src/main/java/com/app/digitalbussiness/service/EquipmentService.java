/**
 * 
 */
package com.app.digitalbussiness.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.digitalbussiness.exception.NoSuchElementFoundException;
import com.app.digitalbussiness.model.Equipment;
import com.app.digitalbussiness.repository.EqupimentRepository;

/**
 * @author BasaniVa
 *
 */
@Service
public class EquipmentService {

	@Autowired
	private EqupimentRepository equpimentRepository;

	public Equipment saveEquipment(Equipment equipment) {
		return equpimentRepository.save(equipment);
	}

	public List<Equipment> getAllEquipments() {
		// TODO Auto-generated method stub
		return equpimentRepository.findAll();
	}

	public Equipment getEquipmentById(Long equipmentId)throws NoSuchElementFoundException {
		Equipment equipment= equpimentRepository.findByEquipmentId(equipmentId);
        if(equipment!=null){
            return equipment;
        }else{
            throw new NoSuchElementFoundException();
        }
		//return equpimentRepository.findById(equipmentId).get();
	}

	public Equipment updateEquipmentById(Long equipmentId) {
		// TODO Auto-generated method stub
		return equpimentRepository.save(null);
	}
	



	public Equipment save(Equipment equipment) {
		// TODO Auto-generated method stub
		return equpimentRepository.save(equipment);
	}
	
	

	public void delete(Equipment equipment) {
		// TODO Auto-generated method stub
		 equpimentRepository.delete(equipment);
	}}
