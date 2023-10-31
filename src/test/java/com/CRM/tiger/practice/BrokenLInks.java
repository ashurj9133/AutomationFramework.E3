package com.CRM.tiger.practice;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLInks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://amazon.in/");
		List<WebElement> alllinks=driver.findElements(By.xpath("//a"));
		ArrayList <String> all=new ArrayList<String>();
		for(int i=0;i<alllinks.size();i++)
		{
			String links=alllinks.get(i).getAttribute("href");
			int statuscode=0;
			try {
				URL url=new URL(links);
				URLConnection t=url.openConnection();
				HttpURLConnection ht=(HttpURLConnection)t;
				statuscode=ht.getResponseCode();
				if(statuscode>=400)
				{
				all.add(links+""+statuscode);	
				}
			}
				catch(Exception e) {
					continue;
			}
		}
		System.out.println(all);
	}

}
