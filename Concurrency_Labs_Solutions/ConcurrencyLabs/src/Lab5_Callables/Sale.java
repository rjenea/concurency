package Lab5_Callables;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Sale implements Serializable {

	private String name;
	private double value;
	
	public Sale(String name, double value) {
		this.name = name;
		this.value = value;
	}

	@Override
	public String toString() {
		return "Sold by " + name;
	}

	public String getName() {
		return name;
	}

	public double getValue() {
		return value;
	}

	
}
