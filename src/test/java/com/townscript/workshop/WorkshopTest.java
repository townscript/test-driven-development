package com.townscript.workshop;

import static org.junit.Assert.*;

import org.junit.Test;

public class WorkshopTest {

	@Test
    public void testEvenOddNumber(){
		EvenOdd meo = new EvenOdd();
        assertEquals("10 is a even number", true, meo.isEvenNumber(10));
    }
}
