package com.example.rent_confirmation_project.service.ifs;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.example.rent_confirmation_project.vo.RentReq;
import com.example.rent_confirmation_project.vo.RentRes;

public interface RentService {

	public List<RentRes> findObjectHouseAllInfo();
	
	public List<RentRes> searchOwnerName(String ownerName); //List<ObjectHouse>,List<Payment>
	public List<RentRes> searchContractorName(String contractorName); //List<ObjectHouse>,List<Payment>
	public List<RentRes> searchStartAndFinishDate(LocalDate startDate , LocalDate finishDate); //List<ObjectHouse>,List<Payment>
	
	public RentRes updatePaymentDate(int paymentId , LocalDate paymentDate);
	public RentRes updatePaymentAmount(int paymentId ,int paymentAmount);
	public RentRes updatePaymentMonths(int paymentId ,int paymentMonth);
	
	public void checkIsLate();
	
	public void setIsPay (int paymentId , boolean payBoolean) throws Exception;
}
