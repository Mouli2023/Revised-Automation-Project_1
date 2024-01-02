package testClass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import pageObjectClass.CategoryPage;

public class TC_18_CategoryPage {
	WebDriver driver;
	CategoryPage cp;

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
	void testcategory() throws InterruptedException {
		cp=new CategoryPage(driver);
		Thread.sleep(3000);
		Assert.assertTrue(cp.chcektxt_Category().toLowerCase().contains("category"));
		Thread.sleep(3000);
		cp.clickWomen_Category();
		Thread.sleep(2000);
		cp.clickWomen_Dress();
		Thread.sleep(2000);
		Assert.assertEquals(cp.isDisplayedCategoryPage(), "https://automationexercise.com/category_products/1");
		Thread.sleep(3000);
		Assert.assertTrue(cp.isDisplayedTxtDressProducts().toLowerCase().contains("women - dress products"));
		Thread.sleep(3000);
		cp.clickMen_Category();
		cp.clickMen_Tshirt();
		Thread.sleep(4000);
		Assert.assertEquals(cp.isDisplayedCategoryPage_Men(), "https://automationexercise.com/category_products/3");
	}

	@AfterTest
	void tearDown() {
		driver.quit();				
	}

}
