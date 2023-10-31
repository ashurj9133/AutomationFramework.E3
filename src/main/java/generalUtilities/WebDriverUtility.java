package generalUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class WebDriverUtility {
     public void maximizeWindow(WebDriver driver)
     {
    	 driver.manage().window().maximize();
     }
     public void minimizeWindow(WebDriver driver)
     {
    	 driver.manage().window().minimize();
     }
     public void waitForPageLoad(WebDriver driver)
     {
    	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
     }
    public void waitForElementToBeVisible(WebDriver driver,WebElement element)
    {
    	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
    	wait.until(ExpectedConditions.visibilityOf(element));
    }
   public void waitForElementToClickable(WebDriver driver,WebElement element)
   {
	   WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
   	wait.until(ExpectedConditions.elementToBeClickable(element));
   }
   /*
    * This method will perform double click
    * @param driver
    */
   public void handleDropDown(WebElement element,int index)
   {
	   Select se=new Select(element);
	   se.selectByIndex(index);
   }
   /*
    * This method will perform double click
    * @param driver
    */
   public void handleDropDown(WebElement element,String value)
   {
	   Select se=new Select(element);
	   se.selectByValue(value);
   }
   /*
    * This method will perform 
    * @param driver
    * @param element
    */
   public void handleDropDown(String text,WebElement element)
   {
	   Select se=new Select(element);
	   se.selectByVisibleText(text);
   }
   /*
    * This method will perform mouse hover action
    * @param driver
    * @param element
    */
   public void mouseHoverAction(WebElement element,WebDriver driver)
   {
	   Actions act=new Actions(driver);
	   act.moveToElement(element).perform();
   }
   /*
    * This method will move to cursor based on the offset and click on webpage
    * @param driver
    */
   public void moveAndClick(WebDriver driver)
   {
	   Actions act=new Actions(driver);
	   act.moveByOffset(10, 10).click().perform();
   }
   /*
    * This method will perform right click
    * @param driver
    */
   public void rightClickAction(WebDriver driver)
   {
	   Actions act=new Actions(driver);
	   act.contextClick().perform();
   }
/*
 * This method will perform double click
 * @param driver
 */
public void doubleClickAction(WebDriver driver)
{
	Actions act=new Actions(driver);
	act.doubleClick().perform();
}
/*
 * This method will perform drag and drop operation
 * @param src point
 * @param des point
 * @param driver
 */
 public void dragAndDropAction(WebDriver driver, WebElement src,WebElement des)
 {
	 Actions act=new Actions(driver);
	 act.dragAndDrop(src, des).perform();
 }
 /*
  * this method will handle frame by index
  * @param driver
  * @param index
  */
public void switchToFrame(WebDriver driver, int index)
{
	driver.switchTo().frame(index);
	}
/*
 * This method will handle frame by name or id
 * @param name or id
 * @param driver
 */
public void switchToFrame(WebDriver driver, String NameOrId)
{
	driver.switchTo().frame(NameOrId);
}
/*
 * This method will handle frame by WebElement
 * @param driver
 */
public void switchToFrame(WebElement element,WebDriver driver)
{
	driver.switchTo().frame(element);
	}
/*
 * This method will perform scroll down action by 500 unit
 * @param driver
 */
 public void scrollDownAction(WebDriver driver)
 {
	 JavascriptExecutor js=(JavascriptExecutor)driver;
	 js.executeScript("window.scrollBy(0,500)","");
 }
 /*
  * This method will perform scroll up action by 500 unit
  * @param driver
  */
 public void scrollUpAction(WebDriver driver)
 {
	 JavascriptExecutor js=(JavascriptExecutor)driver;
	 js.executeScript("window.scrollBy(0,-500)", null);
 }
 /*
  * This method will handle the alert popup
  * @param driver
  */
    public void acceptAlert(WebDriver driver)
    {
    	driver.switchTo().alert().accept();
    }
    /*
     * This method will dismiss(cancel) the alert popup
     * @param driver
     */
    public void cancelAlert(WebDriver driver)
    {
    	driver.switchTo().alert().dismiss();
    }
    /*
     * This method will fetch the alert text and return value to the caller
     * @param driver
     * @return
     */
    public String getAlertText(WebDriver driver)
    {
      return driver.switchTo().alert().getText();
    }
    /**
     * This method will take screenshot and return the dst file
     * @param driver
     * @param screenshotName
     * @return
     * @throws IOException
     */
  public String captureScreenshot(WebDriver driver,String screenshotName) throws IOException
  {
	  TakesScreenshot ts=(TakesScreenshot)driver;
	  File src=ts.getScreenshotAs(OutputType.FILE);
	  File dst=new File(".\\Screenshot1\\"+screenshotName+".png");
	  Files.copy(src, dst);
	  return dst.getAbsolutePath();//used for extent reports
  }

public void swtichToWindow(WebDriver driver, String partialTitle) {
	Set<String> mainid=driver.getWindowHandles();
	
	for(String all:mainid)
	{
		String actTitle=driver.switchTo().window(all).getTitle();
	
	if(actTitle.contains(partialTitle))
	{
		break;
	}
   
     }//loop ending bracket
	
	}  //switchwindow ending bracket
public void quitBrowser(WebDriver driver)
{
	   driver.quit();
}

  
  
}
