package com.example.rent_confirmation_project.vo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class RentResList {

	private List<RentRes> rentResList;
	private String message;
	private String code;
	private int startMonth;
	private int endMonth;

	public RentResList() {

	}

	public RentResList(List<RentRes> rentResList) {
		this.rentResList = rentResList;
	}

	public List<RentRes> getRentResList() {
		return rentResList;
	}

	public void setRentResList(List<RentRes> rentResList) {
		this.rentResList = rentResList;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getStartMonth() {
		return startMonth;
	}

	public void setStartMonth(int startMonth) {
		this.startMonth = startMonth;
	}

	public int getEndMonth() {
		return endMonth;
	}

	public void setEndMonth(int endMonth) {
		this.endMonth = endMonth;
	}

}
