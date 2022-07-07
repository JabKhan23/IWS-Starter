package com.qa.ims.persistence.domain;

public class Order {
	private Long orderId;
	private Long customerId;
	private Long itemId;
	private String custName;
	private Long totalOrder;

	
	


	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public Long getTotalOrder() {
		return totalOrder;
	}
	
	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public void setTotalOrder(Long totalOrder) {
		this.totalOrder = totalOrder;
	}
	
	public Order(Long customerId) {
		this.setCustomerId(customerId);
	}
	
	public Order(Long customerId, Long itemId) {
		this.setItemId(itemId);
		this.setCustomerId(customerId);
		
	}
	public Order(Long customerId, Long itemId, Long orderID) {
		this.setCustomerId(customerId);
		this.setItemId(itemId);
		this.setOrderId(orderID);
	}
	
	public Order(Long customerId, Long itemId, Long orderId, Long cost) {
		this.setCustomerId(customerId);
		this.setItemId(itemId);
		this.setTotalOrder(totalOrder);
		this.setOrderId(orderId);
		
	}
	
	public Order(String custName, Long item_id, Long totalOrder) {
		this.setCustName(custName);
		this.setTotalOrder(totalOrder);
		this.setItemId(item_id);
	}
	


	public String toString() {
		return "OrderID :" + orderId + " Item ID:" + itemId + " Customer Name:" + custName + "Price" + totalOrder;
	}
	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((totalOrder == null) ? 0 : totalOrder.hashCode());
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result + ((itemId == null) ? 0 : itemId.hashCode());
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		return result;
	}
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (totalOrder == null) {
			if (other.totalOrder != null)
				return false;
		} else if (!totalOrder.equals(other.totalOrder))
			return false;
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
			return false;
		if (itemId == null) {
			if (other.itemId != null)
				return false;
		} else if (!itemId.equals(other.itemId))
			return false;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		return true;
	}

	
	
	
	
}


