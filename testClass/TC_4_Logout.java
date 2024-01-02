package testClass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import pageObjectClass.LoginPage;
import pageObjectClass.LogoutPage;
import pageObjectClass.RegisterPage;


public class TC_4_Logout {
	WebDriver driver;
	LoginPage lp;
	RegisterPage rp;
	LogoutPage lop;

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
		lop=new LogoutPage(driver);
		Assert.assertEquals(lp.getHomePageLogo(), "https://automationexercise.com/");		
	}

	@Test(priority=2)
	void testSignup() throws InterruptedException {
		rp.clickSignUp();
		Thread.sleep(3000);
		Assert.assertEquals(lp.getLoginAccTxt(),"Login to your account");
		Thread.sleep(3000);
		lp.setEmailLogin("lily123@gmail.com");
		lp.setPasswordLogin("lily00");
		lp.clickBtnLogin();	
		Thread.sleep(5000);
		rp.getUserName();
		Thread.sleep(5000);
	}

	@Test(priority=3)
	void testLogout() throws InterruptedException {
		lop.clickLogoutBtn();
		Thread.sleep(5000);
		Assert.assertEquals(lop.checkLoginPageUrl(), "https://automationexercise.com/login");
		Thread.sleep(3000);
	}

	@AfterTest
	void teardown() {
		driver.quit();
	}
}
