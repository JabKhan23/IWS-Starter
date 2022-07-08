package com.qa.ims.persistence.domain;

public class OrderRequest {

	private Long itemId;
	private Long orderId;
	private Long orderRequestID;
	private Long quantity;
	private Double price;

	public OrderRequest(Long itemId, Long orderId,Long quantity) {
		this.setItemID(itemId);
		this.setOrderID(orderId);
		this.setQuantity(quantity);
	}

	public OrderRequest(Long itemId, Long orderId ,Long quantity,Long orderRequestID) {
		this.setItemID(itemId);
		this.setOrderID(orderId);
		this.setQuantity(quantity);
		this.setOrderRequestID(orderRequestID);
	}
	public OrderRequest(Long itemId, Long orderId ,Long quantity,Long orderRequestID, Double price) {
		this.setItemID(itemId);
		this.setOrderID(orderId);
		this.setQuantity(quantity);
		this.setOrderRequestID(orderRequestID);
		this.setPrice(price);
	}

	
	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Long getItemID() {
		return itemId;
	}

	public void setItemID(Long itemId) {
		this.itemId = itemId;
	}

	public Long getOrderID() {
		return orderId;
	}

	public void setOrderID(Long orderId) {
		this.orderId = orderId;
	}

	public Long getOrderRequestID() {
		return orderRequestID;
	}

	public void setOrderRequestID(Long orderRequestID) {
		this.orderRequestID = orderRequestID;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "ItemID :" + itemId + " OrderID:" + orderId + " OrderRequest:" + orderRequestID + " Quantity:" + quantity + " price" + price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((itemId == null) ? 0 : itemId.hashCode());
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		result = prime * result + ((orderRequestID == null) ? 0 : orderRequestID.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
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
		OrderRequest other = (OrderRequest) obj;
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
		if (orderRequestID == null) {
			if (other.orderRequestID != null)
				return false;
		} else if (!orderRequestID.equals(other.orderRequestID))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		return true;
	}
	
}

