package com.query.nativequery;

import java.util.Map;

import javax.persistence.EntityManager;

import com.query.query.Query;
import com.query.resultset.ResultSet;

/**
 * {@link Query} to execute named native queries
 * 
 * @author <a href="mailto:mauricionrgarcia@gmail.com">Mauricio</a>
 * @version
 * @sinse 08/04/2018 00:24:22
 * @param <T> DTO return
 */
public class JpaNamedNativeQuery<T> extends Query<T> {

	/**
	 * Contructos with args:
	 * 
	 * @param name name
	 * @param resultSet {@link ResultSet}
	 * @param resultClass return type
	 */
	public JpaNamedNativeQuery(String name, ResultSet<T> resultSet, Class<T> resultClass) {
		super(name, resultSet, resultClass);
	}

	/**
	 * Contructos with args:
	 * 
	 * @param name name
	 * @param resultSet {@link ResultSet}
	 * @param resultClass return type
	 * @param params filters
	 */
	public JpaNamedNativeQuery(String name, ResultSet<T> resultSet, Class<T> resultClass, Map<String, Object> params) {
		super(name, resultSet, resultClass, params);
	}

	public javax.persistence.Query getQuery(EntityManager em) {
		return em.createNamedQuery(super.getName());
	}
}
