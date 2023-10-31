package com.CRM.tiger.practice;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class tigerScenario1 {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888");
		driver.findElement(By.name("user_name")).sendKeys("admin");
         driver.findElement(By.name("user_password")).sendKeys("password");
         driver.findElement(By.id("submitButton")).click();
         driver.findElement(By.xpath("//a[text()='Contacts']")).click();
         driver.findElement(By.cssSelector("[title='Create Contact...']")).click();
    WebElement firstname=driver.findElement(By.name("salutationtype"));
    Select s=new Select(firstname);
    s.selectByValue("Mr.");
    driver.findElement(By.name("firstname")).sendKeys("ashutosh");
    driver.findElement(By.name("lastname")).sendKeys("ranjan");
    driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img[@title='Select']")).click();
    String mainid=driver.getWindowHandle();
    Set<String> popup=driver.getWindowHandles();
    for(String id:popup)
    {
    	if(!(mainid.equals(id)))
    	{
    		driver.switchTo().window(id);
    		driver.findElement(By.xpath("//a[text()='vtigeruser']")).click();
    	}
    }
    driver.switchTo().window(mainid);
    driver.findElement(By.cssSelector("[id='title']")).sendKeys("QA Engineer");
    driver.findElement(By.id("email")).sendKeys("ashutoshranjan543@gmail.com");
    driver.findElement(By.cssSelector("[id='phone']")).sendKeys("0123456789");
    driver.findElement(By.cssSelector("[title='Save [Alt+S]']")).click();
	}

}
