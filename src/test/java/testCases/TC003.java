package testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import origin.Healthpage;
import origin.Surgery;
import testBase.baseClass;

public class TC003 extends baseClass{
	@Test(priority=3)
	public void raj() throws InterruptedException {
		ht = new Healthpage(driver);
	  ht.coporate();
	  log.info("click coperate options");
	  Thread.sleep(2000);
	  
	  ht.copopt();
	  log.info("clicking of health insurance");
	  
	  ht.scrollaction();
	  log.info("scroll down the page");
	  
	  ht.sendinfo();
	  log.info("info is given");
	  
	  ht.infobox();
	  log.info("clicking dropdown button and value is choosen");
	  
	  Thread.sleep(2000);
	  //log.info("clicking of health insurance");
	  
	  ht.btdisable();
	  log.info("validating the button is disabled");
	  Thread.sleep(3000);
	  
	  ht.emailvalid();
	  log.info("validation of email");
	  
	  ht.validation();
	  log.info("verification of button is enabled or not");
	  Thread.sleep(3000);
	  
	  ht.validatety();
	  log.info("validating the displayed message,and its is displayed");
		  
	  }

}
