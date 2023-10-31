package generalUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	/*
	 * This method will generate a random number for every run and return it to the 
	 * 
	 */
  public int getRandomNumber()
  {
       Random ran=new Random();
       int r=ran.nextInt(10000);
       return r;
  }
  /*
   * This method will capture the current system date in required format
   * 
   */
  public String getSystemData()
  {
	  Date d=new Date();
	  SimpleDateFormat formatter=new SimpleDateFormat("dd-MM-yy-hh-mm-ss");
	  String date=formatter.format(d);
	  return date;
  }
}
