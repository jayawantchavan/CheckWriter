package com.tmobile;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * This application gives an English equivalent output of given Currency value
 * written on a check
 * 
 * @author jayawant.chavan
 *
 */
public class CheckWriter {
	private static Scanner sc = new Scanner(System.in);

	/**
	 * This method convert the three number into word
	 * 
	 * @param number - integer number whose value is less than one thousand
	 * @return String
	 */
	private String convertThreeDigitNumberIntoWord(int number) {
		// This variable hold the number in the form of words
		String soFarString;

		if (number % 100 < 20) {
			soFarString = CheckWriterConstant.NUMBERVALUENAMES[number % 100];
			number = number / 100;
		} else {
			soFarString = CheckWriterConstant.NUMBERVALUENAMES[number % 10];
			number = number / 10;

			soFarString = CheckWriterConstant.TENSVALUENAMES[number % 10] + soFarString;
			number = number / 10;
		}

		if (number == 0) {
			return soFarString;
		}
		return CheckWriterConstant.NUMBERVALUENAMES[number] + CheckWriterConstant.HUNDRED + soFarString;
	}

	/**
	 * This method convert the number pre-decimal part of decimal number into word
	 * 
	 * @param intpart - This is the number which is to be converted into word
	 * @return String
	 */
	private String convertPreDecimalNumberIntoWord(long intpart) {
		if (intpart == 0) {
			return CheckWriterConstant.ZERO;
		}

		// Max limit of number
		DecimalFormat df = new DecimalFormat(CheckWriterConstant.NUMBER_LIMIT);
		String numberString = df.format(intpart);

		// Separated number in the below forms
		int trillions = Integer.parseInt(numberString.substring(0, 3));
		int billions = Integer.parseInt(numberString.substring(3, 6));
		int millions = Integer.parseInt(numberString.substring(6, 9));
		int thousands = Integer.parseInt(numberString.substring(9, 12));
		int ones = Integer.parseInt(numberString.substring(12, 15));

		// Convert and Store value in trillions in the form of word
		StringBuilder trillionsInWord = new StringBuilder();
		if (trillions == 0) {
			trillionsInWord.append("");
		} else {
			trillionsInWord.append(convertThreeDigitNumberIntoWord(trillions)).append(CheckWriterConstant.TRILLION);
		}
		StringBuilder result = trillionsInWord;

		// Convert and Store value in billions in the form of word
		StringBuilder billionsInWord = new StringBuilder();
		if (billions == 0) {
			billionsInWord.append("");
		} else {
			billionsInWord.append(convertThreeDigitNumberIntoWord(billions)).append(CheckWriterConstant.BILLION);
		}
		result.append(billionsInWord);

		// Convert and Store value in millions in the form of word
		StringBuilder millionsInWord = new StringBuilder();
		if (millions == 0) {
			millionsInWord.append("");
		} else {
			millionsInWord.append(convertThreeDigitNumberIntoWord(millions)).append(CheckWriterConstant.MILLION);
		}
		result.append(millionsInWord);

		// Convert and Store value in millions in the form of word
		StringBuilder thousandsInWord = new StringBuilder();
		if (thousands == 0) {
			thousandsInWord.append("");
		} else {
			thousandsInWord.append(convertThreeDigitNumberIntoWord(thousands)).append(CheckWriterConstant.THOUSAND);
		}
		result.append(thousandsInWord);

		// Convert and Store value in Ones in the form of word
		StringBuilder onesInWord = new StringBuilder();
		onesInWord.append(convertThreeDigitNumberIntoWord(ones));
		result.append(onesInWord);

		return result.toString();
	}

	/**
	 * This is the processing method for number conversion into word
	 * 
	 * @param number - Integer/float number in string form
	 * @return String
	 */
	public String convertInputNumberIntoWord(String number) {
		// Replace string into two integer part
		int index = number.indexOf(CheckWriterConstant.DOT);
		number = number.replace(CheckWriterConstant.DOT, CheckWriterConstant.FORWARD_SLASH);
		String num[] = number.split(CheckWriterConstant.SLASH_DELIMETER);

		// Take integer value which is on left side of '.' character
		long intpart = Long.parseLong(num[0]);
		StringBuilder decpart = new StringBuilder("");

		// call conversion method and store the output in string format
		String numberInWord = convertPreDecimalNumberIntoWord(intpart);

		// Replace leading, trailing and extra spaces of resulted string
		numberInWord = numberInWord.trim().replaceAll(CheckWriterConstant.SPACE_ADJUST, " ");

		// Make first character of string in upper case
		StringBuilder resultedString = new StringBuilder(numberInWord);
		resultedString.setCharAt(0, Character.toUpperCase(resultedString.charAt(0)));

		// Process the value which is on right side of '.' character from input string
		if (index != -1) {
			int decpartVal = Integer.parseInt(num[1]);
			if (decpartVal == 0) {
				return resultedString.append(CheckWriterConstant.DOLLARS).toString();
			} else {
				decpart.append(num[1]).append(CheckWriterConstant.CENT);
				return resultedString.append(CheckWriterConstant.DOLLARS_AND).append(decpart).toString();
			}
		} else {
			return resultedString.append(CheckWriterConstant.DOLLARS).toString();
		}
	}

	/**
	 * This is an entry point function for this application
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// Take the input from user
		System.out.println("Enter any positive integer or float number  ");
		String number = sc.nextLine();

		// Check for valid input
		try {
			Float.parseFloat(number);

			// call conversion processing method
			CheckWriter checkWriter = new CheckWriter();
			String result = checkWriter.convertInputNumberIntoWord(number);

			// Display Given number in the form of word
			System.out.println(result);
		} catch (Exception ex) {
			System.out.println("Entered input is invalid, please enter the valid postive integer or float number");
		}

	}

}
