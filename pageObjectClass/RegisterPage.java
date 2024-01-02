package pageObjectClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage {

	public WebDriver driver;

	//Constructor
	public RegisterPage (WebDriver driver){

		this.driver=driver;
		PageFactory.initElements(driver, this);

	}

	//WebElement
	@FindBy(xpath="//ul[@class='nav navbar-nav']/li[4]")WebElement signUp;

	@FindBy(xpath="//div[@class='signup-form']/h2")WebElement txt_NewUserSignUp;
	@FindBy(xpath="//input[@data-qa='signup-name']")WebElement txt_SignUpName;
	@FindBy(xpath="//input[@data-qa='signup-email']")WebElement txt_SignUpEmail;
	@FindBy(xpath="//button[@data-qa='signup-button']")WebElement btn_SignUp;

	@FindBy(xpath="//b[text()='Enter Account Information']//parent::h2")WebElement txt_AccInfo;
	@FindBy(xpath="//div[@id='uniform-id_gender2']")WebElement btn_Title;
	@FindBy(xpath="//input[@data-qa='name']")WebElement txt_Name;
	@FindBy(xpath="//input[@id='email'] ")WebElement txt_Email;
	@FindBy(xpath="//input[@id='password'] ")WebElement txt_Password;
	@FindBy(xpath="//select[@id='days']")WebElement dropdown_Day;
	@FindBy(xpath="//select[@id='months']")WebElement dropdown_Month;
	@FindBy(xpath="//select[@id='years']")WebElement dropdown_Year;
	@FindBy(xpath="//input[@id='newsletter']")WebElement checkBox_1;
	@FindBy(xpath="//input[@name='optin']")WebElement checkBox_2;

	@FindBy(xpath="//input[@id='first_name']")WebElement txt_Fname;
	@FindBy(xpath="//input[@id='last_name']")WebElement txt_Lname;
	@FindBy(xpath="//input[@id='company']")WebElement txt_Company;
	@FindBy(xpath="//input[@data-qa='address']")WebElement txt_Address;
	@FindBy(xpath="//option[@value='India']")WebElement txt_Country;
	@FindBy(xpath="//input[@id='state']")WebElement txt_State;
	@FindBy(xpath="//input[@data-qa='city']")WebElement txt_City;
	@FindBy(xpath="//input[@data-qa='zipcode']")WebElement txt_ZipCode;
	@FindBy(xpath="//input[@data-qa='mobile_number']")WebElement txt_Mobile;
	@FindBy(xpath="//button[@data-qa='create-account']")WebElement btn_CreateAcc;

	@FindBy(xpath="//h2[@class='title text-center']")WebElement txt_AccCreated;
	@FindBy(xpath="//a[@data-qa='continue-button']")WebElement btn_Continue;
	@FindBy(xpath="//i[@class='fa fa-user']//parent::a")WebElement txt_LoggedUserName;
	@FindBy(xpath="//ul[@class='nav navbar-nav']/li[5]")WebElement btn_DeleteAcc;
	@FindBy(xpath="//b[text()='Account Deleted!']")WebElement txt_AccDeleted;
	@FindBy(xpath="//div[@class='pull-right']/a")WebElement btn_Continue1;

	@FindBy(xpath="//form[@action='/signup']//p")WebElement txt_existingEmail;

	//Action Methods
	public String getHomePageLogo() {
		return driver.getCurrentUrl();		
	}

	public void clickSignUp() {
		signUp.click();	
	}

	public String getNewUserSignUpTxt() {
		return txt_NewUserSignUp.getText();	
	}

	public void setSignUpName(String name) {

		txt_SignUpName.sendKeys(name);
	}

	public void setSignUpEmail(String email) {
		txt_SignUpEmail.sendKeys(email);
	}

	public void SignUpBtn() {
		btn_SignUp.click();;
	}

	public String getAccInfo() {
		return txt_AccInfo.getText();

	}

	public void clickTitle() {
		btn_Title.click();
	}

	public void setUserName(String Uname) {
		txt_Name.clear();
		txt_Name.sendKeys(Uname);
	}

	public void setEmail(String Uemail) {
		txt_Email.clear();
		txt_Email.sendKeys(Uemail);
	}

	public void setPassword(String Password) {
		txt_Password.sendKeys(Password);
	}

	public void setDay(String Day) {
		Select select= new Select(dropdown_Day);
		select.selectByValue("3");
	}

	public void setMonth(String Month) {
		Select select= new Select(dropdown_Month);
		select.selectByVisibleText("August");
	}

	public void setYear(String Year) {
		Select select= new Select(dropdown_Year);
		select.selectByValue("1996");
	}

	public void clickCheckBox1() {
		checkBox_1.click();
	}

	public void clickCheckBox2() {
		checkBox_2.click();
	}

	public void setFirstName(String Fname) {
		txt_Fname.sendKeys(Fname);
	}

	public void setLastName(String Lname) {
		txt_Lname.sendKeys(Lname);
	}

	public void setCompany(String Company) {
		txt_Company.sendKeys(Company);
	}

	public void setAddress(String Add) {
		txt_Address.sendKeys(Add);
	}

	public void setCountry(String Country) {
		txt_Country.sendKeys(Country);
	}

	public void setState(String State) {
		txt_State.sendKeys(State);
	}

	public void setCity(String City) {
		txt_City.sendKeys(City);
	}

	public void setZipCode(String PIN) {
		txt_ZipCode.sendKeys(PIN);
	}

	public void setMobileNo(String Phone) {
		txt_Mobile.sendKeys(Phone);
	}

	public void clickCreateAccountBtn() {
		btn_CreateAcc.click();;
	}

	public String getTxtAccCreated() {
		return txt_AccCreated.getText();	
	}

	public void clickContinueBtn() {
		btn_Continue.click();;
	}

	public String getUserName() {
		return txt_LoggedUserName.getText();
	}

	public void clickDeleteAccBtn() {
		btn_DeleteAcc.click();;
	}

	public String getTxtAccDeleted() {
		return txt_AccDeleted.getText();	
	}

	public void clickContinue_1() {
		btn_Continue1.click();;
	}

	public String checkExistingEmail() {
		return txt_existingEmail.getText();
	}
	
}


