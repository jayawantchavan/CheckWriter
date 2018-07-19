package com.tmobile;

/**
 * This is a constant class which stores the constant value required to display English equivalent 
 *      output of given Currency value written on a check.
 * @author jayawant.chavan
 *
 */
public class CheckWriterConstant {
     
	public static final String numberLimit = "000000000000000";
	public static final String trillion= " trillion ";
	public static final String billion = " billion ";
	public static final String million= " million ";
	public static final String thousand = " thousand ";
	public static final String hundred = " hundred";
	public static final String dollars = " dollars only";
	public static final String dollarsAnd = " dollars and ";
	public static final String cent = "/100";
	public static final StringBuffer zero = new StringBuffer("zero");
	
	// Static array which hold the tens value in the form of word
	public static final String[] tensValueName = {"", " ten", " twenty", " thirty", " forty", " fifty", " sixty", " seventy", " eighty", " ninety"};

	//Static array which hold the number value in the form of word
	public static final String[] numberValueNames = { 
	                                                 "", " one", " two", " three", " four", " five", " six", " seven", " eight", " nine",  " ten", " eleven",
	                                                 " twelve",  " thirteen",  " fourteen",  " fifteen", " sixteen",  " seventeen",  " eighteen", " nineteen"
	                                                };
}
