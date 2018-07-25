package com.tmobile;

/**
 * This is a constant class which stores the constant value required to display
 * English equivalent output of given Currency value written on a check.
 * 
 * @author jayawant.chavan
 *
 */
public interface CheckWriterConstant {

	String NUMBER_LIMIT = "000000000000000";
	String TRILLION = " trillion ";
	String BILLION = " billion ";
	String MILLION = " million ";
	String THOUSAND = " thousand ";
	String HUNDRED = " hundred";
	String DOLLARS = " dollars only";
	String DOLLARS_AND = " dollars and ";
	String CENT = "/100";
	String SLASH_DELIMETER = "/";
	String SPACE_ADJUST = "\\s{2,}";
	char DOT = '.';
	char FORWARD_SLASH = '/';
	String ZERO = "zero";

	// Static array which hold the tens value in the form of word
	String[] TENSVALUENAMES = { "", " ten", " twenty", " thirty", " forty", " fifty", " sixty", " seventy", " eighty",
			" ninety" };

	// Static array which hold the number value in the form of word
	String[] NUMBERVALUENAMES = { "", " one", " two", " three", " four", " five", " six", " seven", " eight", " nine",
			" ten", " eleven", " twelve", " thirteen", " fourteen", " fifteen", " sixteen", " seventeen", " eighteen",
			" nineteen" };

}
