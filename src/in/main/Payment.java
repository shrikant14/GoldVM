package in.main;

public class Payment {

	private double amount;
	private double change = 0;

	public Payment(double amount) {
		this.amount = amount;

	}

	// Method to make payment
	public boolean makePayment(Object paymentType) {
		boolean result = false;
		if (paymentType instanceof CardDetail) {
			PaymentByCard payment = new PaymentByCard(this.amount,
					(CardDetail) paymentType);
			return payment.makeTransaction();
		} else if (paymentType instanceof CashDetail) {
			PayByCash payment = new PayByCash(this.amount,
					(CashDetail) paymentType);
			result = payment.makeTransaction();
			this.change = payment.getChange();
			System.out.println("\n\tChange due $" + this.change);
			return result;
		}
		return result;
	}
}
