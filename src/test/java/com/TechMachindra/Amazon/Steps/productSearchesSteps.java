package com.TechMachindra.Amazon.Steps;

import com.TechMachindra.Amazon.Pages.HomePage;

import net.thucydides.core.annotations.Step;

public class productSearchesSteps {
	
	HomePage hPage;
	
	@Step
	public void openBrowser() {
		hPage.open();}
	
	@Step
	
	public void searchTextBoxBar(String search) {
		hPage.searchBarWrite(search);
	}
	
	@Step
	public void selectBrand(String brand) {
		hPage.clickMoreBrand();
		hPage.brandSelection(brand);
		
	}
	
	@Step
	public void selectLastProduct() {
		hPage.selectLastProduct();
	}
	
	@Step
	public void sendToCart() {
		hPage.sendToCart();
	}
	
	@Step
	public void validateAddedProduct() {
		hPage.validateAddedProduct();
	}

}
