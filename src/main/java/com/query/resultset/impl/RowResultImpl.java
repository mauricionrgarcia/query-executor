package com.query.resultset.impl;

import com.query.resultset.ColumnResult;
import com.query.resultset.RowResult;

public class RowResultImpl implements RowResult {

	/**
	 * result row
	 */
	private Object[] data;

	public RowResultImpl(Object[] data) {
		this.data = data;
	}

	public RowResultImpl(Object result) {
		Object[] data = { result };
		this.data = data;
	}

	@Override
	public ColumnResult get(Integer pos) {
		return new ColumnResultImpl(data[pos]);
	}

	@Override
	public String getString(Integer pos) {
		return String.valueOf(data[pos]);
	}

}
