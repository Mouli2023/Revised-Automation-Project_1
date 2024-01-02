package testClass;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import pageObjectClass.AddProducts_CartPage;
import pageObjectClass.LoginPage;
import pageObjectClass.PlaceOrderRegisterPage;
import pageObjectClass.RegisterPage;
import pageObjectClass.RemoveProductsCartPage;


public class TC_16_PlaceOrderLogin {

	WebDriver driver;
	RegisterPage rp;
	LoginPage lp;
	AddProducts_CartPage apcp;
	RemoveProductsCartPage rpcp;
	PlaceOrderRegisterPage por;

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
		lp=new LoginPage(driver);
		rpcp=new RemoveProductsCartPage(driver);
		apcp=new AddProducts_CartPage(driver);
		por=new PlaceOrderRegisterPage(driver);
		Assert.assertEquals(rp.getHomePageLogo(), "https://automationexercise.com/");		
	}

	@Test(priority=2)
	void testPlaceOrderBeforeChcekOut()throws InterruptedException {
		rp.clickSignUp();
		lp.setEmailLogin("moon@gmail.com");
		lp.setPasswordLogin("moon123");
		lp.clickBtnLogin();
		Thread.sleep(3000);
		Assert.assertTrue(rp.getUserName().toLowerCase().contains("logged in as"));
		apcp.clickAddCartBtn_1();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("scroll(0,-100)");
		apcp.clickContinueShoppingBtn_1();
		Thread.sleep(2000);
		rpcp.clickCartBtn();
		Thread.sleep(3000);
		Assert.assertTrue(rpcp.isDisplayedCartPage().toLowerCase().contains("shopping cart"));
		Thread.sleep(3000);
		por.clickProceedCheckOut();
		Assert.assertTrue(por.verifyAddressDeatils().toLowerCase().contains("address details"));
		Thread.sleep(3000);
		Assert.assertTrue(por.getReviewOrder().toLowerCase().contains("review your order"));
		Thread.sleep(2000);
		por.enterComment("Place the order as early as possible");
		Thread.sleep(2000);
		por.clickPlaceOrder();
		Thread.sleep(2000);
		por.enterCardName("Mouli");
		por.enterCardNO("555666777456");
		por.enterCVV("455");
		por.enterExpMM("07");
		por.enterExpYear("2025");
		Thread.sleep(2000);
		por.clickConfirmOrder();
		Thread.sleep(4000);
		Assert.assertTrue(por.getOrderPlacedSuccessMessage().contains("Your order has been placed successfully!"));
		Thread.sleep(2000);
		//rp.clickDeleteAccBtn();
		Thread.sleep(4000);
		//Assert.assertTrue(rp.getTxtAccDeleted().toLowerCase().contains("account deleted!"));
		Thread.sleep(2000);
		rp.clickContinue_1();			
	}

	@AfterTest
	void teardown(){
		driver.quit();
}



}
