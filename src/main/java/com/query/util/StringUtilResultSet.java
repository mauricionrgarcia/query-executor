package com.query.util;

import com.query.resultset.ResultSet;
import com.query.resultset.RowResult;

/**
 * ResultSet implementation to mapping a simple result query to string
 * 
 * @author <a href="mailto:mauricionrgarcia@gmail.com">Mauricio Garcia</a>
 * @version
 * @sinse 08/04/2018 00:32:47
 */
public class StringUtilResultSet implements ResultSet<String> {

	@Override
	public String mapRow(RowResult rowResult) {
		return rowResult.get(0).getString();
	}

}
