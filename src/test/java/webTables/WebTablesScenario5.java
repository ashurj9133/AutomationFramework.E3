package webTables;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTablesScenario5 {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888");
		driver.findElement(By.name("user_name")).sendKeys("admin");
         driver.findElement(By.name("user_password")).sendKeys("password");
         driver.findElement(By.id("submitButton")).click();
         driver.findElement(By.xpath("//a[text()='Organizations']")).click();
         
       //click on 5th checkbox on organization
         driver.findElement(By.xpath("(//input[@type='checkbox'])[9]")).click();
         String th= driver.findElement(By.xpath("(//a[@title='Organizations'])[8]")).getText();
         System.out.println(th);
         driver.findElement(By.xpath("(//a[text()='del'])[8]")).click();
         Alert altAlert=driver.switchTo().alert();
         altAlert.accept();
}
}