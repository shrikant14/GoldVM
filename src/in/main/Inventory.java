package in.main;

public class Inventory {

	private int itemID;
	private int quantity;

	public Inventory(int itemID, int quantity) {
		this.itemID = itemID;
		this.quantity = quantity;
	}

	// Method to get the item id
	public int getItemID() {
		return itemID;
	}

	// Method to get the item quantity
	public int getQuantity() {
		return quantity;
	}

	// Method to set the item quantity
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
