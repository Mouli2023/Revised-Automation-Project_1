package testClass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import pageObjectClass.AddProducts_CartPage;
import pageObjectClass.PlaceOrderRegisterPage;
import pageObjectClass.RegisterPage;
import pageObjectClass.RemoveProductsCartPage;

public class TC_14_15_PlaceOrderRegister {

	WebDriver driver;
	RegisterPage rp;
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
		rpcp=new RemoveProductsCartPage(driver);
		apcp=new AddProducts_CartPage(driver);
		por=new PlaceOrderRegisterPage(driver);
		Assert.assertEquals(rp.getHomePageLogo(), "https://automationexercise.com/");		
	}

	//TestCase 14
	@Test (priority=2)
	void testPlaceOrderRegisterWhileCheckOut() throws InterruptedException {
		apcp.clickAddCartBtn_1();;
		Thread.sleep(2000);
		apcp.clickContinueShoppingBtn_1();
		Thread.sleep(2000);
		rpcp.clickCartBtn();
		Thread.sleep(3000);
		Assert.assertEquals(rpcp.isDisplayedCartPage(), "Shopping Cart");
		Thread.sleep(2000);
		por.clickProceedCheckOut();
		por.clickCartRegister();
		Thread.sleep(2000);
		rp.setSignUpName("Andy");
		rp.setSignUpEmail("andy123@gmail.com");
		Thread.sleep(2000);
		rp.clickSignUp();
		Thread.sleep(2000);
		rp.clickTitle();
		rp.setUserName("Andy");
		Thread.sleep(2000);
		rp.setEmail("andy@gmail.com");
		Thread.sleep(2000);
		rp.setPassword("andy123");
		Thread.sleep(2000);
		rp.setDay("3");
		rp.setMonth("August");
		rp.setYear("1996");
		rp.clickCheckBox1();
		rp.clickCheckBox2();
		rp.setFirstName("Andy");
		rp.setLastName("Christian");
		rp.setCompany("Google");
		rp.setAddress("Kanakpura Road");
		rp.setCountry("India");
		rp.setState("Karnataka");
		rp.setCity("Bengaluru");
		rp.setZipCode("560009");
		rp.setMobileNo("9330563456");
		Thread.sleep(2000);
		rp.clickCreateAccountBtn();
		Thread.sleep(3000);
		Assert.assertTrue(rp.getTxtAccCreated().toUpperCase().contains("account created!"));
		Thread.sleep(2000);
		rp.clickContinueBtn();
		Thread.sleep(3000);
		Assert.assertTrue(rp.getUserName().toLowerCase().contains("logged in as"));
		rpcp.clickCartBtn();
		Thread.sleep(2000);
		por.clickProceedCheckOut();
		Thread.sleep(3000);
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
		rp.clickDeleteAccBtn();
		Thread.sleep(4000);
		Assert.assertEquals(rp.getTxtAccDeleted(), "account deleted!");
		Thread.sleep(2000);
		rp.clickContinue_1();					
	}

	//TestCase 15
	@Test(priority=3)
	void testPlaceOrderRegisterBeforeCheckOut() throws InterruptedException {
		rp.clickSignUp();
		rp.setSignUpName("Andy");
		rp.setSignUpEmail("andy@gmail.com");
		rp.clickSignUp();
		rp.clickTitle();
		rp.setUserName("Andy");
		rp.setEmail("andy@gmail.com");
		rp.setPassword("andy123");
		rp.setDay("3");
		rp.setMonth("August");
		rp.setYear("1996");
		rp.clickCheckBox1();
		rp.clickCheckBox2();
		rp.setFirstName("Andy");
		rp.setLastName("Christian");
		rp.setCompany("Google");
		rp.setAddress("Kanakpura Road");
		rp.setCountry("India");
		rp.setState("Karnataka");
		rp.setCity("Bengaluru");
		rp.setZipCode("560009");
		rp.setMobileNo("9330563456");
		Thread.sleep(2000);
		rp.clickCreateAccountBtn();
		Thread.sleep(3000);
		Assert.assertTrue(rp.getTxtAccCreated().toUpperCase().contains("account created!"));
		Thread.sleep(2000);
		rp.clickContinueBtn();
		Thread.sleep(3000);
		Assert.assertTrue(rp.getUserName().toLowerCase().contains("logged in as"));
		apcp.clickAddCartBtn_1();
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
		rp.clickDeleteAccBtn();
		Thread.sleep(4000);
		Assert.assertEquals(rp.getTxtAccDeleted(), "account deleted!");
		Thread.sleep(2000);
		rp.clickContinue_1();						
	}

	@AfterTest
	void teardown(){
		driver.quit();
	}
}
