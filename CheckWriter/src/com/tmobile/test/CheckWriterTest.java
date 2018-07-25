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

	/**
	 * This method checks number to word conversion for valid positive Integer value
	 */
	@Test
	public void ChecksNumberToWordConversionForValidIntegerInput() {
		String expectedResult = "One million five hundred forty two thousand one hundred forty three dollars only";
		String actualResult = checkWriter.convertInputNumberIntoWord("1542143");
		boolean result = expectedResult.toString().equals(actualResult.toString());
		assertTrue(result);
	}

	/**
	 * This method checks number to word conversion for negative integer value
	 */
	@Test
	public void ChecksNumberToWordConversionForInValidIntegerInput() {
		String expectedResult = "Three hundred forty eight thousand two hundred fifty six dollars only";
		String actualResult = checkWriter.convertInputNumberIntoWord("-348256");
		boolean result = expectedResult.toString().equals(actualResult.toString());
		assertFalse(result);
	}

	/**
	 * This method checks number to word conversion for valid positive float value
	 */
	@Test
	public void ChecksNumberToWordConversionForValidFloatInput() {
		String expectedResult = new String("Forty five thousand six hundred twenty three dollars and 21/100");
		String actualResult = checkWriter.convertInputNumberIntoWord("45623.21");
		boolean result = expectedResult.toString().equals(actualResult.toString());
		assertTrue(result);
	}

	/**
	 * This method checks number to word conversion for negative float value
	 */
	@Test
	public void ChecksNumberToWordConversionForInValidFloatInput() {
		String expectedResult = new String("forty five thousand six hundred twenty three dollars and 21/100");
		String actualResult = checkWriter.convertInputNumberIntoWord("-45623.21");
		boolean result = expectedResult.toString().equals(actualResult.toString());
		assertFalse(result);
	}

}
