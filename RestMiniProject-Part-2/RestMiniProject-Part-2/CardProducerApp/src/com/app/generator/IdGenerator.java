package com.app.generator;

import java.util.UUID;

public class IdGenerator {

	public static  String getTxId() {
		String uid=UUID.randomUUID()
				.toString()
				.replaceAll("-", "")
				.substring(0, 10)
				.toUpperCase();
				
		return uid;
	}
}
