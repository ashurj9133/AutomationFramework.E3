package ContactsTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import generalUtilities.BaseClass;
import objectRepository.ContactsInfoPage;
import objectRepository.ContactsPage;
import objectRepository.CreateNewContactsPage;
import objectRepository.HomePage;
@Listeners(generalUtilities.ListenerImplementation.class)
public class CreateContactTest extends BaseClass {
       @Test(groups="SmokeSuite")
	public void createContact() throws EncryptedDocumentException, IOException {
    	   String LASTNAME=eu.readDataFromExcel("Contacts", 8, 3);
    	   HomePage hpc=new HomePage(driver);
    	 //step 10: click on contacts link
  	     hpc.clickOnContactsLink();
  	     
  	     Reporter.log("clicked on contact link");
  		
  		//step 11 click on create lookup image
  		ContactsPage cpc=new ContactsPage(driver);
  		cpc.clickOnContactsBtn();
  		
  		Reporter.log("create on lookup image");
  		
  		//step 12: Create contacts with organization
  		CreateNewContactsPage cnpc=new CreateNewContactsPage(driver);
  		cnpc.createNewContact(LASTNAME);
  		
  		Reporter.log("create contacts successfully");
  		//Step 13: validatation
  		ContactsInfoPage cip=new ContactsInfoPage(driver);
  		String contactHeader=cip.getHeaderText();
  		
  		Reporter.log("Header captured");
  		//Assert.fail();//janbhuj ke fail kiya gya hai
  		Assert.assertTrue(contactHeader.contains(LASTNAME));
  		Reporter.log("Header validated");
  			System.out.println(contactHeader);
	}

}
