package com.CRM.tiger.practice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import generalUtilities.ExcelFileUtility;
import generalUtilities.JavaUtility;
import generalUtilities.PropertiesFileUtility;
import generalUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.ContactsPage;
import objectRepository.CreateNewOrganizationsPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;
import objectRepository.OrganizationsPage;

public class CreateContactsWithOrganization {

	public static void main(String[] args) throws IOException {
		JavaUtility ju=new JavaUtility();
		ExcelFileUtility eu=new ExcelFileUtility();
		PropertiesFileUtility pfu=new PropertiesFileUtility();
		WebDriverUtility wbu=new WebDriverUtility();
    WebDriver driver = null;
		
		//Step 2: Read The Required Data
		String BROWSER = pfu.readDataFromPopertieFile("browser");
		String URL = pfu.readDataFromPopertieFile("url");
		String USERNAME = pfu.readDataFromPopertieFile("username");
		String PASSWORD = pfu.readDataFromPopertieFile("password");
		
		String ORGNAME=eu.readDataFromExcel("Contacts", 8, 3)+ju.getRandomNumber();
		String LASTNAME=eu.readDataFromExcel("Contacts", 8, 2);
		
		String ORGNAME1=eu.readDataFromExcel("Organization", 1, 2)+ju.getRandomNumber();
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
		driver.get(URL);
		//Step 3: Login to Application
//		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//		driver.findElement(By.id("submitButton")).click();
		
		LoginPage lp=new LoginPage(driver);
		lp.getUserNameEdt().sendKeys(USERNAME);
		lp.getPasswordEdt().sendKeys(PASSWORD);
		lp.getLoginBtn().click();
		// Step 6: Navigate to Organizations link
				//driver.findElement(By.linkText("Organizations")).click();
		HomePage hp=new HomePage(driver);
		hp.getOrganizationsLnk().click();
		//Step 7: Click on Create Organization look Up Imge
				//driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
				//driver.findElement(By.cssSelector("[title='Create Organization...']")).click();
				OrganizationsPage op=new OrganizationsPage(driver);
				op.getPlusIcon().click();

				                                   
				
				//Step 7: Create Organization with mandatory information
				//driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
				CreateNewOrganizationsPage cno=new CreateNewOrganizationsPage(driver);
			    cno.getOrgNameEdt().sendKeys(ORGNAME1);
				//Step 8: save
				    //driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				cno.getSaveBtn();
				
				 String OrgHeader=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
				 if(OrgHeader.contains(ORGNAME1))  //equals krne pr test case fail dekhayega
			        {
			        	System.out.println(OrgHeader);
			     	   System.out.println("organization created successfully");
			        }
			        else
			        {
			     	   System.out.println("fail");
			        }
				 
				// Step 10: Navigate to Contacts
					driver.findElement(By.linkText("Contacts")).click();

					// Step 11: Click on create Contact look Up Image
					driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();

					// Step 12: Create Contact with mandatory fields
					driver.findElement(By.name("lastname")).sendKeys(LASTNAME);

					// Step 13: click on Organization look Up Image
					driver.findElement(By.xpath("(//img[@alt='Select'])[1]")).click();
					wbu.swtichToWindow(driver, "Accounts");

					driver.findElement(By.name("search_text")).sendKeys(ORGNAME);
					driver.findElement(By.name("search")).click();
					driver.findElement(By.xpath("//a[text()='" + ORGNAME + "']")).click();
					// Orgname is dynamic
					// xpath is changing dynamically - dynamic xpath
					// a[text()='"+varible+"']

					wbu.swtichToWindow(driver, "Contacts");

					// Step 14: save
					driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

					// Step 15: Validate for Organization
					String ContactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();

					if (ContactHeader.contains(LASTNAME)) {
						System.out.println(ContactHeader);
						System.out.println("PASS");
					} else {
						System.out.println("FAIL");
					}

					// Step 16: logout of app
					WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
					wbu.mouseHoverAction(ele, driver);

					driver.findElement(By.linkText("Sign Out")).click();
					System.out.println("logout successful");


	}

	

}
