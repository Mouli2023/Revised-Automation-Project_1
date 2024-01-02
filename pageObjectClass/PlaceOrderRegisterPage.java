package pageObjectClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PlaceOrderRegisterPage {

	public WebDriver driver;
	public PlaceOrderRegisterPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);		
	}

	//WebElement 
	@FindBy(xpath="//a[@class='btn btn-default check_out']")WebElement btn_ProceedChcekOut;
	@FindBy(xpath="//u[text()='Register / Login']")WebElement btn_CartRegister;
	@FindBy(xpath="//h2[text()='Address Details']")WebElement txt_AddressDetails;
	@FindBy(xpath="//h2[text()='Review Your Order']")WebElement txt_ReviewOrder;
	@FindBy(xpath="//textarea[@name='message']")WebElement txt_Comment;
	@FindBy(xpath="//a[@class='btn btn-default check_out']")WebElement btn_PlaceOrder;
	@FindBy(xpath="//input[@name='name_on_card']")WebElement cardName;
	@FindBy(xpath="//input[@name='card_number']")WebElement cardNumber;
	@FindBy(xpath="//input[@name='cvc']")WebElement cardCVV;
	@FindBy(xpath="//input[@name='expiry_month']")WebElement monthExp;
	@FindBy(xpath="//input[@name='expiry_year']")WebElement yearExp;
	@FindBy(xpath="//button[@data-qa='pay-button']")WebElement payConfirmOrder;
	@FindBy(xpath="(//div[@class='alert-success alert'])[1]")WebElement txt_OrderPlacedMessage;

	//Action Methods 
	public void clickProceedCheckOut() {
		btn_ProceedChcekOut.click();
	}

	public void clickCartRegister() {
		btn_CartRegister.click();;
	}

	public String verifyAddressDeatils() {
		return txt_AddressDetails.getText();
	}

	public String getReviewOrder() {
		return txt_ReviewOrder.getText();
	}

	public void enterComment(String comment) {
		txt_Comment.sendKeys(comment);
	}

	public void clickPlaceOrder() {
		btn_PlaceOrder.click();
	}

	public void enterCardName(String cardname) {
		cardName.sendKeys(cardname);
	}

	public void enterCardNO(String cardnumber) {
		cardNumber.sendKeys(cardnumber);
	}

	public void enterCVV(String cvv) {
		cardCVV.sendKeys(cvv);
	}

	public void enterExpMM(String mm) {
		monthExp.sendKeys(mm);
	}

	public void enterExpYear(String year) {
		yearExp.sendKeys(year);
	}

	public void clickConfirmOrder() {
		payConfirmOrder.click();
	}

	public String getOrderPlacedSuccessMessage() {
		return txt_OrderPlacedMessage.getText();
	}


}
