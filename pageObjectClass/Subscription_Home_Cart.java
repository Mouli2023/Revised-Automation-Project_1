package pageObjectClass;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class Subscription_Home_Cart {
	public WebDriver driver;

	public Subscription_Home_Cart(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}

	//WebElement_TC_10
	@FindBy(xpath="//h2[text()='Subscription']")WebElement txt_Subscription;
	@FindBy(xpath="//input[@id='susbscribe_email']")WebElement txt_Email_Subscription;
	@FindBy(xpath="//button[@id='subscribe']")WebElement btn_Arrow;
	@FindBy(xpath="//div[text()='You have been successfully subscribed!']")WebElement txt_Subscribed_Message;

	//WebElement_TC_11
	@FindBy(xpath="//ul[@class='nav navbar-nav']/li[3]")WebElement btn_Cart;

	//WebElement_TC_25
	@FindBy(xpath="//a[@id='scrollUp']")WebElement btn_ScrolledUp;
	@FindBy(xpath="(//h2[text()='Full-Fledged practice website for Automation Engineers'])[2]")WebElement txt_WebsiteInfo;


	//Action Method
	public String getTxt_Subscription() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scroll(0,1000)");
		return txt_Subscription.getText();
	}

	public void setEmail_Subscription(String Email) {
		txt_Email_Subscription.sendKeys(Email);
	}

	public void clickArrowBtn() {
		btn_Arrow.click();
	}

	public void getTxt_SubscribedMessageHomePage() {
		System.out.println(" Subscription Message of HomePage is Verified " + txt_Subscribed_Message.getText());
	}

	public void clickCartBtnHomePage() {
		btn_Cart.click();;
	}

	public void getTxt_SubscribedMessageCartPage() {
		System.out.println(" Subscription Message of CartPage is Verified " + txt_Subscribed_Message.getText());
	}

	public void clickArrowScrolledUp() {
		btn_ScrolledUp.click();
	}

	public String getTxtWebsiteInfo() {
		return txt_WebsiteInfo.getText();
	}

}

