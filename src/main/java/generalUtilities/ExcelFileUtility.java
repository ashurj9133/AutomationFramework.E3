package generalUtilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/*
 * This class consists of generic method related to excel file
 * @author ashutosh
 * 
 */
public class ExcelFileUtility {
    /*
     * This method read data from excel file and return value to the caller
     * @param sheetName
     * @param rowNO
     * @param cellNO
     * 
     */
	public String readDataFromExcel(String sheetName, int rowNo, int cellNo) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
	     Workbook book=WorkbookFactory.create(fis);
	     String value=book.getSheet(sheetName).getRow(rowNo).getCell(cellNo).getStringCellValue();
	return value;
	}
	
	/*
      *This method read multiple data from excel sheet and return value to the caller
      *used for DataProvider
     * @param sheetName
     * @param rowNO
     * @param cellNO
     * 
     */
	public Object[][] readMultipleData(String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
	     Workbook wb=WorkbookFactory.create(fis);
	     Sheet  sh=wb.getSheet(sheetName);
	     int lastRow=sh.getLastRowNum();
	     int lastCell=sh.getRow(0).getLastCellNum();
	     Object[][] data=new Object[lastRow][lastCell];
	     for(int i=0;i<lastRow;i++)
	     {
	    	 for(int j=0;j<lastCell;j++)
	    	 {
	    		 data[i][j] =sh.getRow(i+1).getCell(j).getStringCellValue();
	    	 }
	     }
	     return data;
	}
}
