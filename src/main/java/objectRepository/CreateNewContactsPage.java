package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generalUtilities.WebDriverUtility;

public class CreateNewContactsPage extends WebDriverUtility{
     //declaration
	@FindBy(name="lastname")
	private WebElement lastName;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	 
	@FindBy(xpath="(//img[@alt='Select'])[1]")
	private WebElement orgLookImg;
	
	@FindBy(name="search_text")
	private WebElement orgSearchEdt;
	
	@FindBy(name="search")
	private WebElement orgSearchBtn;
	
	//initilization
	public CreateNewContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	
	//utilization
	public WebElement getLastName()
	{
		return lastName;
	}
	public WebElement getSaveBtn()
	{
		return  saveBtn;
	}
	public WebElement getOrgSearchEdt()
	{
		return orgSearchEdt;
	}
	public WebElement getOrgSearchBtn()
	{
		return orgSearchBtn;
	}
	
	//Business Library
	public void createNewContact(String LASTNAME)
	{
		lastName.sendKeys(LASTNAME);
		saveBtn.click();
	}
	public void createNewContact(WebDriver driver,String LASTNAME,String ORGNAME)
	{
		lastName.sendKeys(LASTNAME);
		orgLookImg.click();
		swtichToWindow(driver,"Accounts");
		orgSearchEdt.sendKeys(ORGNAME);
		orgSearchBtn.click();
		driver.findElement(By.xpath("//a[.='"+ORGNAME+"']")).click();
	swtichToWindow(driver,"contacts");
	saveBtn.click();
	}
	
	
	
	
	
	
	
	
	
	
}
