package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsInfoPage {
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement contactsHeaderText;
	
	
	//initilization
		public ContactsInfoPage(WebDriver driver)
		{
			PageFactory.initElements(driver,this);
		}
	
	public WebElement getContactsHeaderText()
	{
		return contactsHeaderText;
	}
	
	//Business library
	/*
	 * this method will capture the header text and return it to caller
	 */
	public String getHeaderText()
	{
		return contactsHeaderText.getText();
	}
}
