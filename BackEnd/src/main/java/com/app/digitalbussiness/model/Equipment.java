/**
 * 
 */
package com.app.digitalbussiness.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

/**
 * @author BasaniVa
 *
 */
@Entity
public class Equipment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long equipmentId;

	private String equipmentname;
	
	@Lob
	@Column(columnDefinition = "MEDIUMBLOB")
	private String eImage;
	
	private Integer ecount;
	private Long rentDay;
	private String estate;
	private String ecity;
	private String evillage;
	private Long epincode;
	private String econtact;
	private Long enumber;

	public Equipment() {
		super();
	}

	/**
	 * @return the equipmentId
	 */
	public Long getEquipmentId() {
		return equipmentId;
	}

	/**
	 * @param equipmentId the equipmentId to set
	 */
	public void setEquipmentId(Long equipmentId) {
		this.equipmentId = equipmentId;
	}

	/**
	 * @return the equipmentname
	 */
	public String getEquipmentname() {
		return equipmentname;
	}

	/**
	 * @param equipmentname the equipmentname to set
	 */
	public void setEquipmentname(String equipmentname) {
		this.equipmentname = equipmentname;
	}

	/**
	 * @return the eImage
	 */
	public String geteImage() {
		return eImage;
	}

	/**
	 * @param eImage the eImage to set
	 */
	public void seteImage(String eImage) {
		this.eImage = eImage;
	}

	/**
	 * @return the ecount
	 */
	public Integer getEcount() {
		return ecount;
	}

	/**
	 * @param ecount the ecount to set
	 */
	public void setEcount(Integer ecount) {
		this.ecount = ecount;
	}

	/**
	 * @return the rentDay
	 */
	public Long getRentDay() {
		return rentDay;
	}

	/**
	 * @param rentDay the rentDay to set
	 */
	public void setRentDay(Long rentDay) {
		this.rentDay = rentDay;
	}

	/**
	 * @return the estate
	 */
	public String getEstate() {
		return estate;
	}

	/**
	 * @param estate the estate to set
	 */
	public void setEstate(String estate) {
		this.estate = estate;
	}

	/**
	 * @return the ecity
	 */
	public String getEcity() {
		return ecity;
	}

	/**
	 * @param ecity the ecity to set
	 */
	public void setEcity(String ecity) {
		this.ecity = ecity;
	}

	/**
	 * @return the evillage
	 */
	public String getEvillage() {
		return evillage;
	}

	/**
	 * @param evillage the evillage to set
	 */
	public void setEvillage(String evillage) {
		this.evillage = evillage;
	}

	/**
	 * @return the epincode
	 */
	public Long getEpincode() {
		return epincode;
	}

	/**
	 * @param epincode the epincode to set
	 */
	public void setEpincode(Long epincode) {
		this.epincode = epincode;
	}

	/**
	 * @return the econtact
	 */
	public String getEcontact() {
		return econtact;
	}

	/**
	 * @param econtact the econtact to set
	 */
	public void setEcontact(String econtact) {
		this.econtact = econtact;
	}

	/**
	 * @return the enumber
	 */
	public Long getEnumber() {
		return enumber;
	}

	/**
	 * @param enumber the enumber to set
	 */
	public void setEnumber(Long enumber) {
		this.enumber = enumber;
	}

	public Equipment(Long equipmentId, String equipmentname, String eImage, Integer ecount, Long rentDay, String estate,
			String ecity, String evillage, Long epincode, String econtact, Long enumber) {
		super();
		this.equipmentId = equipmentId;
		this.equipmentname = equipmentname;
		this.eImage = eImage;
		this.ecount = ecount;
		this.rentDay = rentDay;
		this.estate = estate;
		this.ecity = ecity;
		this.evillage = evillage;
		this.epincode = epincode;
		this.econtact = econtact;
		this.enumber = enumber;
	}

	@Override
	public String toString() {
		return "Equipment [equipmentId=" + equipmentId + ", equipmentname=" + equipmentname + ", eImage=" + eImage
				+ ", ecount=" + ecount + ", rentDay=" + rentDay + ", estate=" + estate + ", ecity=" + ecity
				+ ", evillage=" + evillage + ", epincode=" + epincode + ", econtact=" + econtact + ", enumber="
				+ enumber + "]";
	}

}
