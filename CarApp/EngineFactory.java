package com.maruti;

public class EngineFactory {

	/**
	 * This method is used instantiate Engine based on fuel type
	 * 
	 * @param fuelType
	 * @return Object
	 */
	public static IEngine createEngine(String fuelType) {
		if (fuelType.equalsIgnoreCase("Diesel")) {
			DieselEngine de = new DieselEngine();
			return de;
		} else if (fuelType.equals("Petrol")) {
			PetrolEngine pe = new PetrolEngine();
			return pe;
		} else {
			return null;
		}
	}

}
