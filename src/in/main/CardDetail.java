package in.main;

public class CardDetail {
	private int cardNumber;
	private int cvv;
	private String expireDate;

	public CardDetail(int cardNumber, int cvv, String expireDate) {
		this.cardNumber = cardNumber;
		this.cvv = cvv;
		this.expireDate = expireDate;
	}

	// Method to get the card number
	public int getCardNumber() {
		return cardNumber;
	}

	// Method to get the CVV number of the card
	public int getCvv() {
		return cvv;
	}

	// Method to get the Expiry date of the card
	public String getExpireDate() {
		return expireDate;
	}

}
