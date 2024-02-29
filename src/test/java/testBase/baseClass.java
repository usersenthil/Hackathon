package testBase;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.Logger;

import origin.Basepage;
import origin.Healthpage;
import origin.Hospitals;
import origin.Surgery;

public class baseClass 
{
	public static WebDriver driver;
	
	public  Hospitals  hp;
	public  Healthpage ht;
	public  Surgery su;
	public static Properties p;
	public  static Logger log;
	
	
	@BeforeTest
	@Parameters({"browser","os"})
	  public void browser(String br,String os) throws IOException 
	{
		  
		  driver = new ChromeDriver();
		  FileReader file=new FileReader(".\\src\\test\\resources\\config.properties");
		  
		  p=new Properties();
		  p.load(file);
		  log=LogManager.getLogger(this.getClass());
		  
		  if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
			{
				
				
				
				DesiredCapabilities capabilities=new DesiredCapabilities();
				
				//os
				if(os.equalsIgnoreCase("windows"))
				{
					capabilities.setPlatform(Platform.WIN11);
				}
				else if(os.equalsIgnoreCase("mac"))
				{
					capabilities.setPlatform(Platform.MAC);
				}
				else
				{
					System.out.println("No matching os..");
					return;
				}
				
				//browser
				switch(br.toLowerCase())
				{
				case "chrome" : capabilities.setBrowserName("chrome"); break;
				case "edge" : capabilities.setBrowserName("MicrosoftEdge"); break;
				default: System.out.println("No matching browser.."); return;
				}
				
				driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
				
			    }
			else if(p.getProperty("execution_env").equalsIgnoreCase("local"))
			{
					//launching browser based on condition - locally
				if(br.equalsIgnoreCase("chrome")) {
					driver=new ChromeDriver();
						
					}
					else if(br.equalsIgnoreCase("edge")) {
						driver=new EdgeDriver();
						//driver.get(prop.getProperty("link"));
					}
					else {
						System.out.println("There are no browser");
					}
				}	
	 
			
			
			
		
			
			
		

		  //driver = new ChromeDriver();
		  
		  driver.get(p.getProperty("url"));
		  //driver.get("https://www.practo.com/");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	  

	@AfterTest
	public void cls() {
		driver.quit();
	}
	  

}
