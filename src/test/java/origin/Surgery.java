package origin;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.excelutility;

public class Surgery extends Basepage {
	public static String file=System.getProperty("user.dir")+"/testdata/findhospital.xlsx";
	public Surgery(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	@FindBy(xpath="//a[@event='Nav:Interacted:Surgery']")
	WebElement surgery;
	@FindBy(xpath="//h1[@data-qa-id='surgical-solution-header']")
	WebElement frstimage;
	
	@FindBy(xpath="//div[@class='flex flex-wrap gap-y-44px pb-40px SurgicalSolutions-module_surgeriesList__1gl-I']/div")
	List<WebElement> surg;
	
	public void sgy() {
		surgery.click();
		
	}
	
	
	public void js1() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", frstimage);
	}
		
		
	public void js2() throws IOException {
		System.out.println("Popular-Surgeries-List");
		int row=0;
		for(WebElement s:surg) {
			String img=s.getText();
			excelutility.setCellData(file, "Sheet3", row, 0, img);
			//System.out.println("Popular-Surgeries-List");
			System.out.println(img);
			row++;
			
		}
	}
	

}
