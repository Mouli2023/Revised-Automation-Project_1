package pageObjectClass;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddProducts_CartPage {
	public WebDriver driver;

	public AddProducts_CartPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}

	//WebElement_TC_12
	@FindBy(xpath="//i[@class='material-icons card_travel']")WebElement btn_Product;
	
	@FindBy(xpath="(//a[@data-product-id='1'])[1]")
	public WebElement btn_AddToCart_1;
	
	@FindBy(xpath="//img[@src='/get_product_picture/1']")
	public WebElement product_1;
	
	@FindBy(xpath="//button[@class='btn btn-success close-modal btn-block']")WebElement btn_ContinueShopping;
	
	@FindBy(xpath="(//a[@data-product-id='2'])[2]")
	public WebElement btn_AddToCart_2;
	
	@FindBy(xpath="//img[@src='/get_product_picture/2']")
	public WebElement product_2;
	
	@FindBy(xpath="//u[text()='View Cart']//parent::a")WebElement btn_ViewCart;
	
	@FindBy(xpath="//table[@id='cart_info_table']//tbody//tr")
	public List<WebElement> table;

	@FindBy(xpath="//tr[@id='product-1']/td[3]")WebElement price_Product_1;
	@FindBy(xpath="//tr[@id='product-2']/td[3]")WebElement price_Product_2;
	@FindBy(xpath="//tr[@id='product-1']/td[4]")WebElement quantity_Products_1;
	@FindBy(xpath="//tr[@id='product-2']/td[4]")WebElement quantity_Products_2;
	@FindBy(xpath="//tr[@id='product-1']/td[5]")WebElement totalPrice_1;
	@FindBy(xpath="//tr[@id='product-2']/td[5]")WebElement totalPrice_2;

	//Action Methods
	public void clickAddCartBtn_1() {
		btn_AddToCart_1.click();
	}

	public void clickProductBtn() {
		btn_Product.click();
	}

	public void clickContinueShoppingBtn_1() {
		btn_ContinueShopping.click();
	}

	public void navigatedToProductPage(String Url) {
		driver.navigate();
	}

	public void clickViewCart() {
		btn_ViewCart.click();
	}

	public void getProductDetailsCart() {
		System.out.println(price_Product_1.getText());
		System.out.println(price_Product_2.getText());	
		System.out.println(quantity_Products_1.getText());
		System.out.println(quantity_Products_2.getText());
		System.out.println(totalPrice_1.getText());
		System.out.println(totalPrice_1.getText());
	}

}
