package com.CRM.tiger.practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ReadDataFromExcelsheet {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
	FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
     Workbook book=WorkbookFactory.create(fis);
     Sheet sh=book.getSheet("Contacts");
     Row r=sh.getRow(1);
     Cell c=r.getCell(2);
     String value=c.getStringCellValue();
     System.out.println(value);
     
     
	}

}
