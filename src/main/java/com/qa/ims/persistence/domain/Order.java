package com.qa.ims.persistence.domain;

public class Order {

	private Long orderId;
	private Long customerId;
//	private Long itemId;
//	private String custName;
//	private Long totalOrder;

	
	


	public Order(Long customerId) {
		this.setCustomerId(customerId);
		
	}
	
	public Order(Long customerId, Long orderId) {
		this.setCustomerId(customerId);
		this.setOrderId(orderId);
		
	}

	


	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}



	public Long getOrderId() {
		return orderId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	@Override
	public String toString() {
		return "custid:" + customerId + " orderid:" +orderId ;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
			return false;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		return true;
	}


	
	
	
	
}


