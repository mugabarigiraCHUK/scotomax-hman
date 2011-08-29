package com.mt.rmq;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import org.junit.Ignore;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

	@Test
	public void rabbitApp() {
		RabbitApp rabbitApp = new RabbitApp();
		rabbitApp.execute("MAX");
	}
	
	@Ignore
	@Test
	public void format() {
		NumberFormat formatter = new DecimalFormat("0.000");
		float number = 87;
		System.out.println("Formatter: "+formatter.format(number/1000));
	}
}
