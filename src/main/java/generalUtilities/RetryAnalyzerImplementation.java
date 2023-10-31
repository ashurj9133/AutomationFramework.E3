package generalUtilities;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/*
 * This class will provide implementation to the IRetryAnalyser interface of testng
 * @author ashutosh
 */
public class RetryAnalyzerImplementation implements IRetryAnalyzer{

	
		int count=0;
		int retrycount=3;
		public boolean retry(ITestResult result) {
		
			while(count<retrycount)
			{
				count++;
				return true;
			}
		
		return false;
	}

}
