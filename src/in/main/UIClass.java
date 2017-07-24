package in.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class UIClass {

	GoldVM vendingMachine;
	private ArrayList<ItemDetail> itemDetails;
	private HashMap<Integer, Integer> quantityItem;
	String userid;
	String rec;
	UIClass(GoldVM vendingMachine) {
		this.vendingMachine = vendingMachine;
	}

	// Method to start the purchase UI
	public void startPurchase() {
		System.out
				.println("\n\n\t---------------------------------------------");
		System.out.println("\t\tWELCOME TO GOLD VENDING MACHINE");
		System.out
				.println("\t---------------------------------------------\n\n");
		Scanner scanner = new Scanner(System.in);
		System.out.print("\tEnter your used-id: ");
		userid = scanner.next();

		if (vendingMachine.checkAuthorization(userid)) {
			System.out.print("\n\tUser Authorized -----");
			System.out.println(" Welcome " + userid + " !!\n");
			System.out.println("\tLanguage catalog: "
					+ vendingMachine.getlanguageCatalog());
			System.out.print("\tPlease select a language from catalog: ");
			int lang = scanner.nextInt();
			vendingMachine.selectLanguage(lang);
			System.out.println("\n\t" + vendingMachine.getSelectedLanguage()
					+ " is selected as language\n\n");
			enterItem();
		} else {
			System.out.println("Authorization Faied \n\n");
			startPurchase();
		}

	}

	// Method to start UI to get the item from user
	public void enterItem() {

		quantityItem = new HashMap<Integer, Integer>();
		itemDetails = new ArrayList<ItemDetail>();
		Scanner scanner = new Scanner(System.in);
		boolean con = true;
		System.out.println("\t" + vendingMachine.getItemCatalog());
		while (con) {
			System.out.print("\n\tEnter an item ID from the catalog: ");
			int item = scanner.nextInt();
			System.out.print("\t\tQuantity available: "
					+ vendingMachine.getItemQuantityFromCatalog(item) + "\n");
			System.out.print("\n\tSelect quantity: ");
			int quantity = scanner.nextInt();
			if (quantity <= vendingMachine.getItemQuantityFromCatalog(item)) {
				vendingMachine.removeItemFromCatalog(item, quantity);
				quantityItem.put(item, quantity);
				itemDetails.add(vendingMachine.getItemInfoFromCatalog(item));
				System.out.println("\tSuccessfully added to cart");
			} else {
				System.out.println("\tAvailable quantity is less");
			}

			System.out.print("\n\tDo you want to continue? (y/n): ");
			String val = scanner.next();
			if (val.equalsIgnoreCase("n")) {
				con = false;
			}
		}

		Receipt receipt = vendingMachine.makeNewSale(itemDetails, quantityItem);
		rec= receipt.getReceipt();
		System.out.println("\n\tYour total: \n" + rec);
		Scanner scanner1 = new Scanner(System.in);
		System.out
				.print("\n\n\tSelect payment type (Enter 1 for card or Enter 2 for cash): ");
		int paymentType = scanner1.nextInt();
		Boolean res = false;
		if (paymentType == 1) {
			res = vendingMachine.makePayment(receipt, getCardDetails());
			if (res) {
				System.out.println("\n\tCard verified successfully");
				System.out.println("\tTransaction completed");
				System.out.println("\n\tYour receipt: \n"
						+ rec);
				System.out.println("\n\tGoodbye " + userid + "\n\n");
				startPurchase();
			} else {
				// if the process fails revert back the quantity
				System.out.println("\n\tTransaction failed");
				System.out.println("\tGoodbye " + userid + "\n\n");
				vendingMachine.revertItemQuantityUpdate(quantityItem);
				startPurchase();
			}
		} else if (paymentType == 2) {
			res = vendingMachine.makePayment(receipt, getCashDetail());
			if (res) {
				System.out.println("\n\tTransaction completed");
				System.out.println("\n\tYour receipt: \n"
						+ rec);
				System.out.println("\n\tGoodbye " + userid + "\n\n");
				startPurchase();
			} else {
				// if the process fails revert back the quantity
				System.out.println("\n\tTransaction failed");
				System.out.println("\tGoodbye " + userid + "\n\n");
				vendingMachine.revertItemQuantityUpdate(quantityItem);
				startPurchase();
			}
		}

	}

	// Method to get card details from user
	public CardDetail getCardDetails() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("\n\tWelcome to card payment gateway ");
		System.out.print("\tEnter card number: ");
		int cardNumber = scanner.nextInt();
		System.out.print("\tEnter card cvv: ");
		int cvv = scanner.nextInt();
		System.out.print("\tEnter card expiry date: ");
		String expire_date = scanner.next();
		return new CardDetail(cardNumber, cvv, expire_date);

	}

	// Method to get cash details from user
	public CashDetail getCashDetail() {
		Scanner scanner = new Scanner(System.in);
		System.out
				.println("\n\tWelcome to cash payment gateway(Accepted denomination- 1,5,10,50,100) ");
		System.out.print("\tEnter number of bills: ");
		int numberOfBills = scanner.nextInt();
		System.out.print("\tEnter number of 1 dollar bill: ");
		int oneBills = scanner.nextInt();
		System.out.print("\tEnter number of 5 dollar bill: ");
		int fiveBills = scanner.nextInt();
		System.out.print("\tEnter number of 10 dollar bill: ");
		int tenBills = scanner.nextInt();
		System.out.print("\tEnter number of 50 dollar bill: ");
		int fiftyBills = scanner.nextInt();
		System.out.print("\tEnter number of 100 dollar bill: ");
		int hundredBills = scanner.nextInt();

		return new CashDetail(numberOfBills, oneBills, fiveBills, tenBills,
				fiftyBills, hundredBills);
	}
}
