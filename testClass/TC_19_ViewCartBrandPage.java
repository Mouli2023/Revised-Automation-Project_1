package testClass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import pageObjectClass.View_Cart_Brand_Page;


public class TC_19_ViewCartBrandPage {
	WebDriver driver;
	View_Cart_Brand_Page vcbp;

	@BeforeTest
	void setup() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\91933\\OneDrive\\Desktop\\WebDriver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://automationexercise.com");
	}

	@Test()
	void testViewCartBrandProducts() throws InterruptedException {
		vcbp=new View_Cart_Brand_Page(driver);
		vcbp.clickbtn_Product();
		Thread.sleep(3000);
		Assert.assertEquals(vcbp.isDisplayedBrandTxt(), "BRANDS");
		Thread.sleep(3000);
		vcbp.click_BrandHM();
		Thread.sleep(2000);
		Assert.assertEquals(vcbp.getBrandUrl(), "https://automationexercise.com/brand_products/H&M");
		Assert.assertTrue(vcbp.isDisplayedAllHMProducts().toLowerCase().contains("brand - h&m products"));
		vcbp.click_BrandPolo();
		Assert.assertEquals(vcbp.getBrandUrl_1(), "https://automationexercise.com/brand_products/Polo");
		Assert.assertTrue(vcbp.isDisplayedAllPoloProducts().toLowerCase().contains("brand - polo products"));		
	}

	@AfterTest
	void tearDown() {
		driver.quit();				
	}

}
