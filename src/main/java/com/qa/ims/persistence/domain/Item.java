package com.qa.ims.persistence.domain;

public class Item {

	
	private Long itemId;
	private String itemName;
	private double itemPrice;

	public Item(String itemName, double itemPrice) {
		this.setItemName(itemName);
		this.setItemPrice(itemPrice);
	}

	public Item(Long itemId, String itemName, double itemPrice) {
		this.setItemId(itemId);
		this.setItemName(itemName);
		this.setItemPrice(itemPrice);
	}
	
	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}


	

	@Override
	public String toString() {
		return "id:" + itemId + " Item:" + itemName + " Price:" + itemPrice;
	}
	
}

//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((itemName == null) ? 0 : itemName.hashCode());
//		result = prime * result + ((itemId == null) ? 0 : itemId.hashCode());
//		//result = prime * result + ((itemPrice == null) ? 0 : surname.hashCode());
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Item other = (Item) obj;
//		if (getItemName() == null) {
//			if (other.getItemName() != null)
//				return false;
//		} else if (!getItemName().equals(other.getItemName()))
//			return false;
//		if (itemId == null) {
//			if (other.itemId != null)
//				return false;
//		} else if (!itemId.equals(other.itemId))
//			return false;
////		if (getItemPrice == null) {
////			if (other.itemPrice != null)
////				return false;
////		} else if (!surname.equals(other.surname))
////			return false;
//		return true;
//	}
//
//}
