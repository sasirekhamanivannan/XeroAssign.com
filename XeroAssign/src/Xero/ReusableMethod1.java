package Xero;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.firefox.FirefoxDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReusableMethod1 {
	static ExtentTest logger;
	static ExtentReports report;
	static WebDriver driver;


	public void InitializeDriver() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
	}


	public void OpenUrl(String url) {
		driver.get(url);
		// driver.manage().window().maximize();
	}
	


	public  void CloseBrowser() {
		driver.quit();
	}


	public void CloseReport() {
		report.flush();
	}

	/*
	 * name of the Method: CreateReport
	 * BriedDescriotion  : This will create a empty Extent Report.
	 * Arguments		 : No Arguments
	 * Created By 		 : Automation Team
	 * created Date		 : 14/02/2020
	 * Last Modified	 : 14/02/2020
	 */

public void CreateReport() {
		String fileName = new SimpleDateFormat("'SFDCReport_'YYYYMMddHHmm'.html'").format(new Date());
		String path = "C:\\Users\\amani\\Desktop\\JAva Assignments\\SFDC-TestCaseLogger\\" + fileName;
		report = new ExtentReports(path);
	}

	/* name of the method:   EnterText
	 * BriefDescription  :   entering textvalue for textbox
	 * Arguments         :  element --->object
	 *                      text    --->to be entered 
	 *                      objName --->object name
	 *  createdby        :  Automation team 
	 *  created date     :  14/02/20209 
	 *  LastModified Date:  14/02/2020          
	 */
/*	
	public void SelectDropdown(WebElement obj, String objName) {

		if (obj.isDisplayed()) {
			System.out.println("Pass: " + objName + " is  selected");
			obj.click();
		} else {

			System.out.println("Fail:" + objName + " is not present.Please chk application");
//				
		}
	}
*/
	/*
	 * name of the method: switchFrameid BriefDescription : iframe using webelement
	 * Arguments : driver--->driver obj--->iframe id createdby : Automation team
	 * created date :02/13/19 LastModified Date:02/13/19
	 */

/*


	public void SwitchFrame(String id) {
		driver.switchTo().frame(id);
		System.out.println("Pass: we can switch to the " + id + " frame");
	}
	

	public void SwitchFrame(WebElement element) {
		driver.switchTo().frame(element);
		System.out.println("Pass: we can switch to the frame");
	}


	public void SwitchFrame() {
		driver.switchTo().defaultContent();
		System.out.println("Pass: we can switch to the frame");
	}
*/
	/* name of the method:   mouseOver
	 * BriefDescription  :   mouseOver  
	 * Arguments         :  obj,index 
	 *  createdby        :  Automation team 
	 *  created date     :02/13/19 
	 *  LastModified Date:02/13/19          
	 */ 

/*
	public void MouseOver(WebDriver driver,WebElement obj) {
		if(obj.isDisplayed()) {
	   Actions action=new Actions(driver);
	   action.moveToElement(obj).build().perform();
		System.out.println("Pass: "+obj+" is present");
		logger.log(LogStatus.PASS,  "obj is present" );
		}
	 else {
			System.out.println("Fail:"+obj+" is not present.Please chk application");
			logger.log(LogStatus.FAIL,  "obj is not present.Please chk application" );
		}
	}

*/
	
	
	public void EnterText(WebElement element, String text, String objName) {
		if (element == null || !element.isDisplayed()) {
			logger.log(LogStatus.ERROR, objName + " Textbox is not found.");
		} else {
			logger.log(LogStatus.INFO, objName + " Textbox is found");
			element.sendKeys(text);
		}
	}

	
	public void Click(WebElement element, String objName) {
		if (element == null || !element.isDisplayed()) {
			logger.log(LogStatus.ERROR, objName + " Element is not found.");
		} else {
			logger.log(LogStatus.INFO, objName + " Element is found");
			element.click();
		}
	}
}





