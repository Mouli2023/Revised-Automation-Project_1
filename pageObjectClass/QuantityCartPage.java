package pageObjectClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QuantityCartPage  {

	public WebDriver driver;
	public QuantityCartPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);		
	}

	//WebElement
	@FindBy(xpath="(//a[text()='View Product'])[1]")WebElement viewProduct_Homepage;
	@FindBy(xpath="//label[text()='Quantity:']")WebElement txt_Product_Detail;
	@FindBy(name="quantity")WebElement increase_Quantity;
	@FindBy(xpath="//button[@type='button']")WebElement addToCart;
	@FindBy(xpath="//p[@class='text-center'][2]/a/u")WebElement view_Cart;
	@FindBy(xpath="//a[text()='Blue Top']")WebElement name_Product;
	@FindBy(xpath="//button[@class='disabled']")WebElement qty_Product;


	//Action Methods
	public void clickViewProductHomepage() {
		viewProduct_Homepage.click();
	}

	public String isDisplayedProductDetail() {
		return txt_Product_Detail.getText();
	}

	public void setIncreaseQuantity(int quantities) {
		increase_Quantity.clear();
		increase_Quantity.sendKeys(String.valueOf(quantities));
	}

	public void clickBtnAddToCart() {
		addToCart.click();
	}

	public void clickBtnViewCart() {
		view_Cart.click();
	}

	public void getTxtProductNameQty() {
		System.out.println("Product Name: " + name_Product.getText());
		System.out.println("Product quantity: " + qty_Product.getText());
	}

}
