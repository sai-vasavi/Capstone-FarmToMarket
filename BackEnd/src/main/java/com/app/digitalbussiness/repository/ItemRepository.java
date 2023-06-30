/**
 * 
 */
package com.app.digitalbussiness.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.digitalbussiness.model.ItemsModel;

/**
 * @author BasaniVa
 *
 */
@Repository
public interface ItemRepository extends JpaRepository<ItemsModel, Long>{

}
