package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
        //declaration      for click on + icon
	@FindBy(xpath="//img[@alt='Create Contact...']")
	private WebElement contactsBtn;
	 
	
	//initilization
	public ContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//utilization
	public WebElement getContactsBtn()
	{
		return contactsBtn;
	}
	
	//business library
	public void clickOnContactsBtn()
	{
		contactsBtn.click();
	}
}
