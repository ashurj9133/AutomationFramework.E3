package com.CRM.tiger.practice;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLink2 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://amazon.in/");
		List<WebElement> alllinks=driver.findElements(By.xpath("//a"));
		Set <String> all=new HashSet<String>();
		for(int i=0;i<alllinks.size();i++)
		{
			String links=alllinks.get(i).getAttribute("href");
			//int statuscode=0;
			try {
				URL url=new URL(links);
				URLConnection t=url.openConnection();
				HttpURLConnection ht=(HttpURLConnection)t;
				
				if(ht.getResponseCode()!=200)
				{
				all.add(links)	;
				}
			}
				catch(Exception e) {
					continue;
				}
		}
		//System.out.println(all);	
  for(String al:all)
  {
	  System.err.println(al);
  }
	}

}
