package com.example.rent_confirmation_project.Entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "object_house")
public class ObjectHouse {

	@Id
	@Column(name = "object_id")
	private int objectId;
	
	@Column(name = "owner_name")
	private String ownerName;
	
	@Column(name = "object_name")
	private String objectName;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "contractor_name")
	private String contractorName;
	
	@Column(name = "rent")
	private int rent;
	
	@Column(name = "exist")
	private boolean exist;
	
//=============================================
	
	public ObjectHouse() {
		
	}

	public int getObjectId() {
		return objectId;
	}

	public void setObjectId(int objectId) {
		this.objectId = objectId;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getObjectName() {
		return objectName;
	}

	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContractorName() {
		return contractorName;
	}

	public void setContractorName(String contractorName) {
		this.contractorName = contractorName;
	}

	public int getRent() {
		return rent;
	}

	public void setRent(int rent) {
		this.rent = rent;
	}

	public boolean isExist() {
		return exist;
	}

	public void setExist(boolean exist) {
		this.exist = exist;
	}
		
	
//	private LinkedHashSet<Payment> a;
}
