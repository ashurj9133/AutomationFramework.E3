package com.CRM.tiger.practice;

import java.io.IOException;

import generalUtilities.ExcelFileUtility;
import generalUtilities.JavaUtility;
import generalUtilities.PropertiesFileUtility;

public class GeneralUtilityPractice {

	public static void main(String[] args) throws IOException {
	PropertiesFileUtility pi=new PropertiesFileUtility();
	String value=pi.readDataFromPopertieFile("username");
	System.out.println(value);
	String Browser=pi.readDataFromPopertieFile("browser");
	System.out.println(Browser);
	
	ExcelFileUtility ex=new ExcelFileUtility();
	String data=ex.readDataFromExcel("Organization", 5, 3);
	System.out.println(data);
	
	
	JavaUtility ju=new JavaUtility();
	int r=ju.getRandomNumber();
	System.out.println(r);
   
	String date=ju.getSystemData();
	System.out.println(date);
	}

}
