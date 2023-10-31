package com.CRM.tiger.practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReadDataFromPropertiesFile {

	public static void main(String[] args) throws IOException {
	FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
   Properties p=new Properties();
   p.load(fis);
   String value=p.getProperty("browser");
   System.out.println(value);
   String v=p.getProperty("url");
   String username=p.getProperty("username");
   System.out.println(username);
   String password=(p.getProperty("password"));
   WebDriverManager.chromedriver().setup();
   WebDriver driver=new ChromeDriver();
   driver.manage().window().maximize();
   driver.get(v);
   driver.findElement(By.name("user_name")).sendKeys(username);
	driver.findElement(By.name("user_password")).sendKeys(password);
	driver.findElement(By.id("submitButton")).click();
   
	}

}
