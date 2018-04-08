package com.query.resultset.impl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;

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

	@Override
	public Long getLong(Integer pos) {
		if (data[pos] instanceof java.math.BigInteger) {
			java.math.BigInteger bigInteger = (BigInteger) data[pos];
			return bigInteger.longValueExact();
		}
		return null;
	}

	@Override
	public Integer getInteger(Integer code) {
		if (data[code] instanceof Integer) {
			return (Integer) data[code];
		}
		return null;
	}

	@Override
	public BigDecimal getBigDecimal(Integer pos) {
		if (data[pos] instanceof BigDecimal) {
			return (BigDecimal) data[pos];
		}
		return null;
	}

	@Override
	public LocalDate getLocalDate(Integer pos) {
		if (data[pos] instanceof java.sql.Date) {
			java.sql.Date date = (java.sql.Date) data[pos];
			return date.toLocalDate();
		} else if (data[pos] instanceof java.sql.Timestamp) {
			java.sql.Timestamp timestamp = (java.sql.Timestamp) data[pos];
			return timestamp.toLocalDateTime().toLocalDate();
		}
		return null;
	}

	@Override
	public LocalDateTime getLocalDateTime(Integer pos) {
		if (data[pos] instanceof java.sql.Timestamp) {
			java.sql.Timestamp timestamp = (java.sql.Timestamp) data[pos];
			return timestamp.toLocalDateTime();
		} else if (data[pos] instanceof java.sql.Date) {
			java.sql.Date date = (java.sql.Date) data[pos];
			return date.toLocalDate().atStartOfDay();
		}
		return null;
	}

}
