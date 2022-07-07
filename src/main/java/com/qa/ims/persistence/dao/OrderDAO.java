package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import com.qa.ims.persistence.domain.Order;
import com.qa.ims.persistence.domain.Orders;
import com.qa.ims.utils.DBUtils;

public class OrderDAO implements Dao<Order>{
	
	public static final Logger LOGGER = LogManager.getLogger();

	@Override
	public Order modelFromResultSet(ResultSet resultSet) throws SQLException {
		String custName = resultSet.getString("customer_name");
		Long itemId = resultSet.getLong("itemId");
		Long totalOrder = resultSet.getLong("total_order");
		//Long itemQuantity = resultSet.getLong("item_quantity");
		return new Order(custName, itemId, totalOrder);

	}

	
	public Order modelFromResultSetOrders(ResultSet resultSet) throws SQLException {
		Long orderId = resultSet.getLong("orderID");
		Long customerId = resultSet.getLong("CustomerID");
		/*
		 * Long item_id = resultSet.getLong("item_id"); Long orderline_id =
		 * resultSet.getLong("orderlineID");
		 */
		Order newOrder = new Order(customerId);
		
		newOrder.setOrderId(orderId);
		return newOrder;
	}

	/**
	 * Reads all Orders from the database
	 * 
	 * @return A list of Orders
	 */
	@Override
	public List<Order> readAll() {	
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
							
				ResultSet resultSet = statement.executeQuery(
						"SELECT orders.CustomerID, items.itemid, CONCAT(customers.first_name,\" \", "
						 + "customers.surname) as customer, items.item_name, items.item_price, " +
						 "price as total from orders, orderline, products, customers where orders.CustomerID = "
						 +
						 "orderline.order_id and products.id = orderline.item_id and orders.customerId= customers.id order by orders.orderID, items.item_id;"
						 );
				
				
				) {
				
			List<Order> orders = new ArrayList<>();
			while (resultSet.next()) {
				orders.add(modelFromResultSet(resultSet));
			}
			return orders;
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}

	public Order readLatest() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM Orders ORDER BY CustomerId DESC LIMIT 1");) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Creates a Order in the database
	 * 
	 * @param Order - takes in a Order object. id will be ignored
	 */
	@Override
	public Order create(Order Order) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("INSERT INTO Orders(item_name, item_price) VALUES (?, ?)");) {
			statement.setLong(1, Order.getOrderId());
			statement.setDouble(2, Order.getTotalOrder());
			statement.setLong(2, Order.getItemQuantity());
			statement.executeUpdate();
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public Order read(Long itemId) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("SELECT * FROM Orders WHERE itemId = ?");) {
			statement.setLong(1, itemId);
			try (ResultSet resultSet = statement.executeQuery();) {
				resultSet.next();
				return modelFromResultSet(resultSet);
			}
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Updates a Order in the database
	 * 
	 * @param Order - takes in a Order object, the id field will be used to
	 *                 update that Order in the database
	 * @return
	 */
	@Override
	public Order update(Order Order) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("UPDATE Orders SET order_item = ?, item_quantity = ? WHERE orderId = ?");) {
			statement.setString(1, Order.getOrderItem());
			statement.setLong(2, Order.getItemQuantity());
			statement.setLong(3, Order.getOrderId());
			statement.executeUpdate();
			return read(Order.getOrderId());
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Deletes a Order in the database
	 * 
	 * @param id - id of the Order
	 */
	@Override
	public int delete(long itemId) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("DELETE FROM Orders WHERE orderId = ?");) {
			statement.setLong(1, itemId);
			return statement.executeUpdate();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0;
	}

	
}
