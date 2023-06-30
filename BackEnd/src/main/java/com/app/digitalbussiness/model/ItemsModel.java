/**
 * 
 */
package com.app.digitalbussiness.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author BasaniVa
 *
 */
@Entity
@Table(name = "Items")
public class ItemsModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	@Lob
	@Column(name = "photo")
	private String photo;

	private String description;

	private BigDecimal quantityavailable;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the photo
	 */
	public String getPhoto() {
		return photo;
	}

	/**
	 * @param photo the photo to set
	 */
	public void setPhoto(String photo) {
		this.photo = photo;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the quantityavailable
	 */
	public BigDecimal getQuantityavailable() {
		return quantityavailable;
	}

	/**
	 * @param quantityavailable the quantityavailable to set
	 */
	public void setQuantityavailable(BigDecimal quantityavailable) {
		this.quantityavailable = quantityavailable;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	public ItemsModel() {
		super();
	}

	public ItemsModel(Long id, String name, String photo, String description, BigDecimal quantityavailable, User user) {
		super();
		this.id = id;
		this.name = name;
		this.photo = photo;
		this.description = description;
		this.quantityavailable = quantityavailable;
		this.user = user;
	}

	@Override
	public String toString() {
		return "ItemsModel [id=" + id + ", name=" + name + ", photo=" + photo + ", description=" + description
				+ ", quantityavailable=" + quantityavailable + ", user=" + user + "]";
	}

}
