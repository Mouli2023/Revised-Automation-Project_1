package testClass;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import pageObjectClass.ProductDetailPage;
import pageObjectClass.RegisterPage;
import pageObjectClass.View_Cart_Brand_Page;


public class TC_8_9ProductDetail_SearchProduct {
	WebDriver driver;
	RegisterPage rp;
	View_Cart_Brand_Page vcbp;
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
		pdp=new ProductDetailPage(driver);
		vcbp=new View_Cart_Brand_Page(driver);
		Assert.assertEquals(rp.getHomePageLogo(), "https://automationexercise.com/");		
	}

	@Test(priority=2)
	void testProductDetail() throws InterruptedException {
		rp.getHomePageLogo();
		vcbp.clickbtn_Product();
		Thread.sleep(3000);
		Assert.assertEquals(pdp.getAllProductsUrl(), "https://automationexercise.com/products");
		Thread.sleep(3000);
		pdp.clickProductBtn();
		Thread.sleep(3000);
		Assert.assertEquals(pdp.getAllProductsUrl(), "https://automationexercise.com/products");
		Thread.sleep(3000);
		pdp.allProductsList();
		Thread.sleep(3000);
		pdp.clickBtn_ViewProduct();
		Thread.sleep(3000);
		Assert.assertEquals(pdp.getProductDetailPageUrl(), "https://automationexercise.com/product_details/1");
		Thread.sleep(3000);
		pdp.getDetailsProduct();	
	}

	@Test(priority=3)
	void testSearchProduct() {
		vcbp.clickbtn_Product();
		Assert.assertEquals(pdp.getAllProductsUrl(), "https://automationexercise.com/products");
		pdp.txtSearchBox("dress");
		pdp.clickBtnSearch();
		Assert.assertTrue(pdp.isDisplayedSearchedProducts().toLowerCase().contains("Searched Products"));
		List<WebElement> searchResults=pdp.getSearchResult();
		for(WebElement searchResult: searchResults) {
			Assert.assertTrue(searchResult.isDisplayed());

		}
	}

	@AfterTest
	void tearDown() {
		driver.quit();				
	}
}
