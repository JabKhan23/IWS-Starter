package com.qa.ims.controllers;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.controller.OrderRequestController;
import com.qa.ims.persistence.dao.OrderRequestDAO;
import com.qa.ims.persistence.domain.OrderRequest;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)
public class OrderRequestControllerTest {

	@Mock
	private Utils utils;

	@Mock
	private OrderRequestDAO dao;

	@InjectMocks
	private OrderRequestController controller;

	@Test
	public void testCreate() {
		final Long  orderId=2L , itemId=4L, quantity = 3L;
		
		final OrderRequest created = new OrderRequest(orderId, itemId, quantity);

		Mockito.when(utils.getLong()).thenReturn(orderId, itemId,quantity);
		Mockito.when(dao.create(created)).thenReturn(created);

		assertEquals(created, this.controller.create());

		Mockito.verify(utils, Mockito.times(3)).getLong();
		Mockito.verify(dao, Mockito.times(1)).create(created);
	}

	@Test
	public void testReadAll() {
		List<OrderRequest> OrderRequest = new ArrayList<>();
		OrderRequest.add(new OrderRequest(1L, 1L,1L));

		Mockito.when(dao.readAll()).thenReturn(OrderRequest);

		assertEquals(OrderRequest, controller.readAll());

		Mockito.verify(dao, Mockito.times(1)).readAll();
	}

	@Test
	public void testUpdate() {
		OrderRequest updated = new OrderRequest(1L, 1L, 1L,1L);

		Mockito.when(this.utils.getLong()).thenReturn(1L, updated.getItemID(),updated.getOrderID(), updated.getQuantity());
		
		Mockito.when(this.dao.update(updated)).thenReturn(updated);

		assertEquals(updated, this.controller.update());

		Mockito.verify(this.utils, Mockito.times(4)).getLong();
		Mockito.verify(this.dao, Mockito.times(1)).update(updated);
	}

	@Test
	public void testDelete() {
		final long ID = 1L;

		Mockito.when(utils.getLong()).thenReturn(ID);
		Mockito.when(dao.delete(ID)).thenReturn(1);

		assertEquals(1L, this.controller.delete());

		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(dao, Mockito.times(1)).delete(ID);
	}

}
