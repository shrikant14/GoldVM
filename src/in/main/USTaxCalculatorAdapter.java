package in.main;

import java.util.ArrayList;
import java.util.HashMap;

public class USTaxCalculatorAdapter implements ITaxCalculatorAdapter {

	double salesTaxRate = 12;

	@Override
	public HashMap<Integer, Double> getTaxes(ArrayList<ItemDetail> itemDetails,
			HashMap<Integer, Integer> quantity) {
		// TODO Auto-generated method stub
		int q;
		double price, totalPrice, tax;
		HashMap<Integer, Double> saleTax = new HashMap<Integer, Double>();

		for (ItemDetail item : itemDetails) {
			q = quantity.get(item.getItemID());
			price = item.getAmount();
			totalPrice = q * price;
			tax = (totalPrice * salesTaxRate) / 100;

			saleTax.put(item.getItemID(), tax);
		}

		return saleTax;
	}

}
