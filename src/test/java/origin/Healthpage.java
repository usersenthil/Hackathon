package origin;



import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.excelutility;

public class Healthpage extends Basepage{

	public Healthpage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath="//div[@class='para cushion-right-large display-inline nav-items nav-items--additional-link hover-dark u-d-trigger dropdown-toggle']")
	
	WebElement cop;
	
	@FindBy(xpath="(//a[@event='Nav Provider Marketing:Interacted:Plus Corporate'])[1]")
	
	WebElement healthins;
	
	@FindBy(xpath="//div[@class='subtitle u-text--bold text-white text-beta'][1]")
	WebElement sclaction;
	
	@FindBy(xpath="(//input[ @class='corporate-form__input ' and @id='name'])[1]")
	WebElement sendname;
	
	@FindBy(xpath="(//input[@class='corporate-form__input ' and @id='organizationName'])[1]")
	WebElement sendorg;
	
	@FindBy(xpath="(//input[@class='corporate-form__input ' and @id='contactNumber'])[1]")
	WebElement sendcont;
	
	@FindBy(xpath="(//input[@class='corporate-form__input ' and @id='officialEmailId'])[1]")
	WebElement sendmail;
	@FindBy(xpath="(//select[@class='corporate-form__select text-grey-3'])[1]")
	WebElement organiz;
	@FindBy(xpath="(//option[@value='501-1000'])[1]")
	WebElement orgoption;
	@FindBy(xpath="(//select[@class='corporate-form__select text-grey-3' and @id='interestedIn'])[1]")
	WebElement intclk;
	
	@FindBy(xpath="(//option[@value='Taking a demo'])[1]")
	WebElement intoption;
	
	@FindBy(xpath="(//button[@class='u-text--bold u-border-radius--8 text-white text-center u-m-t--5 u-p-v--12 width-per--100 u-cur--ptr bg-grey-3'])[1]")
	WebElement verifybutton;
	
	@FindBy(xpath="(//button[@class='u-text--bold u-border-radius--8 text-white text-center u-m-t--5 u-p-v--12 width-per--100 u-cur--ptr bg-blue'])[1]")
	WebElement verifybuttonenabled;
	
	@FindBy(xpath="(//input[@type='text'])[3]")
	WebElement sendcrtmail;
	
	@FindBy(xpath="(//div[@class='u-text--bold text-alpha'])[1]")
	WebElement validmsg;
	
	
	//@FindBy(xpath="(//input[@class='corporate-form__input ' and @id='officialEmailId'])[1]")
	//WebElement crtmail;
	String []strdata=excelutility.read();
	
	public void coporate() {
		cop.click();
	}
	public void copopt() {
		healthins.click();
	}
	public void scrollaction() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", sclaction);
		
	}
	public void sendinfo() {
		sendname.sendKeys(strdata[2]);
		sendorg.sendKeys(strdata[3]);
		sendcont.sendKeys(strdata[4]);
		sendmail.sendKeys(strdata[5]);
	
		}
	public void infobox() {
		organiz.click();
		orgoption.click();
		intclk.click();
		intoption.click();
		
		
	}
	public void btdisable() {
		boolean bol=verifybutton.isEnabled();
		if(bol==false) {
			System.out.println("button is disabled");
		}
		else {
			System.out.println("button is enabled");
		}
	}
	public void emailvalid() throws InterruptedException {
		sendcrtmail.clear();
		Thread.sleep(2000);
		sendcrtmail.sendKeys(strdata[6]);
		Thread.sleep(2000);
		boolean chk=verifybuttonenabled.isEnabled();
		if(chk==true) {
			System.out.println("button is enabled");
		}
		else {
			System.out.println("is disabled");
		}
		
		
	}
	@SuppressWarnings("unlikely-arg-type")
	public void validation() throws InterruptedException {
		verifybuttonenabled.click();
		
	}
		public void validatety() throws InterruptedException {
			//Thread.sleep(9000);
			
		
				String msg=validmsg.getText();
				if(msg.equals("THANK YOU")) {
				
				System.out.println(msg +"is displayed");
				
				
				}
		}
		public void screenshot() throws IOException, HeadlessException, AWTException {
				BufferedImage img1=new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
				ImageIO.write(img1, "png", new File("C:\\Users\\2304016\\eclipse-workspace\\FindingHospitals\\src\\test\\java\\screenshotss1\\errormsg.png"));
			
			
			
		}
		
		
		
			
		
		
		
}

	


