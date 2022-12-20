package com.example.rent_confirmation_project.constants;

public enum RentRtnCode {

	SUCCESSFUL("200","SUCCESSFUL"),
	FAILED("500","FAILED"),
	PAYMENT_IS_NULL("400","Payment is null"),
	OBJECTHOUSE_IS_NULL("400","ObjectHouse is null"),
	DATA_REQUIRED("417","請填寫完整資料");
	
	private String code;
	private String message;
	
	private RentRtnCode(String code,String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
}
