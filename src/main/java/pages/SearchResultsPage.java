package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultsPage extends BasePage{
    @FindBy(xpath = "//div[@class='sidebar-search']//input[@name='searchline']")
    private WebElement searchField;

    @FindBy(xpath = "//a[@data-id='Samsung']")
    private WebElement checkboxSamsung;

    @FindBy(xpath = "//a[@data-id='HP']")
    private WebElement checkboxHP;

    @FindBy(xpath = "//a[@data-id='Apple']")
    private WebElement checkboxApple;

    @FindBy(xpath = "//option[contains(@value, 'expensive')]")
    private WebElement expensiveItem;

    @FindBy(xpath = " //button[@class='buy-button goods-tile__buy-button ng-star-inserted']")
    private WebElement cartButtons;


    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getCartButtons(){return cartButtons;}

    public WebElement getExpensiveItem(){return expensiveItem;}

    public void clickCartButtonOnFirstProduct() {
       cartButtons.click();
   }

    public WebElement getSearchField() {
        return searchField;
    }

    public void takeExpensiveItem(){expensiveItem.click();}

    public void takeCheckBoxSamsung(){checkboxSamsung.click();}
    public void takeCheckBoxHP(){checkboxHP.click();}
    public void takeCheckBoxApple(){checkboxApple.click();}
    public void searchBrend(final String searchText) {
        searchField.clear();
        searchField.sendKeys(searchText, Keys.ENTER);;
    }
    }

