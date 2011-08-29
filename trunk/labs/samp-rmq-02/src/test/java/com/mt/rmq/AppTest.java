package com.mt.rmq;

import org.junit.Test;


/**
 * Unit test for simple App.
 */
public class AppTest {

	@Test
	public void rabbitApp() {
		RabbitApp rabbitApp = new RabbitApp();
		rabbitApp.execute("MAX", 500);
	}
}
