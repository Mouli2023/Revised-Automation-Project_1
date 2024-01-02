package testClass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjectClass.AddProducts_CartPage;
import pageObjectClass.RegisterPage;
import pageObjectClass.RemoveProductsCartPage;

public class TC_17_RemoveProductsCart {
	WebDriver driver;
	RegisterPage rp;
	AddProducts_CartPage apcp;
	RemoveProductsCartPage rpcp;

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
		apcp=new AddProducts_CartPage(driver);
		rpcp=new RemoveProductsCartPage(driver);
		Assert.assertEquals(rp.getHomePageLogo(), "https://automationexercise.com/");		
	}

	@Test(priority=2)
	void testRemoveProduct() throws InterruptedException {
		apcp.clickAddCartBtn_1();
		Thread.sleep(3000);
		rpcp.clickContinueShopping();
		Thread.sleep(3000);
		rpcp.clickCartBtn();
		Thread.sleep(6000);
		Assert.assertTrue(rpcp.isDisplayedCartPage().toLowerCase().contains("shopping cart"));
		Thread.sleep(6000);
		rpcp.clickProductDeleteBtn();
		Thread.sleep(6000);
		rpcp.getTxtCartEmpty();
	}

	@AfterTest
	void teardown() {
		driver.quit();
	}

}
