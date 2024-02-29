package testCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import origin.Basepage;
import origin.Healthpage;
import origin.Hospitals;
import origin.Surgery;
import testBase.baseClass;
import utilities.excelutility;

public class TC001  extends baseClass{
	// static String file=System.getProperty("user.dir")+"/testdata/findhospital.xlsx";


	
  
  @Test(priority=1)
  public void sen() throws InterruptedException {
	  hp = new Hospitals(driver);
	  
	  try {
		  
	  hp.tell();
	  log.info("Chennai is clicked");
	  Thread.sleep(2000);
	  hp.boxes();
	  log.info("dentist is clicked");
	  Thread.sleep(2000);
	  //hp.sendkey();
	  //bp.sendkey();
	  //Thread.sleep(1000);
	  hp.boxes2();
	  log.info("gender is choosen");
	  //hp.exp(); 
	  //log.info("experience is choosen");
	  Thread.sleep(2000);
	  hp.sel3();
	  log.info("stories are choosen");
	  Thread.sleep(2000);
	  hp.exp();
	  log.info("click experience");
	  Thread.sleep(2000);
	  hp.expc();
	  log.info("clickingexperience");
	  Thread.sleep(2000);
	  hp.cos();
	  log.info("click filters");
	  
	  Thread.sleep(1000);
	  hp.available();
	  log.info("availability is choosen");
	  Thread.sleep(1000);
	  hp.type();
	  log.info("consult type is choosen");
	  Thread.sleep(2000);
	  hp.sortBy();
	  log.info("sorting option");
	
	  hp.printdoctorsinfo();
	  log.info("doctor info is displayed");
	  
	 
	  
	  
	  
	 
	  }
	  catch (Exception e) {
		  
	  }
	  
	//  bp.sel3();
	 
	  
	  
  }
}
