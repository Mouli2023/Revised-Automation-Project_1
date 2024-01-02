package testClass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import pageObjectClass.RegisterPage;
import pageObjectClass.Subscription_Home_Cart;

public class TC_10_11_25_Subscription {
	WebDriver driver;
	RegisterPage rp;
	Subscription_Home_Cart shc;

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
		shc=new Subscription_Home_Cart(driver);
		Assert.assertEquals(rp.getHomePageLogo(), "https://automationexercise.com/");		
	}

	//Test Case_10
	@Test(priority=2)
	void testHomePage_Subcription() throws InterruptedException {
		Thread.sleep(3000);
		Assert.assertEquals(shc.getTxt_Subscription(), "SUBSCRIPTION");
		Thread.sleep(2000);
		shc.setEmail_Subscription("mouli123@gmail.com");
		shc.clickArrowBtn();
		Thread.sleep(3000);
		shc.getTxt_SubscribedMessageHomePage();;
	}

	//Test Case_11
	@Test(priority=3)
	void testCartPage_Subscription() throws InterruptedException {
		shc.clickCartBtnHomePage();
		Thread.sleep(3000);
		Assert.assertEquals(shc.getTxt_Subscription(), "SUBSCRIPTION");
		Thread.sleep(3000);
		shc.setEmail_Subscription("mouli123@gmail.com");
		shc.clickArrowBtn();
		Thread.sleep(3000);
		shc.getTxt_SubscribedMessageCartPage();	
		Thread.sleep(2000);
	}

	//Test Case_25
	@Test (priority=4)
	void testScrollUpUsingArrow() throws InterruptedException {
		Assert.assertEquals(shc.getTxt_Subscription(), "SUBSCRIPTION");
		Thread.sleep(5000);
		shc.clickArrowScrolledUp();
		Assert.assertEquals(shc.getTxtWebsiteInfo(), "Full-Fledged practice website for Automation Engineers");
	}

	@AfterTest
	void tearDown() {
		driver.quit();
	}

}
