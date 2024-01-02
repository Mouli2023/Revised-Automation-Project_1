package testClass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import pageObjectClass.RegisterPage;

public class TC_1_5_RegisterPage {

	WebDriver driver;
	RegisterPage rp;

	@BeforeTest
	void setup() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\91933\\OneDrive\\Desktop\\WebDriver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://automationexercise.com");
	}

	@Test(priority=1)
	void testLogo() {
		rp=new RegisterPage(driver);
		Assert.assertEquals(rp.getHomePageLogo(), "https://automationexercise.com/");		
	}

	@Test(priority=2)
	void testSignup() throws InterruptedException {
		Thread.sleep(2000);
		rp.clickSignUp();
		Thread.sleep(3000);
		Assert.assertTrue(rp.getNewUserSignUpTxt().toLowerCase().contains("new user signup!"));
		Thread.sleep(3000);
		rp.setSignUpName("Mouli");
		rp.setSignUpEmail("mouli56@gmail.com");
		Thread.sleep(2000);
		rp.clickSignUp();	
		Thread.sleep(2000);
	}

	@Test(priority=3)
	void testAccountInfo() throws InterruptedException {
		Assert.assertTrue(rp.getAccInfo().toLowerCase().contains("enter account information"));
		Thread.sleep(3000);
		rp.clickTitle();
		rp.setUserName("Mouli");
		rp.setEmail("mouli56@gmail.com");
		rp.setPassword("Mouli123$");
		rp.setDay("3");
		rp.setMonth("August");
		rp.setYear("1996");
		rp.clickCheckBox1();
		rp.clickCheckBox2();
		rp.setFirstName("Mouli");
		rp.setLastName("Banerjee");
		rp.setCompany("Google");
		rp.setAddress("Kanakpura Road");
		rp.setCountry("India");
		rp.setState("Karnataka");
		rp.setCity("Bengaluru");
		rp.setZipCode("560010");
		rp.setMobileNo("9330567891");
		rp.clickCreateAccountBtn();
		Thread.sleep(2000);
	}

	@Test(priority=4)
	void testCreatedAcc() {
		Assert.assertTrue(rp.getTxtAccCreated().toLowerCase().contains("account created!"));
		rp.clickContinueBtn();
		Assert.assertTrue(rp.getUserName().toLowerCase().contains("logged in as"));
		rp.clickDeleteAccBtn();
		Assert.assertTrue(rp.getTxtAccDeleted().toLowerCase().contains("account deleted!"));
		rp.clickContinue_1();		
	}

	@Test(priority=5)
	void testExistingEmail() throws InterruptedException {
		Thread.sleep(3000);
		rp.clickSignUp();
		Assert.assertTrue(rp.getNewUserSignUpTxt().toLowerCase().contains("new user signup!"));
		rp.setSignUpName("Mouli");
		rp.setSignUpEmail("mouli56@gmail.com");
		rp.clickSignUp();
		Assert.assertTrue(rp.checkExistingEmail().toLowerCase().contains("email address already exist!"));
	}

	@AfterTest
	void teardown() {

	}
}
