package pageObjectClass;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsFormPage {
	public WebDriver driver;

	public ContactUsFormPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}

	//WebElement
	@FindBy(xpath="//ul[@class='nav navbar-nav']/li[8]")WebElement btn_ContactUsForm;
	@FindBy(xpath="//h2[text()='Get In Touch']")WebElement txt_GetInTouch;
	@FindBy(xpath="//input[@data-qa='name']")WebElement txt_Contact_Name;
	@FindBy(xpath="//input[@data-qa='email']")WebElement txt_Contact_Email;
	@FindBy(xpath="//input[@data-qa='subject']")WebElement txt_Contact_Subject;
	@FindBy(xpath="//textarea[@data-qa='message']")WebElement txt_Contact_Message;
	@FindBy(xpath="//input[@type='file']")WebElement file_Upload;
	@FindBy(xpath="//input[@data-qa='submit-button']")WebElement btn_Contact_Submit;
	@FindBy(xpath="//div[@class='status alert alert-success']")WebElement txt_Success_Message;
	@FindBy(xpath="//a[@class='btn btn-success']")WebElement btn_Home;

	//Action Methods
	public void clickContactUsForm() {
		btn_ContactUsForm.click();
	}

	public String checkGetInTouch() {
		return txt_GetInTouch.getText();
	}

	public void contact_Name(String Name) {
		txt_Contact_Name.sendKeys(Name);
	}

	public void contact_Email(String Email) {
		txt_Contact_Email.sendKeys(Email);
	}

	public void contact_Subject(String Subject) {
		txt_Contact_Subject.sendKeys(Subject);
	}

	public void contact_Message(String Message) {
		txt_Contact_Message.sendKeys(Message);
	}

	public void clickBtn_FileUpload() {
		//file_Upload.click();
		file_Upload.sendKeys("C:\\Users\\91933\\OneDrive\\Pictures\\Screenshots\\3.png");
	}

	public void clickBtn_Submit_Contact() {
		btn_Contact_Submit.click();
	}

	public void getAlertMessage() throws InterruptedException {
		Alert alert = driver.switchTo().alert();
		String alertMessage = driver.switchTo().alert().getText();
		Thread.sleep(3000);
		alert.accept();	
	}

	public String getSuccessMessage() {
		return txt_Success_Message.getText();
	}

	public void clickBtn_Home() {
		btn_Home.click();
	}

}
