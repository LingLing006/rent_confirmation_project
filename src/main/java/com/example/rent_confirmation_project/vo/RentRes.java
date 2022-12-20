package com.example.rent_confirmation_project.vo;

import java.util.List;

import com.example.rent_confirmation_project.Entity.ObjectHouse;
import com.example.rent_confirmation_project.Entity.Payment;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class RentRes {

	private ObjectHouse objectHouse;
	private Payment payment;
	private List<Payment> paymentList;
	private String message ;
	
	public RentRes() {
		
	}
	
	public RentRes(ObjectHouse objectHouse , List<Payment> paymentList , String message) {
		this.objectHouse = objectHouse;
		this.paymentList = paymentList;
		this.message = message;
	}
	
	public RentRes(ObjectHouse objectHouse , List<Payment> paymentList) {
		this.objectHouse = objectHouse;
		this.paymentList = paymentList;
	}
	
	public RentRes(ObjectHouse objectHouse , Payment payment , String message) {
		this.objectHouse = objectHouse;
		this.payment = payment;
		this.message = message;
	}
	
	public RentRes(String message) {
		this.message = message;
	}
	
	public ObjectHouse getObjectHouse() {
		return objectHouse;
	}
	public void setObjectHouse(ObjectHouse objectHouse) {
		this.objectHouse = objectHouse;
	}
	public List<Payment> getPaymentList() {
		return paymentList;
	}
	public void setPaymentList(List<Payment> paymentList) {
		this.paymentList = paymentList;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
