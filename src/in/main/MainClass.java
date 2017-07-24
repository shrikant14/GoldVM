package in.main;

public class MainClass {

	public static void main(String[] args) {
		// Creating vending machine instance
		GoldVM vendingMachine = new GoldVM();
		// Creating UI instance using vending machine instance
		UIClass UI = new UIClass(vendingMachine);
		UI.startPurchase();
	}

}
