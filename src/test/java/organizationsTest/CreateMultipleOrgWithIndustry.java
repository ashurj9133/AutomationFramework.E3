package organizationsTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import generalUtilities.ExcelFileUtility;
import generalUtilities.JavaUtility;
import generalUtilities.PropertiesFileUtility;
import generalUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.CreateNewOrganizationsPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;
import objectRepository.OrganizationInfoPage;
import objectRepository.OrganizationsPage;

public class CreateMultipleOrgWithIndustry {
	JavaUtility ju=new JavaUtility();
	ExcelFileUtility eu=new ExcelFileUtility();
	PropertiesFileUtility pfu=new PropertiesFileUtility();
	WebDriverUtility wbu=new WebDriverUtility();
	
	@Test(dataProvider="getData")
	public void CreateMultipleOrg(String ORG,String INDUSTRYNAME) throws IOException, InterruptedException
	{
		WebDriver driver=null;
		//Step 2: Read The Required Data
		String BROWSER = pfu.readDataFromPopertieFile("browser");
		String URL = pfu.readDataFromPopertieFile("url");
		String USERNAME = pfu.readDataFromPopertieFile("username");
		String PASSWORD = pfu.readDataFromPopertieFile("password");
		
		String ORGNAME=ORG+ju.getRandomNumber();
		
		
		
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			System.out.println("Browser lauched");
		}
		else
		{
			System.out.println("invalid browser mention");
		}
		
		wbu.maximizeWindow(driver);
		wbu.waitForPageLoad(driver);
		//Step 4:  load the url
		driver.get(URL);
		//Step 5:  login the application
	     LoginPage lp=new LoginPage(driver);
	     lp.loginApp(USERNAME, PASSWORD);
		
		//step 6: click on organization
	     HomePage hpc=new HomePage(driver);
	     hpc.clickOnOrganizationLnk();
	     
	     //step 7: click on Create organization look up image
	     OrganizationsPage op=new OrganizationsPage(driver);
		op.clickonOrganizationLookUPImg();
		
		//step  8: Create new Organization with mandatory fields
		CreateNewOrganizationsPage  cnop=new CreateNewOrganizationsPage(driver);
		cnop.createNewOrganization(ORGNAME, INDUSTRYNAME);
		wbu.captureScreenshot(driver, ORGNAME);
		
		//step 9: validate for organization
		
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		String orgHeader=oip.getHeaderText();
		if(orgHeader.contains(ORGNAME)) {
			System.out.println(orgHeader);
			System.out.println("organization created");
		}
		else
		{
			System.out.println("fail");
		}
		//step 10: logout
		hpc.logoutOfApp(driver);
		
		//step 11: close the Browser
		driver.quit();	
	}   
	@DataProvider
	public Object[][]getData() throws EncryptedDocumentException, IOException
	{
		
		return eu.readMultipleData("MultipleOrganizations");
		
	}
}
