package pageObjectClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver driver;

	public LoginPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}

	//WebElement_TC_2
	@FindBy(xpath="//ul[@class='nav navbar-nav']/li[4]")WebElement signUp;
	@FindBy(xpath="//div[@class='login-form']/h2")WebElement txt_Login_Acc;
	@FindBy(xpath="//input[@data-qa='login-email']")WebElement txt_Login_Email;
	@FindBy(xpath="//input[@data-qa='login-password']")WebElement txt_Login_Password;
	@FindBy(xpath="//button[@data-qa='login-button']")WebElement btn_Login;
	@FindBy(xpath="//ul[@class='nav navbar-nav']/li[10]")WebElement txt_LoggedUserName;
	@FindBy(xpath="//ul[@class='nav navbar-nav']/li[5]")WebElement btn_DeleteAcc;

	//WebElement_TC_3
	@FindBy(xpath="//p[text()='Your email or password is incorrect!']")WebElement txt_Incorrect_Credential;

	//Action Method
	public String getHomePageLogo() {
		return driver.getCurrentUrl();		
	}

	public void clickSignUp() {
		signUp.click();	
	}

	public String getLoginAccTxt() {
		return txt_Login_Acc.getText();	
	}

	public void setEmailLogin(String Email) {
		txt_Login_Email.sendKeys(Email);
	}

	public void setPasswordLogin(String Password) {
		txt_Login_Password.sendKeys(Password);
	}

	public void clickBtnLogin() {
		btn_Login.click();
	}

	public String getLoggedUserName() {
		return txt_LoggedUserName.getText();	
	}

	public void clickBtnLogin_1() {
		btn_Login.click();
	}

	public String getIncorrectCredentialTxt() {
		return txt_Incorrect_Credential.getText();	
	}

}
