package com.query.nativequery;

import javax.persistence.EntityManager;

import com.query.query.Query;
import com.query.resultset.ResultSet;

/**
 * {@link Query} to execute native queries
 * 
 * @author <a href="mailto:mauricionrgarcia@gmail.com">Mauricio</a>
 * @version
 * @sinse 08/04/2018 00:24:22
 * @param <T> DTO return
 */
public class JpaNativeQuery<T> extends Query<T> {

	/**
	 * Contructos with args:
	 * 
	 * @param sql sql query
	 * @param resultSet {@link ResultSet}
	 * @param resultClass return type
	 */
	public JpaNativeQuery(String sql, ResultSet<T> resultSet, Class<T> resultClass) {
		super(sql, resultSet, resultClass);
	}

	public javax.persistence.Query getQuery(EntityManager em) {
		return em.createNativeQuery(super.getName());
	}
}
