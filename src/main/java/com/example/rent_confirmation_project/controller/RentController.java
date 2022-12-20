package com.example.rent_confirmation_project.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.rent_confirmation_project.service.ifs.RentService;
import com.example.rent_confirmation_project.vo.RentReq;
import com.example.rent_confirmation_project.vo.RentRes;
import com.example.rent_confirmation_project.vo.RentResList;

@CrossOrigin
@RestController
public class RentController {

	@Autowired
	private RentService rentService;

	@PostMapping("/api/findObjectHouseAllInfo")
	public RentResList findObjectHouseAllInfo() {
		RentResList rentResList = new RentResList(rentService.findObjectHouseAllInfo());
		return rentResList;

	}

	@PostMapping("/api/searchOwnerName")
	public RentResList searchOwnerName(@RequestBody RentReq req) {
		RentResList rentResList = new RentResList(rentService.searchOwnerName(req.getOwnerName()));
		return rentResList;

	}

	@PostMapping("/api/searchContractorName")
	public RentResList searchContractorName(@RequestBody RentReq req) {
		RentResList rentResList = new RentResList(rentService.searchContractorName(req.getContractorName()));
		return rentResList;

	}

	@PostMapping("/api/searchStartAndFinishDate")
	public RentResList searchStartAndFinishDate(@RequestBody RentReq req) {
		
		RentResList rentResList = new RentResList();
		rentResList.setRentResList(rentService.searchStartAndFinishDate(req.getStartTime(), req.getEndTime()));
		if(req.getStartTime().getDayOfMonth()==1) {
			rentResList.setStartMonth(req.getStartTime().getMonthValue());
		}else {
			rentResList.setStartMonth(req.getStartTime().getMonthValue()+1);
		}
		
		rentResList.setEndMonth(req.getEndTime().getMonthValue());
		
		return rentResList;

	}

	@PostMapping("/api/checkIsLate")
	public void checkIsLate() {
		rentService.checkIsLate();
	}

	@PostMapping(value = "/api/updatePaymentDate")
	public RentRes updatePaymentDate(@RequestBody RentReq req) {
		return null;

	}

	@PostMapping(value = "/api/updatePaymentAmount")
	public RentRes updatePaymentAmount(@RequestBody RentReq req) {
		return null;

	}

	@PostMapping(value = "/api/updatePaymentMonths")
	public RentRes updatePaymentMonths(@RequestBody RentReq req) {
		return null;

	}
}
