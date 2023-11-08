package generalUtilities;

import java.io.IOException;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v114.browser.Browser;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.HomePage;
import objectRepository.LoginPage;

public class BaseClass {
	 
            public     JavaUtility ju=new JavaUtility();
    		public	    ExcelFileUtility eu=new ExcelFileUtility();
    		public	PropertiesFileUtility pfu=new PropertiesFileUtility();
    		public	WebDriverUtility wbu=new WebDriverUtility();
    	    public       WebDriver driver = null;
    	    public static WebDriver sDriver;
    	    
               @BeforeSuite(groups = {"SmokeSuite","RegressionSuite"})
               public void bsConfig() {
            	   System.out.println("===Open server connection===");
               }
               //@Parameters("browser")
               //@BeforeTest                   //distributed parellel execution ke liye
               @BeforeClass(alwaysRun = true)
               public void bcConfig(/*String BROWSER*/) throws IOException {
            	 //Step 2: Read The Required Data
       			String BROWSER = pfu.readDataFromPopertieFile("browser");  //cross browser me esko comment kr denge
       			String URL = pfu.readDataFromPopertieFile("url");

       			if(BROWSER.equalsIgnoreCase("chrome"))
       			{
       				WebDriverManager.chromedriver().setup();
       				driver=new ChromeDriver();
       				System.out.println(BROWSER+"--Browser lauched--");
       			}
       			else if(BROWSER.equalsIgnoreCase("edge"))
       			{
       				WebDriverManager.edgedriver().setup();
       				driver=new EdgeDriver();
       				System.out.println(BROWSER+"--Browser lauched--");
       				
       			}
       			else {
       				System.out.println("invalid browser mention");
					
				}
       			
       			wbu.maximizeWindow(driver);
       			wbu.waitForPageLoad(driver);
       			//used in listener
       			sDriver=driver;
       			
       			//Step 4:  load the url
       			driver.get(URL);
       			System.out.println("---Launch the browser---");
               }
               @BeforeMethod(alwaysRun = true)
               public void bmConfig() throws IOException
               {
            	   String USERNAME = pfu.readDataFromPopertieFile("username");
          			String PASSWORD = pfu.readDataFromPopertieFile("password");
            	   LoginPage lPage=new LoginPage(driver);
            			   lPage.loginApp(USERNAME, PASSWORD);
            			   System.out.println("---Login successful---");
               }
               @AfterMethod(alwaysRun = true)
               public void amConfig() throws InterruptedException
               {
            	   
            	  HomePage hmHomePage=new HomePage(driver);
            	  hmHomePage.logoutOfApp(driver);
            	  System.out.println("---Logout successful---");
               }
               //@AfterTest
               @AfterClass(alwaysRun = true)
               public void acConfig()
               {
            	  driver.quit();
            	  System.out.println("---Close the Browser---");
               }
               @AfterSuite(alwaysRun = true)
               public void asconfig()
               {
            	   System.out.println("===Close Server Connection===");
               }
}
