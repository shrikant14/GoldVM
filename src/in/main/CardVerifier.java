package in.main;

public class CardVerifier {

	private CardDetail cardDetail;
	private double amount;

	public CardVerifier(CardDetail cardDetail, double amount) {
		this.cardDetail = cardDetail;
		this.amount = amount;
	}

	// Method to verify the authenticity of the card
	public boolean getCardAuthorization() {
		boolean output = false;
		// call the card authorization company with the card details to verify
		// the card
		output = true;
		return output;
	}
}
