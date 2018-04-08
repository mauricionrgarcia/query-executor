package com.query.resultset;

/**
 * Value of result column
 * 
 * @author <a href="mailto:mauricionrgarcia@gmail.com">Mauricio Garcia</a>
 * @version
 * @sinse 08/04/2018 00:29:27
 */
public interface ColumnResult {

	/**
	 * @return default value
	 */
	Object getData();

	/**
	 * @return string value of column
	 */
	String getString();

}
