package in.main;

public class PaymentByCard {

	private double amount;
	private CardDetail cardDetail;
	private CardVerifier cardVerifier;

	public PaymentByCard(double amount, CardDetail cardDetail) {
		this.amount = amount;
		this.cardDetail = cardDetail;

	}

	// Method to make the transaction of sale by card
	public boolean makeTransaction() {
		boolean result = false;
		cardVerifier = new CardVerifier(cardDetail, amount);
		if (cardVerifier.getCardAuthorization()) {
			// deduct the amount from the card
			result = true;
		}
		return result;
	}
}
