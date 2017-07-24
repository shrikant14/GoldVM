package in.main;

public class ItemDetail {

	private int itemID;
	private String itemName;
	private double amount;

	public ItemDetail(int itemID, String itemName, double amount) {
		this.itemID = itemID;
		this.itemName = itemName;
		this.amount = amount;
	}

	// Method to get item id
	public int getItemID() {
		return itemID;
	}

	// Method to get item name
	public String getItemName() {
		return itemName;
	}

	public double getAmount() {
		return amount;
	}

}
