package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generalUtilities.WebDriverUtility;

public class HomePage extends WebDriverUtility{

	
	//declaration
	@FindBy(linkText="Contacts")    //for going on createContactPage where +icon is there
	private WebElement contactsLnk;
	
	@FindBy(linkText="Organizations")   //for going on createOrganizationsPage where +icon is there
	private WebElement organizationsLnk;
	
	@FindBy(linkText="products")
	private WebElement productLnk;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorImg;
	
	@FindBy(linkText="Sign Out")
	private WebElement signoutLnk;
	
	
	//initialization
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	//utilization 
	public WebElement getContactsLnk() {
		return contactsLnk;
	}


	public WebElement getOrganizationsLnk() {
		return organizationsLnk;
	}


	public WebElement getProductLnk() {
		return productLnk;
	}


	public WebElement getAdminstratorImg() {
		return administratorImg;
	}


	public WebElement getSignoutLnk() {
		return signoutLnk;
	}
	
	//Business Library
	/*
	 * this method will click on organization link
	 */
	public void clickOnOrganizationLnk()
	{
		organizationsLnk.click();
	}
	/*
	 * public void click on contacts link
	 */
	public void clickOnContactsLink()
	{
		contactsLnk.click();
	}	
	
	public void logoutOfApp(WebDriver driver) throws InterruptedException
	{
		mouseHoverAction(administratorImg,driver);
		Thread.sleep(1000);
		signoutLnk.click();
	}
	
	
	
}
