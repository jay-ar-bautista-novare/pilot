package com.sofa.pilot.config;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class PropertyLoaderTest {

	private static final String TEST_KEY = "MONGO_HOST";
	private static final String TEST_VALUE = "localhost";

	@Test
	void givenPropertyLoaderWhenGetValueOfIsInvokedThenExpectedResultIsReturned() {
		PropertyLoader propertyLoader = new PropertyLoader();

		String result = propertyLoader.getValueOf(TEST_KEY);

		assertEquals(TEST_VALUE, result);
	}
}
