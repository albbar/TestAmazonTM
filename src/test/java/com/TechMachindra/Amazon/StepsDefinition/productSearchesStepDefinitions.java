package com.TechMachindra.Amazon.StepsDefinition;

import com.TechMachindra.Amazon.Steps.productSearchesSteps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class productSearchesStepDefinitions {
	
	@Steps
	productSearchesSteps pSSteps;
	
	@Given("^The user is on the amazon page$")
	public void theUserIsOnTheAmazonPage() {
	    pSSteps.openBrowser();
	}

	@When("^search for the desired product \"([^\"]*)\" \"([^\"]*)\"$")
	public void searchForTheDesiredProduct(String search, String brand) {
		pSSteps.searchTextBoxBar(search);
	    pSSteps.selectBrand(brand);
	    pSSteps.selectLastProduct();
	    pSSteps.sendToCart();
	}

	@Then("^the user verifies that the product has been added to the cart$")
	public void theUserVerifiesThatTheProductHasBeenAddedToTheCart() {
		pSSteps.validateAddedProduct();
	}

}
