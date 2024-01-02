package pageObjectClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class View_Cart_Brand_Page {
	public WebDriver driver;

	public View_Cart_Brand_Page(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}

	//WebElement
	@FindBy(xpath="//ul[@class='nav navbar-nav']/li[2]")WebElement btn_Product;
	@FindBy(xpath="//h2[text()='Brands']")WebElement txt_Brands;
	@FindBy(xpath="//ul[@class='nav nav-pills nav-stacked']/li[2]/a")WebElement txt_Brand_HM;
	@FindBy(xpath="//h2[text()='Brand - H&M Products']")WebElement txt_AllProductsHM;
	@FindBy(xpath="//ul[@class='nav nav-pills nav-stacked']/li[1]/a")WebElement txt_Brand_Polo;
	@FindBy(xpath="Brand - Polo Products")WebElement txt_AllProductsPolo;


	//Action Methods
	public void clickbtn_Product() {
		btn_Product.click();
	}

	public String isDisplayedBrandTxt() {
		return txt_Brands.getText();
	}

	public void click_BrandHM(){
		txt_Brand_HM.click();
	}

	public String getBrandUrl() {
		return driver.getCurrentUrl();
	}

	public String isDisplayedAllHMProducts() {
		return txt_AllProductsHM.getText();
	}

	public void click_BrandPolo(){
		txt_Brand_Polo.click();
	}

	public String getBrandUrl_1() {
		return driver.getCurrentUrl();
	}

	public String isDisplayedAllPoloProducts() {
		return txt_AllProductsPolo.getText();
	}

}
