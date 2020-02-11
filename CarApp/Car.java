package com.maruti;

public class Car {

	private IEngine eng;

	public void setEng(IEngine eng) {
		this.eng = eng;
	}

	public Car(IEngine eng) {
		this.eng = eng;
	}

	public void drive() throws Exception {

		int engineStatus = 0;

		if (null != eng) {
			engineStatus = eng.start();

			if (engineStatus == 0) {
				System.out.println("Driving started...!!");
			} else if (engineStatus == 1) {
				System.out.println("Restart-Engine...!!");
			} else if (engineStatus == 2) {
				System.out.println("Fuel completed...!!");
			} else {
				System.out.println("Contact Mechaninc..!!");
			}
		} else {
			throw new Exception("No Suitable Engine Found..!!");
		}
	}
}
