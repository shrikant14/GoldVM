package in.main;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class MakeSale {

	private ArrayList<ItemDetail> itemDetails;
	HashMap<Integer, Integer> quantity;
	private String timestamp;
	private Receipt receipt;
	HashMap<Integer, Double> getTaxes;
	

	// Method to make sale
	public MakeSale(ArrayList<ItemDetail> itemDetails, HashMap<Integer, Integer> quantity, ITaxCalculatorAdapter taxCalculatorAdapter) {
		this.itemDetails = itemDetails;
		this.quantity = quantity;
		getTaxes=taxCalculatorAdapter.getTaxes(itemDetails, quantity);
		
		timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		receipt = new Receipt(itemDetails, timestamp, quantity,getTaxes);

	}
	
	// Method to get receipt
	public Receipt getReceipt(){
		return this.receipt;
	}
}
