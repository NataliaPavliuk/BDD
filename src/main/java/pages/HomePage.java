package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//input[contains(@class, 'search-form__input')]")
    private WebElement searchField;

    @FindBy(xpath = " //button[contains(@class, 'header__button ng-star-inserted header__button--active')]")
    private WebElement headerCartButton;


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isSearchFieldVisible() {
        return searchField.isDisplayed();
    }

    public void enterTextToSearchField(final String searchText) {
        searchField.sendKeys(searchText, Keys.ENTER);
       // searchField.sendKeys(Keys.ENTER);
    }

    public WebElement getHeaderCartButton(){
        return headerCartButton;
    }

    public void clickHeaderCartButton() {
        headerCartButton.click();
    }


}
