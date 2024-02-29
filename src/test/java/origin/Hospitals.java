package origin;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.excelutility;

public class Hospitals extends Basepage {
	public static String file=System.getProperty("user.dir")+"/testdata/findhospital.xlsx";




	public Hospitals(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath="//*[@id=\'c-omni-container\']/div/div[1]/div[1]/input")
	WebElement tel;
	@FindBy(xpath="//div[@data-qa-id='omni-suggestion-main'][1]")
	WebElement chn;
	
	
	
	@FindBy(xpath="//*[@id=\"c-omni-container\"]/div/div[2]/div[1]/input")
	WebElement box;
	
	@FindBy(xpath="//div[@class='c-omni-suggestion-item']")
	WebElement clickdentist;
	
	@FindBy(xpath="//div[@class='c-filter__box u-pos-rel c-dropdown']")
	WebElement gender;
	
	@FindBy(xpath="//li[@aria-label='Male Doctor' and @class='c-dropdown__list__item']")
	WebElement clickinggender;
	
	@FindBy(xpath="(//span[@data-qa-id='selected_dropdown_filter'])[2]")
	WebElement clickStory;
	
	
	@FindBy(xpath="(//li[@role='option'])[3]")
	WebElement clickingStories;
	
	@FindBy(xpath="(//span[@data-qa-id='selected_dropdown_filter'])[3]")
	WebElement clickexperience;
	
	@FindBy(xpath="(//li[@role='option'])[7]")
	WebElement clickingexperience;
	
	
	@FindBy(xpath="(//span[@data-qa-id='all_filters'])[1]")
	WebElement clickfilters;
	@FindBy(xpath="//input[@data-qa-id='omni-searchbox-locality']")
	WebElement selkey;
	@FindBy(xpath="(//span[@data-qa-id='Above ₹500_label'])[1]")
	WebElement cost;
	@FindBy(xpath="(//span[@data-qa-id='Available Today_label'])[1]")
	WebElement availability;
	@FindBy(xpath="(//span[@data-qa-id='Video consult_label'])[1]")
	WebElement consulttype;
	@FindBy(xpath="(//span[@data-qa-id='sort_by_selected'])[1]")
	WebElement sorting;
	@FindBy(xpath="//li[@aria-label='Experience - High to Low']")
	WebElement sortoption;
	
	
	
	
	String []strdata=excelutility.read();

	
	
	public void tell() throws InterruptedException {
		
		
		//sbox.click();
		Thread.sleep(2000);
		
		tel.clear();
		Thread.sleep(2000);
		
		tel.sendKeys(strdata[0]);
		Thread.sleep(2000);
		
		chn.click();
		
			
		}
	
		
		

	public void boxes() {
		box.sendKeys(strdata[1]);
		clickdentist.click();
	}
	//public void sendkey() {
		
	
	public void boxes2() {
		gender.click();
		clickinggender.click();
	}
		public void sel3() throws InterruptedException {

			clickStory.click();
			//Thread.sleep(2000);
			clickingStories.click();
			
		}
		public void exp() throws InterruptedException {
			clickexperience.click();
			//Thread.sleep(3000);
		}
		
		public void expc() throws InterruptedException {
			
			clickingexperience.click();
			//Thread.sleep(2000);
			clickfilters.click();
		}
		public void cos() {
			clickfilters.click();
			cost.click();
		}
		public void available() {
			clickfilters.click();
			availability.click();
			
		}
		public void type(){
			clickfilters.click();
			consulttype.click();
			
		}
		public void sortBy() {
			sorting.click();
			sortoption.click();
		}
		public void printdoctorsinfo() throws IOException
		{
			List<WebElement>list=driver.findElements(By.xpath("//div[@class='info-section']"));
			  
			  int count=1;
			  for( WebElement fivedoc:list) {
				  String details=fivedoc.getText();
				  excelutility.setCellData(file, "Sheet2", count, 0, details);
				  System.out.println(details);
				  System.out.println("##################################");
				  
				  if(count>=5) {
					  break;
				  }
				  count++;
			  }
		}
		
		
		

}
