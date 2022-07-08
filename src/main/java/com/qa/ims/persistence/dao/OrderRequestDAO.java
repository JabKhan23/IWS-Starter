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


import com.qa.ims.persistence.domain.OrderRequest;
import com.qa.ims.utils.DBUtils;

public class OrderRequestDAO implements Dao<OrderRequest> {

	public static final Logger LOGGER = LogManager.getLogger();

	@Override
	public OrderRequest modelFromResultSet(ResultSet resultSet) throws SQLException {
		Long itemId = resultSet.getLong("itemID");
		Long orderId = resultSet.getLong("orderID");
		Long orderRequestId = resultSet.getLong("orderRequestID");
		Long quantity = resultSet.getLong("quantity");
		Double price = quantity*howmuch(itemId);
		return new OrderRequest(itemId, orderId, quantity,orderRequestId,price);
	}

	/**
	 * Reads all items from the database
	 * 
	 * @return A list of items
	 */
	@Override
	public List<OrderRequest> readAll() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orderRequest");) {
			List<OrderRequest> orderinfos = new ArrayList<>();
			while (resultSet.next()) {
				orderinfos.add(modelFromResultSet(resultSet));
			}
			return orderinfos;
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}

	public OrderRequest readLatest() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orderRequest ORDER BY orderRequestID DESC LIMIT 1");) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Creates a item in the database
	 * 
	 * @param item - takes in a item object. id will be ignored
	 */
	@Override
	public OrderRequest create(OrderRequest orderRequest) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("INSERT INTO orderRequest(itemID,orderID,quantity) VALUES (?, ? ,?)");) {
			statement.setLong(1, orderRequest.getItemID());
			statement.setLong(2, orderRequest.getOrderID());
			statement.setLong(3, orderRequest.getQuantity());
			statement.executeUpdate();
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	@Override
	public OrderRequest read(Long orderID) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("SELECT * FROM orderRequest WHERE orderRequestID = ?");) {
			statement.setLong(1, orderID);
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
	 * Updates a item in the database
	 * 
	 * @param item - takes in a item object, the id field will be used to
	 *                 update that item in the database
	 * @return
	 */
	@Override
	public OrderRequest update(OrderRequest orderRequest) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("UPDATE orderRequest SET itemID = ?, orderID = ?, quantity = ? WHERE orderRequestID = ?");) {
			statement.setLong(1, orderRequest.getItemID());
			statement.setLong(2, orderRequest.getOrderID());
			statement.setLong(3, orderRequest.getQuantity());
			statement.setLong(4, orderRequest.getOrderRequestID());

			statement.executeUpdate();
			return read(orderRequest.getOrderRequestID());
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	

	/**
	 * Deletes a item in the database
	 * 
	 * @param id - id of the item
	 */
	@Override
	public int delete(long orderRequestId) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("DELETE FROM orderRequest WHERE orderRequestID = ?");) {
			statement.setLong(1, orderRequestId);
			return statement.executeUpdate();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0;
	}

	
	public Double howmuch(Long orderRequestId) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("SELECT item_price from items where itemId = ?");) {
			statement.setLong(1, orderRequestId);
			try (ResultSet resultSet = statement.executeQuery();) {
				resultSet.next();
				return resultSet.getDouble("item_price");
			}
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}



	
	
}
