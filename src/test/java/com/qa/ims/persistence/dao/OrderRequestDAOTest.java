package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.OrderRequest;
import com.qa.ims.utils.DBUtils;

public class OrderRequestDAOTest {

	private final OrderRequestDAO DAO = new OrderRequestDAO();

	@Before
	public void setup() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
		}
		@Test
		public void testCreate() {
			final OrderRequest created = new OrderRequest(3L ,3L , 3L, 2L);
			assertEquals(created, DAO.create(created));
		}

		@Test
		public void testReadAll() {
			List<OrderRequest> expected = new ArrayList<>();
			expected.add(new OrderRequest(1L, 1L , 1L ,1L,0.5D ));
			assertEquals(expected, DAO.readAll());
		}

		@Test
		public void testReadLatest() {
			assertEquals(new OrderRequest(1L, 1L , 1L ,1L,0.5D), DAO.readLatest());
		}

		@Test
		public void testRead() {
			final long ID = 1L;
			assertEquals(new OrderRequest(ID, 1L, 1L , 1L ,0.5D), DAO.read(ID));
		}

		@Test
		public void testUpdate() {
			final OrderRequest updated = new OrderRequest(1L, 1L , 2L ,1L,1D);
			assertEquals(updated, DAO.update(updated));

		}

		@Test
		public void testDelete() {
			assertEquals(1, DAO.delete(1));
		}
	}