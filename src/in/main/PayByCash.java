package in.main;

import java.util.Scanner;

public class PayByCash {

	private double amount;
	private CashDetail cashDetails;
	private CashVerifier cashVerifier;
	private double change = 0;

	public PayByCash(double amount, CashDetail cashDetails) {
		this.amount = amount;
		this.cashDetails = cashDetails;

	}

	// Method to make transaction for sale using cash
	public boolean makeTransaction() {
		boolean result = false;
		cashVerifier = new CashVerifier(cashDetails, amount);
		if (!cashVerifier.checkNumberOfbills()) {
			return false;
		}
		if (cashVerifier.cashVerification()) {
			// deduct the amount from the card
			change = cashVerifier.calculateChange();
			result = true;
		}
		return result;
	}

	// Method to get the change of the transaction
	public double getChange() {
		return this.change;
	}

}
