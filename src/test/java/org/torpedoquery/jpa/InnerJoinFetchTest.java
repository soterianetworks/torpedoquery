package org.torpedoquery.jpa;

import org.junit.Test;
import org.torpedoquery.jpa.test.bo.Entity;
import org.torpedoquery.jpa.test.bo.SubEntity;

import static org.junit.Assert.assertEquals;
import static org.torpedoquery.jpa.Torpedo.*;

public class InnerJoinFetchTest {

	@Test
	public void testInnerJoinFetchSubEntityField() {
		Entity from = from(Entity.class);
		SubEntity subEntity = innerJoinFetch(from.getSubEntity());
		where(subEntity.getCode()).eq("test-code");

		Query<Entity> select = select(from);
		String query = select.getQuery();
		assertEquals("select entity_0 from Entity entity_0 inner join fetch entity_0.subEntity subEntity_1 where subEntity_1.code = :code_2", query);
	}

}
