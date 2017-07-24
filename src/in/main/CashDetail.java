package in.main;

public class CashDetail {

	private int numberOfBills;
	private int oneBill;
	private int fiveBill;
	private int tenBill;
	private int fiftyBill;
	private int hundredBill;

	public CashDetail(int numberOfBills, int oneBill, int fiveBill,
			int tenBill, int fiftyBill, int hundredBill) {
		this.numberOfBills = numberOfBills;
		this.oneBill = oneBill;
		this.fiveBill = fiveBill;
		this.tenBill = tenBill;
		this.fiftyBill = fiftyBill;
		this.hundredBill = hundredBill;
	}

	// Method to get number of bills
	public int getNumberOfBills() {
		return numberOfBills;
	}

	// Method to get number of $1 bill
	public int getOneBill() {
		return oneBill;
	}

	// Method to get number of $5 bill
	public int getFiveBill() {
		return fiveBill;
	}

	// Method to get number of $10 bill
	public int getTenBill() {
		return tenBill;
	}

	// Method to get number of $50 bill
	public int getFiftyBill() {
		return fiftyBill;
	}

	// Method to get number of $100 bill
	public int getHundredBill() {
		return hundredBill;
	}

}
