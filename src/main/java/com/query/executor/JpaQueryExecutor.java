package com.query.executor;

import java.util.List;
import java.util.Optional;

import com.query.query.Query;

/**
 * Qualifier provider execute query
 * 
 * @author <a href="mailto:mauricionrgarcia@gmail.com">Mauricio</a>
 * @version
 * @sinse 07/04/2018 21:03:22
 */
@JpaQuery
public interface JpaQueryExecutor {

	/**
	 * Execute a SELECT query and return the query results to the specified type.
	 * 
	 * @param query implementation of {@link Query}
	 * @return a list of the results
	 */
	<T> List<T> getResultList(Query<T> query);

	/**
	 * Execute a SELECT query that returns a single untyped result.
	 * 
	 * @param query implementation of {@link Query}
	 * @return the result
	 */
	<T> Optional<T> getSingleResult(Query<T> query);

}
