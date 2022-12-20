package com.example.rent_confirmation_project.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rent_confirmation_project.Entity.ObjectHouse;
import com.example.rent_confirmation_project.Entity.Payment;
import com.example.rent_confirmation_project.constants.RentRtnCode;
import com.example.rent_confirmation_project.repository.ObjectHouseDao;
import com.example.rent_confirmation_project.repository.PaymentDao;
import com.example.rent_confirmation_project.service.ifs.RentService;
import com.example.rent_confirmation_project.vo.RentRes;

@Service
public class RentServiceImpl implements RentService {

	@Autowired
	private ObjectHouseDao objectHouseDao;

	@Autowired
	private PaymentDao paymentDao;

	@Override
	public List<RentRes> findObjectHouseAllInfo() {

		List<ObjectHouse> objectHouseList = objectHouseDao.findAll();

		List<Payment> paymentListMatch = paymentDao.findAllOrderByRentForDate();

		return displayRentResList(objectHouseList, paymentListMatch);
	}

	@Override
	public List<RentRes> searchOwnerName(String ownerName) {

		List<ObjectHouse> objectHouseList = objectHouseDao.findByOwnerName(ownerName);

		List<Payment> paymentListMatch = paymentDao.findByPaymentObjectIdInOrderByRentForDateAsc(getObjectIdList(objectHouseList));

		return displayRentResList(objectHouseList, paymentListMatch);
	}

	@Override
	public List<RentRes> searchContractorName(String contractorName) {

		List<ObjectHouse> objectHouseList = objectHouseDao.findByContractorName(contractorName);

		List<Payment> paymentListMatch = paymentDao.findByPaymentObjectIdInOrderByRentForDateAsc(getObjectIdList(objectHouseList));

		return displayRentResList(objectHouseList, paymentListMatch);
	}

	@Override
	public List<RentRes> searchStartAndFinishDate(LocalDate startDate, LocalDate finishDate) {

		List<Payment> paymentListMatch = paymentDao.findByStartAndEndTime(startDate, finishDate);

		Set<Integer> objectIdSet = new HashSet<Integer>();

		for (Payment p : paymentListMatch) {
			objectIdSet.add(p.getPaymentObjectId());
		}

		List<ObjectHouse> objectHouseList = objectHouseDao.findByObjectIdIn(objectIdSet);

		return displayRentResList(objectHouseList, paymentListMatch);

	}

	@Override
	public RentRes updatePaymentDate(int paymentId, LocalDate paymentDate) {

		Payment payment = paymentDao.findById(paymentId).orElse(null);
		if (payment == null) {
			return null;
		}
		payment.setPaymentDate(paymentDate);
		paymentDao.save(payment);
		ObjectHouse objectHouse = objectHouseDao.findById(payment.getPaymentObjectId()).orElse(null);
		if (objectHouse == null) {
			return null;
		}
		return new RentRes(objectHouse, payment, RentRtnCode.SUCCESSFUL.getMessage());
	}

	@Override
	public RentRes updatePaymentAmount(int paymentId, int paymentAmount) {
		Payment payment = paymentDao.findById(paymentId).orElse(null);
		if (payment == null) {
			return new RentRes(RentRtnCode.PAYMENT_IS_NULL.getMessage());
		}
		payment.setPaymentAmount(paymentAmount);
		paymentDao.save(payment);
		ObjectHouse objectHouse = objectHouseDao.findById(payment.getPaymentObjectId()).orElse(null);
		if (objectHouse == null) {
			return new RentRes(RentRtnCode.OBJECTHOUSE_IS_NULL.getMessage());
		}
		return new RentRes(objectHouse, payment, RentRtnCode.SUCCESSFUL.getMessage());
	}

	@Override
	public RentRes updatePaymentMonths(int paymentId, int paymentMonth) {
		Payment payment = paymentDao.findById(paymentId).orElse(null);
		if (payment == null) {
			return new RentRes(RentRtnCode.PAYMENT_IS_NULL.getMessage());
		}
		payment.setPaymentMonths(paymentMonth);
		paymentDao.save(payment);
		ObjectHouse objectHouse = objectHouseDao.findById(payment.getPaymentObjectId()).orElse(null);
		if (objectHouse == null) {
			return new RentRes(RentRtnCode.OBJECTHOUSE_IS_NULL.getMessage());
		}
		return new RentRes(objectHouse, payment, RentRtnCode.SUCCESSFUL.getMessage());
	}

	@Override
	public void checkIsLate() {
		
		List<Payment> paymentList = paymentDao.findLatePayment();
		if (paymentList.isEmpty()) {
			return;
		}
		for (Payment payment : paymentList) {
			payment.setLate(true);
		}
		paymentDao.saveAll(paymentList);
		
	}

	@Override
	public void setIsPay(int paymentId, boolean payBoolean) throws Exception {
		Payment payment = paymentDao.findById(paymentId).orElse(null);
		if (payment == null) {
			throw new Exception("To set isChecked of to do is null");
		}
		payment.setPay(payBoolean);
		paymentDao.save(payment);
	}

//===========================================================	

	private List<RentRes> displayRentResList(List<ObjectHouse> objectHouseList, List<Payment> paymentListMatch) {

		List<RentRes> rentResList = new ArrayList<RentRes>();

		for (ObjectHouse objectHouse : objectHouseList) {

			List<Payment> paymentList = new ArrayList<Payment>();

			for (Payment payment : paymentListMatch) {
				if (objectHouse.getObjectId() == payment.getPaymentObjectId()) {
					paymentList.add(payment);
				}
			}

			RentRes rentRes = new RentRes(objectHouse, paymentList);
			rentResList.add(rentRes);
		}
		return rentResList;
	}

	private List<Integer> getObjectIdList(List<ObjectHouse> objectHouseList) {

		List<Integer> objectIdList = new ArrayList<Integer>();

		for (ObjectHouse o : objectHouseList) {
			objectIdList.add(o.getObjectId());
		}
		return objectIdList;
	}

}
