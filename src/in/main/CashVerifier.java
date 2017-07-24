package in.main;

public class CashVerifier {

	private CashDetail cashDetail;
	private double amount;

	public CashVerifier(CashDetail cashDetail, double amount) {
		this.cashDetail = cashDetail;
		this.amount = amount;
	}

	// Method to calculate total amount of cash
	public int calculateCash() {
		int sum = 0;
		sum = this.cashDetail.getOneBill() * 1 + this.cashDetail.getFiveBill()
				* 5 + this.cashDetail.getTenBill() * 10
				+ this.cashDetail.getFiftyBill() * 50
				+ this.cashDetail.getHundredBill() * 100;
		return sum;
	}

	// Method to calculate the change due
	public double calculateChange() {
		double change = 0;
		change = calculateCash() - amount;
		return change;

	}

	// Method to check number of bills
	public boolean checkNumberOfbills() {
		boolean result = false;
		int sum = this.cashDetail.getOneBill() + this.cashDetail.getFiveBill()
				+ this.cashDetail.getTenBill() + this.cashDetail.getFiftyBill()
				+ this.cashDetail.getHundredBill();
		if (sum == this.cashDetail.getNumberOfBills()) {
			result = true;
		} else {
			System.out.println("\tIncorrect number of bills");
		}
		return result;
	}

	// Method to check the inserted amount is correct or not
	public boolean cashVerification() {
		boolean result = false;
		if (calculateCash() >= amount) {
			result = true;
		} else {
			System.out.println("\tInserted cash is lesser than the amount");
		}
		return result;

	}

}
