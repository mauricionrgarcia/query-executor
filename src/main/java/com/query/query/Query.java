package com.query.query;

import java.util.Map;

import javax.persistence.EntityManager;

import com.query.resultset.ResultSet;

/**
 * {@link Query} default values to a query executor
 * 
 * @author <a href="mailto:mauricionrgarcia@gmail.com">Mauricio</a>
 * @version
 * @sinse 08/04/2018 00:19:37
 * @param <T> DTO return
 */
public abstract class Query<T> {

	/**
	 * get a query
	 * 
	 * @param em {@link EntityManager}
	 * @return {@link javax.persistence.Query}
	 */
	public abstract javax.persistence.Query getQuery(EntityManager em);

	/**
	 * sql query name
	 */
	private String name;
	/**
	 * return class
	 */
	private Class<T> resultClass;
	/**
	 * result set to mapping
	 */
	private ResultSet<T> resultSet;

	/**
	 * params
	 */
	private Map<String, Object> params;

	/**
	 * Contructos with args:
	 * 
	 * @param name name / sql query
	 * @param resultSet {@link ResultSet}
	 * @param resultClass return type
	 */
	public Query(String name, ResultSet<T> resultSet, Class<T> resultClass) {
		this.name = name;
		this.resultClass = resultClass;
		this.resultSet = resultSet;

	}

	/**
	 * Contructos with args:
	 * 
	 * @param name name / sql query
	 * @param resultSet {@link ResultSet}
	 * @param resultClass return type
	 */
	public Query(String name, ResultSet<T> resultSet, Class<T> resultClass, Map<String, Object> params) {
		this.name = name;
		this.resultClass = resultClass;
		this.resultSet = resultSet;
		this.params = params;

	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the resultClass
	 */
	public Class<T> getResultClass() {
		return resultClass;
	}

	/**
	 * @param resultClass the resultClass to set
	 */
	public void setResultClass(Class<T> resultClass) {
		this.resultClass = resultClass;
	}

	/**
	 * @return the resultSet
	 */
	public ResultSet<T> getResultSet() {
		return resultSet;
	}

	/**
	 * @param resultSet the resultSet to set
	 */
	public void setResultSet(ResultSet<T> resultSet) {
		this.resultSet = resultSet;
	}

	/**
	 * @return the params
	 */
	public Map<String, Object> getParams() {
		return params;
	}

	/**
	 * @param params the params to set
	 */
	public void setParams(Map<String, Object> params) {
		this.params = params;
	}

}
