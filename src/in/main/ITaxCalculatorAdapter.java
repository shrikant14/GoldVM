package in.main;

import java.util.ArrayList;
import java.util.HashMap;

public interface ITaxCalculatorAdapter {

	public HashMap<Integer, Double> getTaxes(ArrayList<ItemDetail> itemDetails,
			HashMap<Integer, Integer> quantity);

}
