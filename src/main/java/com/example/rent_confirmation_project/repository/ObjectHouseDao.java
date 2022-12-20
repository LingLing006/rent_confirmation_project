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

//	�ϥ�JPQL�y�k UPDATE �M DELETE �ާ@�A�����ϥε��� @Modifying
//	@Query("select Payment from Payment ") // JPQL�y�k name = :newName�N��n�a�i�Ӫ��Ѽ� �A Register�諸�OEntity���W�r�A��name�諸�OEntity���ܼƦW��
	public List<ObjectHouse> findAll(); 
																													// ��Ѽ�newName,newAge,newCity,account
//	public List<ObjectHouse> doNativeQueryByExpiredRegTime(Date date, int pageSize, int startPosition) ;																								// ")


	public List<ObjectHouse> findByOwnerName(String ownerName);
	public List<ObjectHouse> findByContractorName(String contractorName);
	public List<ObjectHouse> findByObjectIdIn(Set<Integer> objectIds);
}
