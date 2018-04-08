package com.query.resultset;

/**
 * Row result mapping
 * 
 * @author <a href="mailto:mauricionrgarcia@gmail.com">Mauricio Garcia</a>
 * @version
 * @sinse 08/04/2018 00:30:31
 * @param <T> DTO result
 */
public interface ResultSet<T> {

	/**
	 * Convert {@link RowResult} to <T>
	 * 
	 * @param rowResult {@link RowResult}
	 * @return <T>
	 */
	T mapRow(RowResult rowResult);

}
