package com.example.rent_confirmation_project;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.rent_confirmation_project.Entity.ObjectHouse;
import com.example.rent_confirmation_project.Entity.Payment;
import com.example.rent_confirmation_project.repository.ObjectHouseDao;
import com.example.rent_confirmation_project.repository.PaymentDao;
import com.example.rent_confirmation_project.service.ifs.RentService;

@SpringBootTest
class RentConfirmationProjectApplicationTests {

	@Autowired
	private ObjectHouseDao objectHouseDao;

	@Autowired
	private PaymentDao paymentDao;

	@Autowired
	private RentService rentService;

	@Test
	void contextLoads() {

		List<Payment> list = paymentDao.findLatePayment();
		for (Payment payment : list) {
			System.out.printf("objectId:%d , RentForDat:%s \n", payment.getPaymentObjectId(),
					payment.getRentForDate().toString());
		}
	}

	@Test
	void contextLoadstest() {

		List<Payment> list = paymentDao.findByPaymentObjectId(3);
		for (Payment payment : list) {
			System.out.printf("objectId:%d , ownerName:%s \n", payment.getPaymentObjectId(),
					payment.getPaymentDate().toString());
		}
	}

	@Test
	void startAndEndTimeTest() {

		LocalDate start = LocalDate.of(2022, 10, 01);
		LocalDate end = LocalDate.of(2022, 12, 31);
		List<Payment> list = paymentDao.findByStartAndEndTime(start, end);
		for (Payment payment : list) {
			System.out.printf("objectId:%d , Payment_deadline:%s \n", payment.getPaymentObjectId(),
					payment.getPaymentDate().toString());
		}
	}

	@Test
	void insertInto() {

//		List<Payment> pList = new ArrayList<>();
		Payment p = new Payment();
		int id = 6 ;
		p.setPaymentObjectId(id);
		p.setPaymentAmount(objectHouseDao.findById(id).get().getRent());
		p.setPaymentMonths(1);

		for (int i = 1; i <= 12; i++) {
			LocalDate date = LocalDate.of(2022, i, 01);
			p.setRentForDate(date);
			paymentDao.save(p);
		}
		
	}

	@Test
	void findRentByObjectId() {

	}

}
