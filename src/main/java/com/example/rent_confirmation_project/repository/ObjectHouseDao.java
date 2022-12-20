package com.example.rent_confirmation_project.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.rent_confirmation_project.Entity.ObjectHouse;

@Repository
public interface ObjectHouseDao extends JpaRepository<ObjectHouse, Integer> {

//	使用JPQL語法 UPDATE 和 DELETE 操作，必須使用註釋 @Modifying
//	@Query("select Payment from Payment ") // JPQL語法 name = :newName代表要帶進來的參數 ， Register對的是Entity的名字，而name對的是Entity的變數名稱
	public List<ObjectHouse> findAll(); 
																													// 放參數newName,newAge,newCity,account
//	public List<ObjectHouse> doNativeQueryByExpiredRegTime(Date date, int pageSize, int startPosition) ;																								// ")


	public List<ObjectHouse> findByOwnerName(String ownerName);
	public List<ObjectHouse> findByContractorName(String contractorName);
	public List<ObjectHouse> findByObjectIdIn(Set<Integer> objectIds);
}
