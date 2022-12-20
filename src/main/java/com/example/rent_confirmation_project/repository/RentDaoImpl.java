package com.example.rent_confirmation_project.repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.rent_confirmation_project.Entity.ObjectHouse;
import com.example.rent_confirmation_project.Entity.Payment;
import com.example.rent_confirmation_project.vo.RentRes;


public class RentDaoImpl extends BaseDao {

	public List<Payment> doNativeQueryByStartAndEndTime(LocalDate startTime, LocalDate endTime, int pageSize, int startPosition) {
		StringBuffer sb = new StringBuffer();
		sb.append(" select payment p from objectHouse o ")
		.append(" left join p ")
		.append(" on o.object_id = p.object_id ")
		.append(" where p.payment_date between ':startTime' and ':endTime' ");
				
		Map<String, Object> params = new HashMap<>();
		params.put("startTime", startTime);
		params.put("endTime", endTime);
		
		return doNativeQuery(sb.toString(), params, null, pageSize, startPosition);
//p.object_id , p.payment_date , p.payment_months , p.rent_for_date , p.payment_amount , p.payment_deadline , p.late , p.pay
	}
}
