package testClass;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;

import pageObjectClass.AddProducts_CartPage;
import pageObjectClass.ProductDetailPage;
import pageObjectClass.QuantityCartPage;
import pageObjectClass.RegisterPage;

public class TC_12_AddProductsCartPage {

	WebDriver driver;
	RegisterPage rp;
	QuantityCartPage qcp;
	AddProducts_CartPage apcp;
	ProductDetailPage pdp;

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
		apcp=new AddProducts_CartPage(driver);
		pdp=new ProductDetailPage(driver);
		Assert.assertEquals(rp.getHomePageLogo(), "https://automationexercise.com/");		
	}

	@Test(priority=2)
	void testAddProductCart() throws InterruptedException {
		apcp.clickProductBtn();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", pdp.btn_viewFirstProduct);
		Actions action = new Actions(driver);
		Thread.sleep(3000);
		action.moveToElement(apcp.product_1).perform();
		action.moveToElement(apcp.btn_AddToCart_1).click().perform();
		//qcp.clickViewProductHomepage();
		Thread.sleep(3000);
		apcp.clickContinueShoppingBtn_1();
		Thread.sleep(3000);
		apcp.navigatedToProductPage("https://automationexercise.com/products");

		action.moveToElement(apcp.product_2).perform();
		action.moveToElement(apcp.btn_AddToCart_2).click().perform();
		apcp.clickViewCart();

		List<WebElement> table= apcp.table;
		System.out.println(table.size());
		if(table.size()>=2){
			System.out.println("Both products are added to cart");
		}
		else{
			System.out.println("Both the products are not added to cart");
		}

		apcp.getProductDetailsCart();			
	}

	@AfterTest
	void tearDown() {
		driver.quit();				
	}
}
