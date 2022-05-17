package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import java.security.Key;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class DefinitionSteps {
    private static final long DEFAULT_TIMEOUT=90;
    WebDriver driver;
    HomePage homePage;
    SearchResultsPage searchResultsPage;
    ProductPage productPage;
    PageFactoryManager pageFactoryManager;

    @Before
    public void TestsSetUp(){
        chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager=new PageFactoryManager(driver);
    }
    @After
    public void tearDown(){driver.quit();}

    public WebDriver getDriver(){
        return driver;
    }

    @And("User opens {string} page")
    public void openPage(final String url) {
    homePage=pageFactoryManager.getHomePage();
    driver.get(url);
    }

    @And("User checks search field visibility")
    public void userChecksSearchFieldVisibility() {
    homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    Assert.assertTrue(homePage.isSearchFieldVisible());
    }

    @When("User makes search by keyword {string}")
    public void userMakesSearchByKeywordKeyword(final String keyword) {
        homePage.enterTextToSearchField(keyword);
    }


    @And("User clicks on product")
    public void userClicksOnProduct() {
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getHeaderCartButton());
        homePage.clickHeaderCartButton();
    }


    @Then("User checks that current url contains {string}")
    public void userChecksThatUrlContainsKeyword( final String keyword) {
        searchResultsPage=pageFactoryManager.getSearchResultsPage();
        Assert.assertTrue(getDriver().getCurrentUrl().contains(keyword));
    }



    @And("User makes search filter by brand {string}")
    public void userMakesSearchFilterByBrandBrand(final String brand) {
        searchResultsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        searchResultsPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, searchResultsPage.getSearchField());
        searchResultsPage.searchBrend(brand);
        searchResultsPage.takeCheckBoxHP();
    }

    @And("User takes expensive item filter")
    public void userTakesExpensiveItemFilter() {
        searchResultsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        searchResultsPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, searchResultsPage.getSearchField());
        searchResultsPage.waitForElementIsClicable(DEFAULT_TIMEOUT, searchResultsPage.getSearchField());
        searchResultsPage.takeExpensiveItem();
        searchResultsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        searchResultsPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, searchResultsPage.getSearchField());
        searchResultsPage.waitForElementIsClicable(DEFAULT_TIMEOUT, searchResultsPage.getSearchField());
        searchResultsPage.clickCartButtonOnFirstProduct();
    }

    @Then("User checks that price is more than {int}")
    public void userChecksThatPriceIsMoreThanPrice(final int price) {
        productPage=pageFactoryManager.getProductPage();
        productPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, productPage.getElementPrice());
        Assert.assertTrue(productPage.getPrice() >price);
    }
}
