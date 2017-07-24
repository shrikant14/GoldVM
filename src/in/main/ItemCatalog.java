package in.main;

import java.util.ArrayList;

public class ItemCatalog {

	private ArrayList<Inventory> inventory;
	private ArrayList<ItemDetail> itemDetails;

	public ItemCatalog(int[] itemID, String[] itemName, int[] itemPrice,
			int[] quantity) {
		// TODO Auto-generated constructor stub
		inventory = new ArrayList<Inventory>();
		itemDetails = new ArrayList<ItemDetail>();
		for (int i = 0; i < itemID.length; i++) {
			inventory.add(new Inventory(itemID[i], quantity[i]));
			itemDetails
					.add(new ItemDetail(itemID[i], itemName[i], itemPrice[i]));
		}

	}

	// Method to get the available quantity of item
	public int getQuantity(int itemID) {
		int id = 0;
		for (Inventory in : inventory) {
			if (in.getItemID() == itemID) {
				id = in.getQuantity();
			}
		}
		return id;
	}

	// method to reduce the quantity of the item
	public boolean removeQuantity(int itemID, int quantity) {
		boolean result = false;
		for (Inventory in : inventory) {
			if (in.getItemID() == itemID) {
				if (in.getQuantity() >= quantity) {
					in.setQuantity(in.getQuantity() - quantity);
					result = true;
				}

			}
		}
		return result;
	}

	// method to add quantity to inventory
	public boolean addQuantity(int itemID, int quantity) {
		boolean result = false;
		for (Inventory in : inventory) {
			if (in.getItemID() == itemID) {
				in.setQuantity(in.getQuantity() + quantity);
				result = true;

			}
		}
		return result;
	}

	// Method to get item info from item id
	public ItemDetail getItemInfo(int itemID) {
		for (ItemDetail item : itemDetails) {
			if (item.getItemID() == itemID) {
				return item;
			}
		}
		return null;
	}

	// Method to get the item catalog
	public String getItemCatalog() {
		StringBuilder catalog = new StringBuilder("ITEM CATALOG - \n");

		for (ItemDetail item : itemDetails) {
			catalog.append("\t\t[Item ID - " + item.getItemID()
					+ ", Item Name- " + item.getItemName() + ", Item Price- "
					+ item.getAmount() + "]\n");
		}

		return catalog.toString();

	}

}
