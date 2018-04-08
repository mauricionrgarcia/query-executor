package com.query.resultset.impl;

import com.query.resultset.ColumnResult;

public class ColumnResultImpl implements ColumnResult {

	/**
	 * column value
	 */
	private Object column;

	public ColumnResultImpl(Object column) {
		this.column = column;
	}

	public Object getData() {
		return column;
	}

	public String getString() {
		return String.valueOf(column);
	}

}
