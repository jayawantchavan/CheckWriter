package com.tmobile.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import com.tmobile.CheckWriter;

/**
 * This class provide checks for CheckWriter application on basis of valid as
 * well as invalid input value
 * 
 * @author jayawant.chavan
 *
 */
public class CheckWriterTest {
	CheckWriter checkWriter = new CheckWriter();

	@Test
	public void ChecksNumberToWordConversionForValidIntegerInput() {
		StringBuilder expectedResult = new StringBuilder("One hundred twenty three dollars only");
		StringBuilder actualResult = checkWriter.convertInputNumberIntoWord("1536353623");
		boolean result = expectedResult.toString().equals(actualResult.toString());
		assertTrue(result);
	}

	@Test
	public void ChecksNumberToWordConversionForInValidIntegerInput() {
		StringBuilder expectedResult = new StringBuilder("One hundred twenty three dollars only");
		StringBuilder actualResult = checkWriter.convertInputNumberIntoWord("-76538123");
		boolean result = expectedResult.toString().equals(actualResult.toString());
		assertFalse(result);
	}

	@Test
	public void ChecksNumberToWordConversionForValidFloatInput() {
		StringBuilder expectedResult = new StringBuilder(
				"Forty five thousand six hundred twenty three dollars and 21/100");
		StringBuilder actualResult = checkWriter.convertInputNumberIntoWord("45623.21");
		boolean result = expectedResult.toString().equals(actualResult.toString());
		assertTrue(result);
	}

	@Test
	public void ChecksNumberToWordConversionForInValidFloatInput() {
		StringBuilder expectedResult = new StringBuilder(
				"forty five thousand six hundred twenty three dollars and 21/100");
		StringBuilder actualResult = checkWriter.convertInputNumberIntoWord("-45623.21");
		boolean result = expectedResult.toString().equals(actualResult.toString());
		assertFalse(result);
	}

}
