
/**
 * Copyright (C) 2011 Xavier Jodoin (xavier@jodoin.me)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * @author xjodoin
 * @version $Id: $Id
 */
package org.torpedoquery.jpa.internal.joins;

import org.torpedoquery.core.QueryBuilder;
import org.torpedoquery.jpa.internal.Join;
import org.torpedoquery.jpa.internal.conditions.LogicalCondition;
import org.torpedoquery.jpa.internal.query.ValueParameter;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>AbstractJoinFetch class.</p>
 *
 * @author soterianetworks
 * @version $Id: $Id
 */
public abstract class AbstractJoinFetch extends AbstractJoin {

	public AbstractJoinFetch(QueryBuilder<?> join, String fieldName) {
		super(join, fieldName);
	}

	public AbstractJoinFetch(QueryBuilder<?> join, LogicalCondition joinCondition) {
		super(join, joinCondition);
	}

	/** {@inheritDoc} */
	@Override
	public String getJoin(String parentAlias, AtomicInteger incrementor) {
		if (joinCondition != null) {
			return " " + getJoinType() + " join fetch " +join.getEntityName() + " " + join.getAlias(incrementor) + " on "
					+ joinCondition.createQueryFragment(incrementor);
		} else {
			return (" " + getJoinType() + " join fetch " + parentAlias + "." + fieldName + " " + join.getAlias(incrementor))
					+ (join.hasWithClause() ? join.getWithClause(incrementor) : "")
					+ (join.hasSubJoin() ? join.getJoins(incrementor) : "");
		}

	}

}
