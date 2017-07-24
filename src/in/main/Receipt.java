package in.main;

import java.util.ArrayList;
import java.util.HashMap;

public class Receipt {

	private ArrayList<ItemDetail> itemDetails;
	private String timestamp;
	private String receipt;
	HashMap<Integer, Integer> quantity;
	private double totalAmount, totalAmountAfterTax;
	HashMap<Integer, Double> getTaxes;

	public Receipt(ArrayList<ItemDetail> itemDetails, String timestamp,
			HashMap<Integer, Integer> quantity,
			HashMap<Integer, Double> getTaxes) {
		this.itemDetails = itemDetails;
		this.timestamp = timestamp;
		this.quantity = quantity;
		this.getTaxes = getTaxes;

	}

	// Method to get receipt of the transaction
	public String getReceipt() {
		StringBuilder rec = new StringBuilder("");

		for (ItemDetail item : this.itemDetails) {
			rec.append("\n\t\tITEM - " + item.getItemName());
			rec.append("\n\t\tPRICE PER QUANTITY - $" + item.getAmount());
			int q = quantity.get(item.getItemID());
			double total = q * item.getAmount();
			rec.append("\n\t\tQUANTITY - " + q);
			rec.append("\n\t\tTOTAL - $" + total);
			rec.append("\n\t\tTAX - $" + this.getTaxes.get(item.getItemID())
					+ "\n");
			totalAmount = totalAmount + total;
			totalAmountAfterTax = totalAmountAfterTax + total
					+ this.getTaxes.get(item.getItemID());
		}
		rec.append("\t\t-----------------------");
		rec.append("\n\n\t\tTOTAL - $" + totalAmount + " ");
		rec.append("\n\t\tTOTAL AFTER TAX - $" + totalAmountAfterTax);
		rec.append("\n\t\tGENERATED AT - " + this.timestamp);

		this.receipt = rec.toString();
		return this.receipt;
	}

	// Method to get the total amount of the sale
	public Double getTotal() {
		return this.totalAmountAfterTax;
	}

}
