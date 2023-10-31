package com.CRM.tiger.practice;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class tigerScenario3 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("http://localhost:8888");
		driver.findElement(By.name("user_name")).sendKeys("admin");
	     driver.findElement(By.name("user_password")).sendKeys("password");
	     driver.findElement(By.id("submitButton")).click();
	     driver.findElement(By.xpath("//a[text()='Organizations']")).click();
	     driver.findElement(By.cssSelector("[title='Create Organization...']")).click();
	     driver.findElement(By.name("accountname")).sendKeys("Qspider9W");
	     driver.findElement(By.name("website")).sendKeys("www.qspider12345.com");
	     driver.findElement(By.id("employees")).sendKeys("10");

	     driver.findElement(By.id("phone")).sendKeys("0123456789");
	     driver.findElement(By.id("bill_city")).sendKeys("Bengaluru");
WebElement indus=driver.findElement(By.name("industry"));
        Select s=new Select(indus);
        s.selectByValue("Chemicals");
        driver.findElement(By.cssSelector("[title='Save [Alt+S]']")).click();
        String header=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
        if(header.equals("Qspider9W"))
        {
     	   System.out.println("pass");
        }
        else
        {
     	   System.out.println("fail");
        }
        Thread.sleep(1000);
        try {
        	
        	Alert alt=driver.switchTo().alert();	
        	alt.accept();
        }
        catch(Exception e)
        {}

  

        WebElement out=driver.findElement(By.xpath("(//span[text()=' Administrator']/parent::td/following-sibling::td/img)[1]"));
        //WebElement s=driver.findElement(By.xpath("(//img)[4]"));
        Actions act=new Actions(driver);
        act.moveToElement(out).perform();
       // driver.findElement(By.linkText("Sign Out")).click(); 
	     

	}

}
