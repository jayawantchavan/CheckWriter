package com.tmobile;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
* This application gives an English equivalent output of given Currency value written on a check
* @author jayawant.chavan
*
*/
public class CheckWriter
{ 
  private static Scanner sc = new Scanner(System.in);
                     
/**
* This method convert the number which is less than one thousand into word
* @param  number  integer number whose value is less than one thousand
* @return String
*/
private static String convertBelowOneThousandValueIntoWord(int number)
{
           // This variable hold the number in the form of words
	       String soFarString;
       
           if (number % 100 < 20)
           {
             soFarString = CheckWriterConstant.numberValueNames[number % 100];
             number = number / 100;
           }
           else 
           {
             soFarString = CheckWriterConstant.numberValueNames[number % 10];
             number = number / 10;
       
             soFarString = CheckWriterConstant.tensValueName[number % 10] + soFarString;
             number = number / 10;
           }
           
           if (number == 0)
           {
              return soFarString;
           }
           return CheckWriterConstant.numberValueNames[number] + CheckWriterConstant.hundred + soFarString;
  }
  
  /**
* This method convert the number into word
* @param  intpart  This is the number which is to be converted into word
* @return String
*/
public static StringBuffer convertNumberIntoWord(long intpart)
  {
           if (intpart == 0)
           { 
              return CheckWriterConstant.zero;
           }
           
           // Max limit of number
           DecimalFormat df = new DecimalFormat(CheckWriterConstant.numberLimit);
           String numberString  = df.format(intpart);
           
           // Separated number in the below forms
           int trillions = Integer.parseInt(numberString.substring(0,3));
           int billions = Integer.parseInt(numberString.substring(3,6));
           int millions  = Integer.parseInt(numberString.substring(6,9));
           int thousands = Integer.parseInt(numberString.substring(9,12));
           int ones = Integer.parseInt(numberString.substring(12,15));
           
           // Convert and Store value in trillions in the form of word
           StringBuffer trillionsInWord = new StringBuffer();
           if(trillions == 0)
           {
        	   trillionsInWord.append("");
           }
           else
           {
        	   trillionsInWord.append(convertBelowOneThousandValueIntoWord(trillions)).append(CheckWriterConstant.trillion);
           }
           StringBuffer result =  trillionsInWord;
           
           // Convert and Store value in billions in the form of word
           StringBuffer billionsInWord = new StringBuffer();
           if(billions == 0)
           {
        	   billionsInWord.append(""); 
           }
           else
           {
        	   billionsInWord.append(convertBelowOneThousandValueIntoWord(billions)).append(CheckWriterConstant.billion);
           }
           result.append(billionsInWord);
       
           // Convert and Store value in millions in the form of word
           StringBuffer millionsInWord = new StringBuffer();
           if(millions == 0)
           {
        	   millionsInWord.append("");
           }
           else
           {
        	   millionsInWord.append(convertBelowOneThousandValueIntoWord(millions)).append(CheckWriterConstant.million);
           }
           result.append(millionsInWord);
          
           // Convert and Store value in millions in the form of word
           StringBuffer thousandsInWord = new StringBuffer();
           if (thousands == 0)
           {
        	   thousandsInWord.append("");
           }
           else
           {
        	   thousandsInWord.append(convertBelowOneThousandValueIntoWord(thousands)).append(CheckWriterConstant.thousand);
           }
           result.append(thousandsInWord);
       
           // Convert and Store value in Ones in the form of word
           StringBuffer onesInWord = new StringBuffer();
           onesInWord.append(convertBelowOneThousandValueIntoWord(ones));
           result.append(onesInWord);
           
           return result;
  }
  
 /**
* This is the processing method for number conversion 
 * @param number   Integer/float number in string form
* @return String
*/
public static StringBuffer convert(String number)
  {        
           // Replace string into two integer part
           int index = number.indexOf('.');
           number = number.replace('.', '/');
           String num[] = number.split("/");
           
           // Take integer value which is on left side of '.' character
           long intpart = Long.parseLong(num[0]);
           StringBuffer decpart = new StringBuffer("");
           
           //call conversion method and store the output in string form
           String numberInWord = CheckWriter.convertNumberIntoWord(intpart).toString();
           
           //Replace leading, trailing and extra spaces of resulting string
           numberInWord = numberInWord.trim().replaceAll("\\s{2,}", " ");
           
           //Make first character of string in upper case
           StringBuffer resultedString = new StringBuffer(numberInWord);
           resultedString.setCharAt(0, Character.toUpperCase(resultedString.charAt(0)));
           
                  if(index != -1)
                  {   
                     // Take value which is one right side of '.' character and display the same
                     int decpartVal=Integer.parseInt(num[1]);
                     if(decpartVal==0)
                     {
                         return resultedString.append(CheckWriterConstant.dollars);
                     }
                     else
                     {
	                     decpart.append(num[1]).append(CheckWriterConstant.cent);
	                     return resultedString.append(CheckWriterConstant.dollarsAnd).append(decpart);
                     }
                  }
                  else
                  {
                     return resultedString.append(CheckWriterConstant.dollars);
                  } 
     }

  /**
* This is an entry point function for this application
* @param args
*/
public static void main(String[] args) 
  {   
    // Take the input from user
    System.out.println("Enter any positive integer or float number  ");
    String number = sc.nextLine();
    
    //Check for valid input
    try {
         Float.parseFloat(number);
    } catch(Exception ex) {
         throw new IllegalArgumentException("invalid input");
    }
   
    //call conversion processing method
    StringBuffer resultedNumber = convert(number);
        
    // Display Given number in the form of word
    System.out.println(resultedNumber);
  }
  
}
