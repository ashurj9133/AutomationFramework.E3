package com.CRM.tiger.practice;



	import java.time.Duration;
	import java.util.Set;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.chrome.ChromeOptions;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

	public class Practice {

		public static void main(String[] args) throws InterruptedException {
			
			ChromeOptions opt=new ChromeOptions();
			//opt.addArguments("--disable-notifications");
			//opt.addArguments("--disable-media-stream");
			opt.addArguments("use-fake-device-for-media-stream");
			opt.addArguments("use-fake-ui-for-media-stream");
			//opt.addArguments("--disable-media-stream");
			//WebDriver driver=new ChromeDriver();
			//System.setProperty("webdriver.chrome.driver","C:\\Users\\ashutosh\\Desktop\\Selenium\\Drivers\\chromedriver.exe");
			//WebDriver driver=new ChromeDriver(opt);
			WebDriverManager.chromedriver().setup();
			WebDriver driver=new ChromeDriver(opt);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			driver.get("https://mictests.com/");
			driver.findElement(By.linkText("Test Webcam")).click();
			
			
			Thread.sleep(3000);
		//String d=	driver.findElement(By.xpath("//li[contains(text(),'A web camera was detected. Press “Test my cam” to check the functionality and supported properties of your camera.')]")).getText();
		//System.out.println(d);
			String s=driver.getWindowHandle();
			Set<String> s21=driver.getWindowHandles();
			for(String s5:s21)
			{
				if(!(s.equals(s5)))
				{
					driver.switchTo().window(s5);
					break;
				}
			}
			//opt.addArguments("--disable-media-stream");
			//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	       // wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Test my cam']")));
			driver.findElement(By.xpath("//button[text()='Test my cam']")).click();
			
		}
}
