package testClass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import pageObjectClass.ContactUsFormPage;
import pageObjectClass.RegisterPage;


public class TC_6_ContactUsForm {
	WebDriver driver;
	RegisterPage rp;
	ContactUsFormPage cfp;

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
		cfp=new ContactUsFormPage(driver);
		Assert.assertEquals(rp.getHomePageLogo(), "https://automationexercise.com/");		
	}

	@Test(priority=2)
	void testContact_Us() throws InterruptedException {
		Thread.sleep(3000);
		cfp.clickContactUsForm();
		Thread.sleep(3000);
		Assert.assertTrue(cfp.checkGetInTouch().toLowerCase().contains("get in touch"));
		Thread.sleep(3000);
		cfp.contact_Name("Mouli");
		cfp.contact_Email("mouli123@gmail.com");
		cfp.contact_Subject("Math");
		cfp.contact_Message("I am good at Math");
		cfp.clickBtn_FileUpload();
		Thread.sleep(3000);
		cfp.clickBtn_Submit_Contact();
		cfp.getAlertMessage();
		Thread.sleep(3000);
		Assert.assertEquals(cfp.getSuccessMessage(), "Success! Your details have been submitted successfully.");
		Thread.sleep(3000);
		cfp.clickBtn_Home();
		rp.getHomePageLogo();		
	}

	@AfterTest
	void tearDown() {
		driver.quit();
	}

}
