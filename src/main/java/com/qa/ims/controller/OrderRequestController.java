package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import com.qa.ims.persistence.dao.OrderRequestDAO;
import com.qa.ims.persistence.domain.OrderRequest;
import com.qa.ims.utils.Utils;

public class OrderRequestController implements CrudController<OrderRequest> {

	public static final Logger LOGGER = LogManager.getLogger();

	private OrderRequestDAO orderRequestDAO;
	private Utils utils;

	public OrderRequestController(OrderRequestDAO orderrequestDAO, Utils utils) {
		super();
		this.orderRequestDAO = orderrequestDAO;
		this.utils = utils;
	}

	/**
	 * Reads all orderRequests to the logger
	 */
	@Override
	public List<OrderRequest> readAll() {
		List<OrderRequest> orderRequests = orderRequestDAO.readAll();
		for (OrderRequest orderRequest : orderRequests) {
			LOGGER.info(orderRequest);
		}
		return orderRequests;
	}

	/**
	 * Creates a orderRequest by taking in user input
	 */
	@Override
	public OrderRequest create() {
		LOGGER.info("Please enter a an Item ID");
		Long itemId = utils.getLong();
		LOGGER.info("Please enter a Order ID");
		Long orderId = utils.getLong();
		LOGGER.info("Please enter a quantity that you would like");
		Long quantity = utils.getLong();
		OrderRequest orderRequest = orderRequestDAO.create(new OrderRequest(itemId, orderId, quantity));
		LOGGER.info("Order Request created");
		
		return orderRequest;
	}	

	/**
	 * Updates an existing orderRequest by taking in user input
	 */
	@Override
	public OrderRequest update() {
		LOGGER.info("Please enter the ID of the Order Request you would like to update");
		Long orderRequestID = utils.getLong();
		LOGGER.info("Please enter the item ID of the Order Request you would like to update");
		Long itemId = utils.getLong();
		LOGGER.info("Please enter a Order ID");
		Long orderId = utils.getLong();
		LOGGER.info("Please enter a quantity");
		Long quantity = utils.getLong();
		OrderRequest orderRequest = orderRequestDAO.update(new OrderRequest(itemId, orderId , quantity, orderRequestID ));
		LOGGER.info("Order Request Updated");
		return orderRequest;
	}

	/**
	 * Deletes an existing orderRequest by the id of the orderRequest
	 * 
	 * @return
	 */
	@Override
	public int delete() {
		LOGGER.info("Please enter the ID of the Order Request you would like to delete");
		Long orderRequestID = utils.getLong();
		return orderRequestDAO.delete(orderRequestID);
	}

}
