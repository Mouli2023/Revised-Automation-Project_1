package pageObjectClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RemoveProductsCartPage {
	public WebDriver driver;
	public RemoveProductsCartPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);		
	}

	//WebElement
	@FindBy(xpath="//button[@class='btn btn-success close-modal btn-block']")WebElement btn_ContinueShopping;
	@FindBy(xpath="//ul[@class='nav navbar-nav']/li[3]")WebElement btn_Cart;
	@FindBy(xpath="//li[text()='Shopping Cart']")WebElement cartPage;
	@FindBy(xpath="//a[@class='cart_quantity_delete']")WebElement btn_Delete_Product;
	@FindBy(xpath="//b[text()='Cart is empty!']")WebElement txt_Empty_Cart;

	//Action Methods
	public void clickContinueShopping() {
		btn_ContinueShopping.click();
	}

	public void clickCartBtn() {
		btn_Cart.click();	
	}

	public String isDisplayedCartPage() {
		return cartPage.getText();
	}

	public void clickProductDeleteBtn() {
		btn_Delete_Product.click();
	}

	public void getTxtCartEmpty() {
		System.out.println("Verified "  +  txt_Empty_Cart.getText());
	}

}
