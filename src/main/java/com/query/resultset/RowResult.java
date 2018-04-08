package com.query.resultset;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

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

	/**
	 * ColumnResult
	 * 
	 * @param pos position of result sql
	 * @return value as long
	 */
	Long getLong(Integer code);

	/**
	 * ColumnResult
	 * 
	 * @param pos position of result sql
	 * @return value as interger
	 */
	Integer getInteger(Integer code);

	/**
	 * ColumnResult
	 * 
	 * @param pos position of result sql
	 * @return value as BigDecimal
	 */
	BigDecimal getBigDecimal(Integer code);

	/**
	 * ColumnResult
	 * 
	 * @param pos position of result sql
	 * @return value as LocalDate
	 */
	LocalDate getLocalDate(Integer code);

	/**
	 * ColumnResult
	 * 
	 * @param pos position of result sql
	 * @return value as LocalDateTime
	 */
	LocalDateTime getLocalDateTime(Integer code);

}
