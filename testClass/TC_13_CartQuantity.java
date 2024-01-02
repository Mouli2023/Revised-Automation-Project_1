package testClass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import pageObjectClass.AddProducts_CartPage;
import pageObjectClass.ProductDetailPage;
import pageObjectClass.QuantityCartPage;
import pageObjectClass.RegisterPage;
import pageObjectClass.View_Cart_Brand_Page;

public class TC_13_CartQuantity {
	WebDriver driver;
	RegisterPage rp;
	View_Cart_Brand_Page vcbp;
	ProductDetailPage pdp;
	AddProducts_CartPage acp;
	QuantityCartPage qcp;

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
		qcp=new QuantityCartPage(driver);
		Assert.assertEquals(rp.getHomePageLogo(), "https://automationexercise.com/");		
	}

	@Test(priority=2)
	void testProductQtyCart() throws InterruptedException {
		qcp.clickViewProductHomepage();
		Thread.sleep(2000);
		Assert.assertEquals(qcp.isDisplayedProductDetail(), "Quantity:");
		qcp.setIncreaseQuantity(4);
		qcp.clickBtnAddToCart();
		qcp.clickBtnViewCart();	
		qcp.getTxtProductNameQty();
	}

	@AfterTest
	void teardown() {
		driver.quit();
	}


}
