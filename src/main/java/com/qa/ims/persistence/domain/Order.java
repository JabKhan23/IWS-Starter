package com.qa.ims.persistence.domain;

public class Order {
	private Long orderId;
	private String orderItem;
	private Long itemQuantity;
	private double totalOrder;

	public Order(Long orderId, String orderItem, Long itemQuantity, double totalOrder) {
		this.setOrderId(orderId);
		this.setOrderItem(orderItem);
		this.setItemQuantity(itemQuantity);
		this.setTotalOrder(totalOrder);
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(String orderItem) {
		this.orderItem = orderItem;
	}

	public Long getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(Long itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	public double getTotalOrder() {
		return totalOrder;
	}

	public void setTotalOrder(double totalOrder) {
		this.totalOrder = totalOrder;
	}
	
	public Order(String orderItem, Long itemQuantity) {
		this.setOrderItem(orderItem);
		this.setItemQuantity(itemQuantity);
	}
	
	public Order(Long orderId, String orderItem, Long itemQuantity) {
		this.setOrderId(orderId);
		this.setOrderItem(orderItem);
		this.setItemQuantity(itemQuantity);
	}

}
