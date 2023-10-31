package objectRepository;  

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {
//declaration   clicking on + icon
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement plusIcon;
	
	//initilization
	public OrganizationsPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//utilization
	public WebElement getPlusIcon()
	{
		return plusIcon;
	}
	public void clickonOrganizationLookUPImg()
	{
		plusIcon.click();
	}
}
