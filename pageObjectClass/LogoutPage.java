package pageObjectClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
	public WebDriver driver;

	public LogoutPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}

	//WebElement
	@FindBy(xpath="//ul[@class='nav navbar-nav']/li[4]")WebElement btn_Logout;

	//Action Method
	public void clickLogoutBtn() {
		btn_Logout.click();
	}

	public String checkLoginPageUrl() {
		return driver.getCurrentUrl();
	}

}
