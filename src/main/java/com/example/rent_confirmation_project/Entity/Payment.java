package com.example.rent_confirmation_project.Entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;

@Entity
@Table(name = "payment")
public class Payment {

	@Id
	@Column(name = "payment_id")
	private int paymentId;

	@Column(name = "object_id")
	private int paymentObjectId;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@Column(name = "payment_date")
	private LocalDate paymentDate;

	@Column(name = "payment_months")
	private int paymentMonths;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@Column(name = "rent_for_date")
	private LocalDate rentForDate;

	@Column(name = "payment_amount")
	private int paymentAmount;

//	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
//	@Column(name = "payment_deadline")
//	private LocalDate payment_deadline;

	@Column(name = "late")
	private boolean late;

	@Column(name = "pay")
	private boolean pay;

// =======================================

	public Payment() {

	}

//	public Payment(int paymentId, int paymentObjectId, String paymentDate, int paymentMonths, String rentForDate,
//			int paymentAmount, String payment_deadline, boolean late, boolean pay) {
//		this.paymentId = paymentId;
//		this.paymentObjectId = paymentObjectId;
//		this.paymentDate = paymentDate;
//		this.paymentMonths = paymentMonths;
//		this.rentForDate = rentForDate;
//		this.paymentAmount = paymentAmount;
//		this.payment_deadline = payment_deadline;
//		this.late = late;
//		this.pay = pay;
//
//	}

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public int getPaymentObjectId() {
		return paymentObjectId;
	}

	public void setPaymentObjectId(int paymentObjectId) {
		this.paymentObjectId = paymentObjectId;
	}

	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}

	public int getPaymentMonths() {
		return paymentMonths;
	}

	public void setPaymentMonths(int paymentMonths) {
		this.paymentMonths = paymentMonths;
	}

	public LocalDate getRentForDate() {
		return rentForDate;
	}

	public void setRentForDate(LocalDate rentForDate) {
		this.rentForDate = rentForDate;
	}

	public int getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(int paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

//	public LocalDate getPayment_deadline() {
//		return payment_deadline;
//	}
//
//	public void setPayment_deadline(LocalDate payment_deadline) {
//		this.payment_deadline = payment_deadline;
//	}

	public boolean isLate() {
		return late;
	}

	public void setLate(boolean late) {
		this.late = late;
	}

	public boolean isPay() {
		return pay;
	}

	public void setPay(boolean pay) {
		this.pay = pay;
	}

}
