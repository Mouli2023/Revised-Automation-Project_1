package testClass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import pageObjectClass.LoginPage;
import pageObjectClass.RegisterPage;

public class TC_2_3_LoginPage {

	WebDriver driver;
	LoginPage lp;
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
		lp=new LoginPage(driver);
		rp=new RegisterPage(driver);
		Assert.assertEquals(lp.getHomePageLogo(), "https://automationexercise.com/");		
	}

	@Test(priority=2)
	void testSignup() throws InterruptedException {
		Thread.sleep(3000);
		rp.clickSignUp();
		Thread.sleep(5000);
		Assert.assertTrue(lp.getLoginAccTxt().toLowerCase().contains("login to your account"));
		Thread.sleep(5000);
		lp.setEmailLogin("newton@gmail.com");
		lp.setPasswordLogin("newton123");
		lp.clickBtnLogin();	
		Thread.sleep(2000);
		Assert.assertTrue(rp.getUserName().toLowerCase().contains("logged in as"));
		rp.clickDeleteAccBtn();
		Thread.sleep(5000);
		Assert.assertTrue(rp.getTxtAccDeleted().toLowerCase().contains("account deleted!"));
		Thread.sleep(3000);
	}

	@Test(priority=3)
	void testIncorrectCredential() throws InterruptedException {
		Thread.sleep(3000);
		rp.clickSignUp();
		Thread.sleep(5000);
		Assert.assertTrue(lp.getLoginAccTxt().toLowerCase().contains("login to your account"));
		Thread.sleep(5000);
		lp.setEmailLogin("newton@gmail.com");
		lp.setPasswordLogin("mouli966@");
		lp.clickBtnLogin();	
		Thread.sleep(5000);	
		Assert.assertTrue(lp.getIncorrectCredentialTxt().toLowerCase().contains("your email or password is incorrect!"));
		Thread.sleep(5000);
	}

	@AfterTest
	void teardown() {
		driver.quit();
	}

}
