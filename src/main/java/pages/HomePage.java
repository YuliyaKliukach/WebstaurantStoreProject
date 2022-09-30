package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

import java.util.List;

public class HomePage extends CommonMethods {

    @FindBy (id="searchval")
    public WebElement searchTextBox;

    @FindBy (xpath = "//button[@value='Search']")
    public WebElement searchButton;

    @FindBy (xpath = "//a[@data-testid='itemDescription']")
    public List<WebElement> searchResult;

    @FindBy (xpath = "//li[contains(@class, 'rounded-r-md')]")
    public WebElement nextResultPageButton;

    @FindBy (id = "buyButton")
    public WebElement addToCartButton;

    @FindBy (xpath = "//i[contains(@class, 'shopping')]")
    public WebElement viewCartButton;

    @FindBy (xpath = "//button[contains(@class, 'empty')] ")
    public WebElement emptyCartButton;

    @FindBy (xpath = "//button[contains(text(), 'Empty')]/parent::footer")
    public WebElement emptyCartGreenButton;

    @FindBy (className = "header-1")
    public WebElement cartHeader;

    public HomePage(){
        PageFactory.initElements(driver, this);
    }
}
