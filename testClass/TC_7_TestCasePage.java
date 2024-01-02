package testClass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import pageObjectClass.RegisterPage;
import pageObjectClass.TestCasePage;

public class TC_7_TestCasePage {
	WebDriver driver;
	RegisterPage rp;
	TestCasePage tcp;

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
		tcp=new TestCasePage(driver);
		Assert.assertEquals(rp.getHomePageLogo(), "https://automationexercise.com/");		
	}

	@Test(priority=2)
	void test_TestCasePage() {
		tcp.clickBtn_TestCase();
		Assert.assertEquals(tcp.getTestCasePage_Url(), "https://automationexercise.com/test_cases");
	}

	@AfterTest
	void tearDown() {
		driver.close();
	}

}
