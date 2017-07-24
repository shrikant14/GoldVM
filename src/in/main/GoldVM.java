package in.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class GoldVM {

	private ItemCatalog itemCatalog;
	private UserAuthorization userAuthorization;
	private Language language;
	private ITaxCalculatorAdapter taxCalculatorAdapter;

	public GoldVM() {
		// set up the catalog
		itemCatalog = intializeCatalogVM();
		taxCalculatorAdapter = getTaxCalculatorAdapter();
		userAuthorization = new UserAuthorization();
		language = new Language();
	}

	// Method to add item catalog to the vending machine
	private ItemCatalog intializeCatalogVM() {
		int[] itemID = { 1, 2, 3, 4 };
		String[] itemName = { "Gold coin", "Gold biscuit", "Gold watch",
				"Gold ring" };
		int[] itemPrice = { 100, 500, 1000, 700 };
		int[] quantity = { 100, 100, 100, 100 };
		return new ItemCatalog(itemID, itemName, itemPrice, quantity);
	}

	// Method to set the tax adapter
	public ITaxCalculatorAdapter getTaxCalculatorAdapter() {
		if (this.taxCalculatorAdapter == null) {
			String className = System.getProperty("taxAdapter");
			// String className="in.main.USTaxCalculatorAdapter";
			// System.out.println(className);
			taxCalculatorAdapter = new USTaxCalculatorAdapter();
			try {
				taxCalculatorAdapter = (ITaxCalculatorAdapter) Class.forName(
						className).newInstance();

			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return taxCalculatorAdapter;
	}

	// Method to check user authenticity
	public boolean checkAuthorization(String userid) {
		return userAuthorization.checkUserAuthorization(userid);
	}

	// Method to select language for vending machine
	public void selectLanguage(int lang) {
		language.selectLanguage(lang);
	}

	// Method to get the vending machine language
	public String getSelectedLanguage() {
		return language.getSelectedLanguage();
	}

	// Method to get the language catalog to show to user
	public String getlanguageCatalog() {
		return language.getLanguageCatalog();
	}

	// Method to get the item catalog to show to the user
	public String getItemCatalog() {
		return itemCatalog.getItemCatalog();
	}

	// Method to get available quantity given item id
	public int getItemQuantityFromCatalog(int itemID) {
		return itemCatalog.getQuantity(itemID);
	}

	// Method to get item info from item id
	public ItemDetail getItemInfoFromCatalog(int itemID) {
		return itemCatalog.getItemInfo(itemID);
	}

	public Boolean removeItemFromCatalog(int itemID, int quantity) {
		return itemCatalog.removeQuantity(itemID, quantity);
	}

	// Method to add quantity back to inventory if the sale fails
	public void revertItemQuantityUpdate(HashMap<Integer, Integer> quantityItem2) {
		for (Integer key : quantityItem2.keySet()) {
			itemCatalog.addQuantity(key, quantityItem2.get(key));
		}
	}

	// Method to start the new sale after selecting the items
	public Receipt makeNewSale(ArrayList<ItemDetail> itemDetails,
			HashMap<Integer, Integer> quantityItem) {
		MakeSale makeSale = new MakeSale(itemDetails, quantityItem,
				taxCalculatorAdapter);
		return makeSale.getReceipt();
	}

	// Method to make payment for the sale
	public Boolean makePayment(Receipt receipt, Object paymentType) {
		Payment payment = new Payment(receipt.getTotal());
		return payment.makePayment(paymentType);
	}

}
