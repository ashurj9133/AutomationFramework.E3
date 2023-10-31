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
import objectRepository.HomePage;
import objectRepository.LoginPage;

public class CreateOrganization {

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
		
		String ORGNAME=eu.readDataFromExcel("Organization", 1, 2)+ju.getRandomNumber();
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
		               //LoginPage lp=new LoginPage(driver);
		                //lp.loginApp(USERNAME,PASSWORD);
		// Step 6: Navigate to Organizations link
		
		HomePage hp=new HomePage(driver);
		hp.getContactsLnk().click();
		hp.getOrganizationsLnk().click();
				//driver.findElement(By.linkText("Organizations")).click();
		
		
		//Step 7: Click on Create Organization look Up Imge
				driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
				//driver.findElement(By.cssSelector("[title='Create Organization...']")).click();

				//Step 7: Create Organization with mandatory information
				driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
				
				//Step 8: save
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				
				 String OrgHeader=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			        if(OrgHeader.contains(ORGNAME))  //equals krne pr test case fail dekhayega
			        {
			        	System.out.println(OrgHeader);
			     	   System.out.println("pass");
			        }
			        else
			        {
			     	   System.out.println("fail");
			        }
			        
			      //Step 10: Logout of Application
					WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
					wbu.mouseHoverAction(ele, driver);
					
					driver.findElement(By.linkText("Sign Out")).click();
					System.out.println("logout successful");
					wbu.quitBrowser(driver);
	}

}
