package ContactsTests;


import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import generalUtilities.BaseClass;
import generalUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.ContactsInfoPage;
import objectRepository.ContactsPage;
import objectRepository.CreateNewContactsPage;
import objectRepository.CreateNewOrganizationsPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;
import objectRepository.OrganizationInfoPage;
import objectRepository.OrganizationsPage;
@Listeners(generalUtilities.ListenerImplementation.class)
public class CreateContactsWithOrganizationTest extends BaseClass {
        @Test(groups = "RegressionSuite")
		public void createContactWithOrgTest() throws EncryptedDocumentException, IOException, InterruptedException {
			
				
        	String ORGNAME=eu.readDataFromExcel("Contacts", 8, 3)+ju.getRandomNumber();
   			String LASTNAME=eu.readDataFromExcel("Contacts", 8, 2);
			
			//step 6: click on organization
		     HomePage hpc=new HomePage(driver);
		     hpc.clickOnOrganizationLnk();
		     
		     //step 7: click on Create organization look up image
		     OrganizationsPage op=new OrganizationsPage(driver);
			op.clickonOrganizationLookUPImg();
			
			//step  8: Create new Organization with mandatory fields
			CreateNewOrganizationsPage  cnop=new CreateNewOrganizationsPage(driver);
			cnop.createNewOrganization(ORGNAME);
			
			//step 9: validate for organization
			
			OrganizationInfoPage oip=new OrganizationInfoPage(driver);
			String orgHeader=oip.getHeaderText();
			Assert.assertTrue(orgHeader.contains(ORGNAME)); 
				System.out.println(orgHeader);
				System.out.println("organization created");
			
		
	    //step 10: click on contacts link
	     hpc.clickOnContactsLink();
		
		//step 11 click on create lookup image
		ContactsPage cpc=new ContactsPage(driver);
		cpc.clickOnContactsBtn();
		
		//step 12: Create contacts with organization
		CreateNewContactsPage cnpc=new CreateNewContactsPage(driver);
		cnpc.createNewContact(driver, LASTNAME, ORGNAME);
		
		//Step 13: validatation
		ContactsInfoPage cip=new ContactsInfoPage(driver);
		String contactHeader=cip.getHeaderText();
		Assert.assertTrue(contactHeader.contains(LASTNAME));
		
			System.out.println(contactHeader);
		
		
	}

}
