package organizationsTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import generalUtilities.BaseClass;
import objectRepository.CreateNewOrganizationsPage;
import objectRepository.HomePage;
import objectRepository.OrganizationInfoPage;
import objectRepository.OrganizationsPage;
@Listeners(generalUtilities.ListenerImplementation.class)
public class CreateOrganizationTest extends BaseClass {
 @Test
	public void createOrg() throws EncryptedDocumentException, IOException {
		String ORGNAME1=eu.readDataFromExcel("Organization", 1, 2)+ju.getRandomNumber();
		
		//step 6: click on organization
	     HomePage hpc=new HomePage(driver);
	     hpc.clickOnOrganizationLnk();
	     
	     //step 7: click on Create organization look up image
	     OrganizationsPage op=new OrganizationsPage(driver);
		op.clickonOrganizationLookUPImg();
		
		//step  8: Create new Organization with mandatory fields
		CreateNewOrganizationsPage  cnop=new CreateNewOrganizationsPage(driver);
		cnop.createNewOrganization(ORGNAME1);
		
		//step 9: validate for organization
		
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		String orgHeader=oip.getHeaderText();
		Assert.assertTrue(orgHeader.contains(ORGNAME1)); 
			System.out.println(orgHeader);
			System.out.println("organization created");
	}
	
}
