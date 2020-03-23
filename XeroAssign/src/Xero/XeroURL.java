package Xero;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class XeroURL extends ReusableMethod1{
	
	@BeforeClass
	public void Initialize() {
		InitializeDriver();
		CreateReport();
	}
	
	@Test(priority = 1)
	public void LoginPage() throws InterruptedException {
		logger = report.startTest("Navigate to XERO");

		OpenUrl("https://login.xero.com/");
		
		String expectedTitle = "Login | Xero Accounting Software";
		String actualTitle = driver.getTitle();
		if (actualTitle.equalsIgnoreCase(expectedTitle))
			logger.log(LogStatus.PASS, "User is on home page");
		 
		else
			logger.log(LogStatus.FAIL, "home page is not launched");

		WebElement userName1 = driver.findElement(By.id("email"));
		EnterText(userName1, "sasi.mani1983@gmail.com", "Username");

		WebElement passWord1 = driver.findElement(By.id("password"));
		EnterText(passWord1, "sasimani123", "password");

		WebElement loginBtn1 = driver.findElement(By.id("submitButton"));
		Click(loginBtn1, "Login Button");

		Thread.sleep(2000);

		String expectedTitle1 = "Xero | Dashboard | tech";
		String actualTitle1 = driver.getTitle();
		if (actualTitle1.equalsIgnoreCase(expectedTitle1))
			logger.log(LogStatus.PASS, "User is on home page");
		 
		else
			logger.log(LogStatus.FAIL, "home page is not launched");

		WebElement userAccName= driver.findElement(By.xpath("/html/body/div[1]/header/div/ol[2]/li[5]/button/div/abbr"));
		Click(userAccName, "UserAccountName");
		WebElement logoutBtn1 = driver.findElement(By.xpath("/html/body/div[1]/header/div/ol[2]/li[5]/div/div[2]/div/ol/li[5]/a"));
		Click(logoutBtn1, "Logout Button");

		
		Thread.sleep(5000);
		}
	
	
	
	@Test(priority =2)
	public  void IncorrectPassWord_2() throws InterruptedException {
		logger = report.startTest("IncorrectPassWord_2");

		OpenUrl("https://login.xero.com/");
		
		
		WebElement userName2 = driver.findElement(By.id("email"));
		EnterText(userName2, "sasi.mani1983@gmail.com", "Username");

		WebElement passWord2 = driver.findElement(By.id("password"));
		EnterText(passWord2, "sasimani", "Password");

		WebElement loginBtn2 = driver.findElement(By.id("submitButton"));
		Click(loginBtn2, "Login Button");
		
				String errormessage1 = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div[2]/p")).getText();
		if (errormessage1.equalsIgnoreCase("Your email or password is incorrect")) {
			logger.log(LogStatus.PASS, "Error message is displayed");
			} else {
			System.out.println("Error message has not been  displayed");
			logger.log(LogStatus.FAIL, "Error message has not been displayed");
			}
	Thread.sleep(5000);


	}
	@Test(priority =3)
	public  void IncorrectUserName_3() throws InterruptedException {
	logger = report.startTest("IncorrectUserName_3");

	OpenUrl("https://login.xero.com/");
	
	WebElement userName3 = driver.findElement(By.id("email"));
	EnterText(userName3, "sasi.mani1982@gmail.com", "Username");

	WebElement passWord3 = driver.findElement(By.id("password"));
	EnterText(passWord3, "sasimani123", "Password");

	WebElement loginBtn3 = driver.findElement(By.id("submitButton"));
	Click(loginBtn3, "Login Button");
	
			String errormessage3 = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/p[1]")).getText();
	if (errormessage3.equalsIgnoreCase("Your email or password is incorrect")) {
		logger.log(LogStatus.PASS, "Error message is displayed");
		} else {
		System.out.println("Error message has not been  displayed");
		logger.log(LogStatus.FAIL, "Error message has not been displayed");
		}
		Thread.sleep(5000);


	}
	
	@Test(priority = 4)
	public void ForgotPassword() throws InterruptedException {
		logger = report.startTest("ForgotPassword");

		OpenUrl("https://login.xero.com/");
		
		String expectedTitle2 = "Login | Xero Accounting Software";
		String actualTitle2 = driver.getTitle();
		if (actualTitle2.equalsIgnoreCase(expectedTitle2))
			logger.log(LogStatus.PASS, "User is on home page");
		 
		else
			logger.log(LogStatus.FAIL, "home page is not launched");

		WebElement forgotPwd = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/a[1]"));
		Click(forgotPwd, "Login Button");
		
		String expectedTitle3 = "Forgotten Password";
		String actualTitle3 = driver.getTitle();
		if (actualTitle3.equalsIgnoreCase(expectedTitle3))
			logger.log(LogStatus.PASS, "User is on forgot password page");
		 
		else
			logger.log(LogStatus.FAIL, "Forgot password page is not launched");

		WebElement userName4 = driver.findElement(By.id("UserName"));
		EnterText(userName4, "sasi.mani1982@gmail.com", "Username");
		WebElement sendLink = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/form/div/div[1]/a/span"));
		Click(sendLink, "SendLink");
		
	
	}

/*	@Test(priority=1)
	public void SignUptoXDC() throws InterruptedException {
		logger = report.startTest("Sign_Up_to_XDC");

		OpenUrl("https://www.xero.com/us/");
		
		String expectedTitle4 = "Accounting Software - Do Beautiful Business | Xero US";
		String actualTitle4 = driver.getTitle();
		if (actualTitle4.equalsIgnoreCase(expectedTitle4))
			logger.log(LogStatus.PASS, "User is on Xero application page");
		 
		else
			logger.log(LogStatus.FAIL, "Xero application page is not launched");
	
		WebElement freeTrial= driver.findElement(By.xpath("/html/body/div[4]/header/nav/div[2]/div/div[1]/div/div/ul/li[1]/a"));
		Click(freeTrial, "Free Trial");
		
		String expectedTitle5 = "Signup for Xero - Free Trial | Xero US";
		String actualTitle5 = driver.getTitle();
		if (actualTitle5.equalsIgnoreCase(expectedTitle5))
			logger.log(LogStatus.PASS, "User is on Xero freetrial signup page");
		 
		else
			logger.log(LogStatus.FAIL, "Xero freetrial signup page is not launched");

		Thread.sleep(3000);
		
		WebElement firstName= driver.findElement(By.name("FirstName"));
		EnterText(firstName, "Manivannan", "FirstName");
		Thread.sleep(2000);
		String text1 = driver.findElement(By.name("FirstName")).getText();
		if (text1.equals("Manivannan")) {
			logger.log(LogStatus.PASS, "FirstName text is found");
			} else {
			logger.log(LogStatus.FAIL, "FirstName text is not found");

		}
		
		Thread.sleep(3000);

		WebElement lastName = driver.findElement(By.name("LastName"));
		EnterText(lastName , "Arumugam", "LastName");
		String text2 = driver.findElement(By.name("LastName")).getText();
		if (text2.equals("Arumugam")) {
			logger.log(LogStatus.PASS, "LastName text is found");
			} else {
			logger.log(LogStatus.FAIL, "LastName text is not found");

		}
		
		WebElement email = driver.findElement(By.name("EmailAddress"));
		EnterText(email, "a.mani2092@gmail.com", "Email");
		String text3 = driver.findElement(By.name("EmailAddress")).getText();
		if (text3.equals("a.mani2092@gmail.com")) {
			logger.log(LogStatus.PASS, "Email name is found");
			} else {
			logger.log(LogStatus.FAIL, "Email name is not found");

		}


		WebElement phnum = driver.findElement(By.name("PhoneNumber"));
		EnterText(phnum, "7204016624", "Phonenumber");
		
		String text4 = driver.findElement(By.name("PhoneNumber")).getText();
		if (text4.equals("7204016624")) {
			logger.log(LogStatus.PASS, "Phone number is found");
			} else {
			logger.log(LogStatus.FAIL, "Phone number is not found");

		}
		
		String text5 = driver.findElement(By.name("LocationCode")).getText();
		if (text5.equals("United States")) {
			logger.log(LogStatus.PASS, "Country is found");
			} else {
			logger.log(LogStatus.FAIL, "Country is not found");

		}

		Thread.sleep(30000);
		
		
		WebElement chkbox = driver.findElement(By.name("TermsAccepted"));
		Click(chkbox, "Checkbox");
		
		if(chkbox.isSelected())
							logger.log(LogStatus.PASS, "Check box is toggled on");
		else
				logger.log(LogStatus.FAIL, "Check box is not toggled off");
		
		
	
		WebElement getStartBtn= driver.findElement(By.className("g-recaptcha-submit"));
		Click(getStartBtn, "GetStarted");
		
		Thread.sleep(10000);
	}

*/
/*	@Test(priority=1)
	public void SignUptoXDC_2() throws InterruptedException {
		logger = report.startTest("Sign_Up_to_XDC_2");
		
	
		OpenUrl("https://www.xero.com/us/");
		
		String expectedTitle4 = "Accounting Software - Do Beautiful Business | Xero US";
		String actualTitle4 = driver.getTitle();
		if (actualTitle4.equalsIgnoreCase(expectedTitle4))
			logger.log(LogStatus.PASS, "User is on Xero application page");
		 
		else
			logger.log(LogStatus.FAIL, "Xero application page is not launched");
	
		WebElement freeTrial= driver.findElement(By.xpath("/html/body/div[4]/header/nav/div[2]/div/div[1]/div/div/ul/li[1]/a"));
		Click(freeTrial, "Free Trial");
		
		String expectedTitle5 = "Signup for Xero - Free Trial | Xero US";
		String actualTitle5 = driver.getTitle();
		if (actualTitle5.equalsIgnoreCase(expectedTitle5))
			logger.log(LogStatus.PASS, "User is on Xero freetrial signup page");
		 
		else
			logger.log(LogStatus.FAIL, "Xero freetrial signup page is not launched");
		
		WebElement email = driver.findElement(By.name("EmailAddress"));
		EnterText(email, "a.mani2091@gmail.com", "Email");
		
		Thread.sleep(4000);
		
		WebElement getStartBtn= driver.findElement(By.className("g-recaptcha-submit"));
		Click(getStartBtn, "GetStarted");
		
		Thread.sleep(10000);
	
	
	}


	*/
	
	
@AfterClass
	public void CloseBrowser1() {
		CloseBrowser();
	
		CloseReport();
	}

	
}


