package pageObjectClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CategoryPage {
	public WebDriver driver;

	public CategoryPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}

	//WebElement
	@FindBy(xpath="//h2[text()='Category']")WebElement txt_Category;
	@FindBy(xpath="//a[contains(@href,'#Women')]")WebElement txt_Category_Women;
	@FindBy(xpath="//div[@id='Women']/div/ul/li[1]/a")WebElement btn_Women_Dress;
	@FindBy(xpath="//h2[text()='Women - Dress Products']")WebElement txt_Dress_Product;
	@FindBy(xpath="//a[contains(@href,'#Men')]")WebElement txt_Category_Men;
	@FindBy(xpath="//div[@id='Men']/div/ul/li[1]/a")WebElement txt_Men_Tshirt;

	//Action Methods
	public String chcektxt_Category() {
		return txt_Category.getText();
	}

	public void clickWomen_Category() {
		txt_Category_Women.click();
	}

	public void clickWomen_Dress() {
		btn_Women_Dress.click();
	}

	public String isDisplayedCategoryPage() {
		return driver.getCurrentUrl();
	}

	public String isDisplayedTxtDressProducts() {
		return txt_Dress_Product.getText();
	}

	public void clickMen_Category() {
		txt_Category_Men.click();
	}

	public void clickMen_Tshirt() {
		txt_Men_Tshirt.click();
	}

	public String isDisplayedCategoryPage_Men() {
		return driver.getCurrentUrl();
	}

}
