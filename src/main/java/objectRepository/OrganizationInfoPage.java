package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {

	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement orgHeaderText;
	
	
	//initilization
		public OrganizationInfoPage(WebDriver driver)
		{
			PageFactory.initElements(driver,this);
		}
	
	public WebElement getOrgHeaderText()
	{
		return orgHeaderText;
	}
	
	//Business library
	/*
	 * this method will capture the header text and return it to caller
	 */
	public String getHeaderText()
	{
		return orgHeaderText.getText();
	}
}
