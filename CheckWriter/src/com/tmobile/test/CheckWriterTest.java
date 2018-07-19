package com.tmobile.test;

import static org.junit.Assert.*;
import org.junit.Test;

import com.tmobile.CheckWriter;

/**
 * This class provide checks for CheckWriter application on basis of valid as well as invalid input value
 * @author jayawant.chavan
 *
 */
public class CheckWriterTest {

	@Test
	public void ChecksValidConversionOfIntegerNumberIntoWord() {
		StringBuffer expectedResult = new StringBuffer("One hundred twenty three dollars only");
	    StringBuffer actualResult = CheckWriter.convert("123");
	    boolean result = expectedResult.toString().equals(actualResult.toString()); 
	    assertTrue(result);
	}
     
	@Test
	public void ChecksInValidConversionForNegativeInputIntegerNumberd() {
		StringBuffer expectedResult = new StringBuffer("One hundred twenty three dollars only");
	    StringBuffer actualResult = CheckWriter.convert("-123");
	    boolean result = expectedResult.toString().equals(actualResult.toString()); 
	    assertFalse(result);
	}
	
	@Test
	public void ChecksValidConversionOfFloatNumberIntoWord() {
		StringBuffer expectedResult = new StringBuffer("Forty five thousand six hundred twenty three dollars and 21/100");
	    StringBuffer actualResult = CheckWriter.convert("45623.21");
	    boolean result = expectedResult.toString().equals(actualResult.toString()); 
	    assertTrue(result);
	}
	
	@Test
	public void ChecksInValidConversionForNegativeInputFloatNumberd() {
		StringBuffer expectedResult = new StringBuffer("forty five thousand six hundred twenty three dollars and 21/100");
	    StringBuffer actualResult = CheckWriter.convert("-45623.21");
	    boolean result = expectedResult.toString().equals(actualResult.toString()); 
	    assertFalse(result);
	}

}
