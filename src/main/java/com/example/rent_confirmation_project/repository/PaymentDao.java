package com.example.rent_confirmation_project.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.rent_confirmation_project.Entity.Payment;

@Repository
public interface PaymentDao extends JpaRepository<Payment, Integer> {

	@Query(" select p from Payment p order by rentForDate" )
	public List<Payment> findAllOrderByRentForDate();

	@Query(" select py from Payment py where paymentObjectId = :paymentObjectId order by rentForDate ")
	public List<Payment> findByPaymentObjectId(@Param("paymentObjectId") int paymentObjectId);

	public List<Payment> findByPaymentObjectIdInOrderByRentForDateAsc(List<Integer> paymentObjectIds);

	@Query(" select p from Payment p where rentForDate <= now() "
			+" and paymentDate is null order by rentForDate" )
	public List<Payment> findLatePayment();
//	public List<Payment> doNativeQueryByStartAndEndTime(LocalDate startTime, LocalDate endTime, int pageSize, int startPosition);

	@Query(" select p from ObjectHouse o left join Payment p "
			+" on o.objectId = p.paymentObjectId "
			+" where p.rentForDate between :startTime and :endTime order by p.rentForDate ")
	public List<Payment> findByStartAndEndTime(
			@Param("startTime") LocalDate startTime,
			@Param("endTime") LocalDate endTime);
	
//	@Query(" insert into Payment ( paymentObjectId , paymentMonths , rentForDate , paymentAmount ) "
//			+" values ( :paymentObjectId , :paymentMonths , :rentForDate , :paymentAmount ) ")
//	public void savePaymentInfo(
//			@Param("paymentObjectId") int paymentObjectId ,
//			@Param("paymentMonths") int paymentMonths ,
//			@Param("rentForDate") LocalDate rentForDate ,
//			@Param("paymentAmount") int paymentAmount);
	
}
