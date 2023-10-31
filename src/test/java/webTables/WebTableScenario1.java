package webTables;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableScenario1 {
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
         //driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[1]")).click();
         
         //click on all the checkbox of organization
         driver.findElement(By.id("selectCurrentPageRec")).click();
}
}