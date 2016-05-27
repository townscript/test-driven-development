package com.townscript.workshop;

import static org.junit.Assert.*;

import org.junit.Test;

public class WorkshopTest {

	@Test
    public void testEvenOddNumber(){
		int number = 10;
		boolean isEven = number%2 == 0;
        assertEquals("10 is a even number", true, isEven);
    }
}
