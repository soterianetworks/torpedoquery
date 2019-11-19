package org.torpedoquery.jpa;

import org.junit.Test;
import org.torpedoquery.jpa.test.bo.Entity;
import org.torpedoquery.jpa.test.bo.Entity2;
import org.torpedoquery.jpa.test.bo.SubEntity;

import static org.junit.Assert.assertEquals;
import static org.torpedoquery.jpa.Torpedo.*;

public class LeftJoinFetchTest {

	@Test
	public void testLeftJoinFetchSubEntityField() {
		Entity from = from(Entity.class);
		SubEntity subEntity = leftJoinFetch(from.getSubEntity());
		where(subEntity.getCode()).eq("test-code");

		Query<Entity> select = select(from);
		String query = select.getQuery();
		assertEquals("select entity_0 from Entity entity_0 left join fetch entity_0.subEntity subEntity_1 where subEntity_1.code = :code_2", query);
	}

}
