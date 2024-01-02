package pageObjectClass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;

public class ProductDetailPage {
	public WebDriver driver;

	public ProductDetailPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}

	//WebElement_TC_8
	@FindBy(xpath="//ul[@class='nav navbar-nav']/li[2]")WebElement btn_ProductHomepage;
	@FindBy(xpath="//div[@class='product-image-wrapper']")List<WebElement> allProductsList;
	
	@FindBy(xpath="(//a[text()='View Product'])[1]")
	public WebElement btn_viewFirstProduct;
	
	@FindBy(xpath="//h2[text()='Blue Top']")WebElement txt_ProductName;
	@FindBy(xpath="//p[text()='Category: Women > Tops']")WebElement txt_ProductCategory;
	@FindBy(xpath="//span[text()='Rs. 500']")WebElement txt_ProductPrice;
	@FindBy(xpath="//p[text()=' In Stock']")WebElement txt_ProductAvailability;
	@FindBy(xpath="//p[text()=' New']")WebElement txt_ProductCondition;
	@FindBy(xpath="//p[text()=' Polo']")WebElement txt_ProductBrand;

	//WebElement_TC_9
	@FindBy(xpath="//input[@id='search_product']")WebElement txt_Searchbox;
	@FindBy(xpath="//button[@id='submit_search']")WebElement btn_Search;
	@FindBy(xpath="//h2[text()='Searched Products']")WebElement txt_SearchedProducts;
	@FindBy(xpath="//div[@class='product-image-wrapper']//p")List<WebElement> search_Products;

	//Action Methods
	public void clickProductBtn() {
		btn_ProductHomepage.click();
	}

	public String getAllProductsUrl() {
		return driver.getCurrentUrl();
	}
	public List<WebElement> allProductsList() {
		System.out.println(allProductsList.size());
		for(WebElement product:allProductsList) {
			System.out.println(product.getText());
		}
		return allProductsList;
	}

	public void clickBtn_ViewProduct() {
		btn_viewFirstProduct.click();
	}

	public String getProductDetailPageUrl() {
		return driver.getCurrentUrl();
	}

	public void getDetailsProduct() {
		System.out.println(txt_ProductName.getText());
		System.out.println(txt_ProductCategory.getText());
		System.out.println(txt_ProductPrice.getText());
		System.out.println(txt_ProductAvailability.getText());
		System.out.println(txt_ProductCondition.getText());
		System.out.println(txt_ProductBrand.getText());
	}

	public void txtSearchBox(String name) {
		txt_Searchbox.sendKeys(name);	
	}

	public void clickBtnSearch() {
		btn_Search.click();
	}

	public String isDisplayedSearchedProducts() {
		return txt_SearchedProducts.getText();
	}

	public List<WebElement> getSearchResult(){
		System.out.println(search_Products.size());
		for(WebElement searchProduct : search_Products){
			System.out.println(searchProduct.getText());
		}
		return search_Products;
	}

	@AfterTest
	void teardown() {
		driver.quit();
	}

}

