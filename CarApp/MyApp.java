package com.main;

import com.maruti.Car;
import com.maruti.EngineFactory;
import com.maruti.IEngine;

public class MyApp {

	public static void main(String[] args) throws Exception {

		// Getting Engine
		IEngine eng = EngineFactory.createEngine("electric");

		// Constructor Injection
		Car c = new Car(eng);

		// calling drive method
		c.drive();
	}
}
