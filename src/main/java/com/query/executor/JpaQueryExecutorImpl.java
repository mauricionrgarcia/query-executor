package com.query.executor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import com.query.query.Query;
import com.query.resultset.impl.RowResultImpl;

/**
 * implementation to execute query<br>
 * TODO - Fixed to native query
 * 
 * @author <a href="mailto:mauricionrgarcia@gmail.com">Mauricio</a>
 * @version
 * @sinse 07/04/2018 21:03:22
 */
@JpaQuery
@Component
public class JpaQueryExecutorImpl implements JpaQueryExecutor {

	/**
	 * {@link EntityManager}
	 */
	@PersistenceContext
	private EntityManager em;

	public JpaQueryExecutorImpl() {
	}

	@Override
	public <T> List<T> getResultList(Query<T> query) {

		javax.persistence.Query q = query.getQuery(em);
		q = applyParans(query, q);

		List<?> resultList = q.getResultList();

		List<T> returnList = new ArrayList<>();

		for (Object result : resultList) {
			if (result instanceof Object[]) {
				Object[] row = (Object[]) result;
				T dto = query.getResultSet().mapRow(new RowResultImpl(row));
				returnList.add(dto);
			} else {
				T dto = query.getResultSet().mapRow(new RowResultImpl(result));
				returnList.add(dto);
			}
		}
		return returnList;
	}

	@Override
	public <T> Optional<T> getSingleResult(Query<T> query) {

		javax.persistence.Query q = query.getQuery(em);
		q = applyParans(query, q);
		Object result = q.getSingleResult();
		if (result instanceof Object[]) {
			Object[] row = (Object[]) result;
			return Optional.ofNullable(query.getResultSet().mapRow(new RowResultImpl(row)));
		} else {
			return Optional.ofNullable(query.getResultSet().mapRow(new RowResultImpl(result)));
		}
	}

	/**
	 * apply paramns
	 * 
	 * @param query {@link Query}
	 * @param q {@link javax.persistence.Query}
	 * @return
	 */
	private <T> javax.persistence.Query applyParans(Query<T> query, javax.persistence.Query q) {
		if (query.getParams() != null) {
			for (Entry<String, Object> param : query.getParams().entrySet()) {
				q = q.setParameter(param.getKey(), param.getValue());
			}
		}
		return q;
	}
}
