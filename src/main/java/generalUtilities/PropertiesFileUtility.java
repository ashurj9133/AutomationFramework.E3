package generalUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/*
 * This class consists of generic method related to excel file
 * @author ashutosh
 */
public class PropertiesFileUtility {
	/*
	 * This method read the data from excel file and return value to the caller
	 * @param sheetname
	 * @param rowno
	 * @param cellno
	 * @return
	 * @throws   EncryptedDocumentException
	 * @throws IOException
	 */

	public String readDataFromPopertieFile(String key) throws IOException
	{
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p=new Properties();
		p.load(fis);
		String value=p.getProperty(key);
		return value;
	}

}
