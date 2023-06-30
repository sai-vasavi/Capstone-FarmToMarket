/**
 * 
 */
package com.app.digitalbussiness.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.digitalbussiness.model.Equipment;

/**
 * @author BasaniVa
 *
 */
@Repository
public interface EqupimentRepository extends JpaRepository<Equipment, Long> {

	Equipment findByEquipmentId(Long equipmentId);

}
