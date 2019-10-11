
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
package org.torpedoquery.jpa.internal.conditions;

import java.util.Collections;

import org.torpedoquery.jpa.internal.Parameter;
import org.torpedoquery.jpa.internal.Selector;
public abstract class PolymorphicCondition extends AbstractCondition {

	private final Class<?> condition;
	
	/**
	 * <p>Constructor for PolymorphicCondition.</p>
	 *
	 * @param selector a {@link org.torpedoquery.jpa.internal.Selector} object.
	 * @param condition a {@link java.lang.Class} object.
	 */
	public PolymorphicCondition(Selector selector,Class<?> condition) {
		super(selector, Collections.<Parameter>emptyList());
		this.condition = condition;
	}

}
