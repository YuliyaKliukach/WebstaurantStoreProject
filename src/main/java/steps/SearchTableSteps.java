package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;

import java.util.List;

public class SearchTableSteps extends CommonMethods {

    @When("User clicks on search text box")
    public void user_clicks_on_search_text_box() throws InterruptedException {
        click(homePage.searchTextBox);
    }

    @When("User enters {string}")
    public void user_enters(String searchText) throws InterruptedException {
        sendText(homePage.searchTextBox, searchText);
    }

    @When("User clicks on search button")
    public void user_clicks_on_search_button() throws InterruptedException {
        click(homePage.searchButton);
        jsScrollBy();
        getWait();
    }

    @Then("Search results appears on home page and every result contains word {string} in its title")
    public void search_results_appears_on_home_page_and_every_result_contains_word_in_its_title(String expected) throws InterruptedException {
        List<WebElement> searchResults = homePage.searchResult;
        boolean flag = true;
        int iterator = 0;
        while (flag) {
            for (int i = 0; i < searchResults.size(); i++) {
                String header = searchResults.get(i).getText();
                if (header.toLowerCase().contains(expected)) {
                    Assert.assertTrue(expected + " NOT in result title", true);
                }
            }
            jsScrollByElement(homePage.nextResultPageButton);
            click(homePage.nextResultPageButton);
            iterator++;
            if (iterator == 9) {
                    flag = false;
                    break;
                }

        }
    }

    @And("Last result is adding to cart")
    public void lastResultIsAddingToCart() throws InterruptedException {
        List<WebElement> lastPageSearchResults=homePage.searchResult;
        for (int i = 0; i < lastPageSearchResults.size(); i++) {
            if (i == lastPageSearchResults.size() - 1) {
                WebElement lastInSearchResult = lastPageSearchResults.get(i);
                jsScrollByElement(lastInSearchResult);
                click(lastInSearchResult);
            }
        }
            jsScrollByElement(homePage.addToCartButton);
        Thread.sleep(3000);
        //waitForClickability(homePage.addToCartButton);
            click(homePage.addToCartButton);
            click(homePage.viewCartButton);
    }

    @And("Cart is getting empty and header is {string}")
    public void cartIsGettingEmpty (String expectedText) throws InterruptedException {

        click(homePage.emptyCartButton);
        click(homePage.emptyCartGreenButton);
        String resultText = homePage.cartHeader.getText();

        if (resultText.equals(expectedText)) {
            Assert.assertEquals("Text in cart is not like expected", expectedText, resultText);
            System.out.println(resultText);
        }
    }

}
