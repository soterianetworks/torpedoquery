package org.torpedoquery.jpa.internal.joins;

import org.torpedoquery.core.QueryBuilder;
import org.torpedoquery.jpa.internal.conditions.LogicalCondition;
import org.torpedoquery.jpa.internal.utils.TorpedoMethodHandler;

/**
 * <p>InnerJoinFetchBuilder class.</p>
 *
 * @author soterianetworks
 * @version $Id: $Id
 */
public class InnerJoinFetchBuilder<T> extends AbstractJoinBuilder<T>{

	private Class<T> queryClass;
	private TorpedoMethodHandler methodHandler;

	/**
	 * <p>Constructor for InnerJoinFetchBuilder.</p>
	 *
	 * @param queryClass a {@link Class} object.
	 * @param torpedoMethodHandler a {@link TorpedoMethodHandler} object.
	 */
	public InnerJoinFetchBuilder(Class<T> queryClass, TorpedoMethodHandler torpedoMethodHandler) {
		super(queryClass, torpedoMethodHandler);
	}
	
	/** {@inheritDoc} */
	@Override
	protected InnerJoinFetch createJoin(QueryBuilder queryBuilder, LogicalCondition joinCondition) {
		return new InnerJoinFetch(queryBuilder, joinCondition);
	}

}
