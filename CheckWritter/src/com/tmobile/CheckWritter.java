package com.tmobile;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
* This application gives an English equivalent output of given Currency value written on a check
* @author jayawant.chavan
*
*/
public class CheckWritter
{ 
  private static Scanner sc=new Scanner(System.in);

  // Static array which hold the tens value in the form of word
  private static final String[] tensValueName = {"", " ten", " twenty", " thirty", " forty", " fifty", " sixty", " seventy", " eighty", " ninety"};

  //Static array which hold the number value in the form of word
  private static final String[] numberValueNames = { 
                                                           "", " one", " two", " three", " four", " five", " six", " seven", " eight", " nine",  " ten", " eleven",
                                                           " twelve",  " thirteen",  " fourteen",  " fifteen", " sixteen",  " seventeen",  " eighteen", " nineteen"
                                                         };
                     
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
             soFarString = numberValueNames[number % 100];
             number = number / 100;
           }
           else 
           {
             soFarString = numberValueNames[number % 10];
             number = number / 10;
       
             soFarString = tensValueName[number % 10] + soFarString;
             number = number / 10;
           }
           
           if (number == 0)
           {
              return soFarString;
           }
           return numberValueNames[number] + " hundred" + soFarString;
  }
  
  /**
* This method convert the number into word
* @param  intpart  This is the number which is to be converted into word
* @return String
*/
public static String convertNumberIntoWord(long intpart)
  {
           if (intpart == 0)
           { 
              return "zero";
           }
           
           // Max limit of number
           String numberLimit = "000000000000000";
           DecimalFormat df = new DecimalFormat(numberLimit);
           String numberString  = df.format(intpart);
           
           // Separated number in the below forms
           int trillions = Integer.parseInt(numberString.substring(0,3));
           int billions = Integer.parseInt(numberString.substring(3,6));
           int millions  = Integer.parseInt(numberString.substring(6,9));
           int thousands = Integer.parseInt(numberString.substring(9,12));
           int ones = Integer.parseInt(numberString.substring(12,15));
           
           // Convert and Store value in trillions in the form of word
           String trillionsInWord;
           switch (trillions) 
           {
           case 0:trillionsInWord = "";
                  break;
           default :trillionsInWord = convertBelowOneThousandValueIntoWord(trillions)+" trillions ";
           }
           String result =  trillionsInWord;
           
           // Convert and Store value in billions in the form of word
           String billionsInWord;
           switch (billions) 
           {
           case 0:billionsInWord = "";
                  break;
           default :billionsInWord = convertBelowOneThousandValueIntoWord(billions)+" billion ";
           }
           result = result+ billionsInWord;
       
           // Convert and Store value in millions in the form of word
           String millionsInWord;
           switch (millions) 
           {
           case 0: millionsInWord = "";
                   break;
           default :
             millionsInWord = convertBelowOneThousandValueIntoWord(millions)+" million ";
           }
           result =  result + millionsInWord;
          
           // Convert and Store value in millions in the form of word
           String thousandsInWord;
           switch (thousands)
           {
           case 0: thousandsInWord = "";
                   break;
           default : thousandsInWord = convertBelowOneThousandValueIntoWord(thousands)+" thousand ";
           }
           result =  result + thousandsInWord;
       
           // Convert and Store value in Ones in the form of word
           String onesInWord;
           onesInWord = convertBelowOneThousandValueIntoWord(ones);
           result =  result + onesInWord;
       
           return result.trim().replaceAll("\\s{2,}", " ");
  }
  
 /**
* This is the processing method for number conversion 
 * @param number   Integer/float number in string form
* @return String
*/
public static String convert(String number)
  {
           // Replace string into two integer part
           int index = number.indexOf('.');
           number = number.replace('.', '/');
           String num[] = number.split("/");
           
           // Take integer part string
           long intpart = Long.parseLong(num[0]);
           String decpart = "";
           
           //call conversion method
           String numberInWord = CheckWritter.convertNumberIntoWord(intpart);
         
           //Make first character of string in upper case
           StringBuilder resultedString = new StringBuilder(numberInWord);
           resultedString.setCharAt(0, Character.toUpperCase(resultedString.charAt(0)));
              
                  if(index != -1)
                  {   
                     // Take value after '.' character and display the same
                     int decpartVal=Integer.parseInt(num[1]);
                     if(decpartVal==0)
                     {
                            return resultedString+" dollars only";
                     }
                     else
                     {
                     decpart = num[1]  + "/100";
                     return resultedString + " dollars and "+decpart;
                      }
                  }
                  else
                  {
                     return resultedString+" dollars only";
                  } 
     }

  /**
* This is an entry point function for this application
* @param args
*/
public static void main(String[] args) 
  {   
         // Take the input from user
         System.out.println("Enter any possitive integer or float number  ");
         String number = sc.nextLine();
         
         //call conversion processing method
         String resultedNumber = convert(number);
         
         // Display Given number in the form of word
         System.out.println(resultedNumber);
  }
  
}
