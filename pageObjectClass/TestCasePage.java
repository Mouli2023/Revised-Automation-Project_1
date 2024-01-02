package pageObjectClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestCasePage {
	public WebDriver driver;

	public TestCasePage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}

	//WebElement
	@FindBy(xpath="//ul[@class='nav navbar-nav']/li[5]")WebElement btn_TestCase;

	//Action Method
	public void clickBtn_TestCase() {
		btn_TestCase.click();
	}

	public String getTestCasePage_Url() {
		return driver.getCurrentUrl();
	}

}
