package org.hman.lab;

import java.text.DecimalFormat;

import org.junit.Ignore;
import org.junit.Test;


/**
 * Unit test for simple App.
 */
public class AppTest {
    
	@Test
	@Ignore
    public void testApp() {
        Float sample = 100f;
        Float time = 11779f;
    
        System.out.print(
        	new DecimalFormat("###,###,##0.00").format(
        			(sample*1000)/time
        	)
        );
    }
}
