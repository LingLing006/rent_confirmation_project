package com.example.rent_confirmation_project.repository;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Parameter;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.util.CollectionUtils;

public class BaseDao {

	@PersistenceContext // Jpa專有註釋
	private EntityManager entityManager;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected <EntityType> List<EntityType> doNativeQuery(String nativeSql, Map<String, Object> params,
			Class<EntityType> clazz, int pageSize, int startPosition) { // 無分頁筆數

		Query query = null;

		if (clazz == null) {
			query = entityManager.createNativeQuery(nativeSql);
		} else {
			query = entityManager.createNativeQuery(nativeSql, clazz);
		}

		if (!CollectionUtils.isEmpty(params)) {
			for (Parameter p : query.getParameters()) { // 方法二 : query.getParameters()會回傳一個 Set的清單 ，裡面的資料型態是Parameter
				query.setParameter(p, params.get(p.getName()));
			}
		}
		
		if (pageSize > 0) {
			query.setMaxResults(pageSize);
		}
		if (startPosition >= 0) {
			query.setFirstResult(startPosition);
		}
		return query.getResultList();
	}
}
