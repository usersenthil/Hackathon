package testCases;



import java.io.IOException;

import org.testng.annotations.Test;


import origin.Surgery;
import testBase.baseClass;

public class TC002  extends baseClass{
//static String file=System.getProperty("user.dir")+"/testdata/findhospital.xlsx";

	 
	@Test(priority=2)
	public void third() throws InterruptedException, IOException {
		  su=new Surgery(driver);
		  Thread.sleep(3000);
		  su.sgy();
		  log.info("surgery is clicked");
		  Thread.sleep(1000);
		  su.js1();
		  log.info("page is scrolled");
		  Thread.sleep(3000);
		  su.js2();
		  log.info("types of surguries is displayed");
	  

}
}