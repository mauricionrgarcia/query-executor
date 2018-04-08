package com.query.resultset;

/**
 * Row result
 * 
 * @author <a href="mailto:mauricionrgarcia@gmail.com">Mauricio Garcia</a>
 * @version
 * @sinse 08/04/2018 00:31:46
 */
public interface RowResult {

	/**
	 * ColumnResult
	 * 
	 * @param pos position of result sql
	 * @return value
	 */
	ColumnResult get(Integer pos);

	/**
	 * ColumnResult
	 * 
	 * @param pos position of result sql
	 * @return value as string
	 */
	String getString(Integer pos);

}
