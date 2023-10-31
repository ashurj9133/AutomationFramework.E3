package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generalUtilities.WebDriverUtility;

public class CreateNewOrganizationsPage extends WebDriverUtility {
	//declaration
	
	
	@FindBy(name="accountname")
	private WebElement orgNameEdt;
	
	@FindBy(xpath = "//select[@name='industry']")
	private WebElement IndustryDropdwn;
	
	@FindBy(xpath = "//select[@name='accounttype']")
	private WebElement typeDropdwn;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	
	//initilization
	public CreateNewOrganizationsPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	
	//utilization
	
	
	public WebElement getOrgNameEdt()
	{
		return orgNameEdt;
	}
	public WebElement getIndustryDropdwn()
	{
		return IndustryDropdwn;
	}
	public WebElement typeDropdwn()
	{
		return typeDropdwn;
	}
	public WebElement getSaveBtn()
	{
		return saveBtn;
	}
	
	//business library
	/*
	 * this method will create new organization with mandatory fields
	 * @param ORGNAME
	 */
	public void createNewOrganization(String ORGNAME)
	{
		orgNameEdt.sendKeys(ORGNAME);
		saveBtn.click();
		
	}
	/*
	 * this method will create new organization with industry dropdown
	 * @param ORGNAME
	 * @param INDUSTRY 
	 */
	public void createNewOrganization(String ORGNAME,String INDUSTRY)
	{
		orgNameEdt.sendKeys(ORGNAME);
		handleDropDown(IndustryDropdwn,INDUSTRY);
		saveBtn.click();
	}
	/*
	 * this method will create new organization with industry dropdown
	 * @param ORGNAME
	 * @param INDUSTRY 
	 */
	public void createNewOrganization(String ORGNAME,String INDUSTRY,String Type)
	{
		orgNameEdt.sendKeys(ORGNAME);
		handleDropDown(IndustryDropdwn,INDUSTRY);
		handleDropDown(typeDropdwn,Type);
		saveBtn.click();
	}

	
	
}
