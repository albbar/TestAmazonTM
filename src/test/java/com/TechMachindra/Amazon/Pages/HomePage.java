package com.TechMachindra.Amazon.Pages;

import java.util.List;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

@DefaultUrl("https://www.amazon.com/")
public class HomePage extends PageObject {

	@FindBy(xpath = "//input[@id='twotabsearchtextbox']")
	WebElementFacade SearchBar;

	@FindBy(xpath = "//div[@id='brandsRefinements']//span[@class='a-expander-prompt']")
	WebElementFacade btnSeeMoreBrands;
	
	@FindBy(xpath = "//div[@data-component-type='s-search-result']")
	List<WebElement> lstProducts;
	
	@FindBy(xpath = "//a[contains(text(),'Ver todas las opciones')]")
	WebElementFacade btnallOptions;
	
	@FindBy(xpath = "(//input[@name='submit.addToCart'])[1]")
	WebElementFacade btnAddToCart2;
	
	@FindBy(xpath = "//h1[contains(text(),'Agregado al carrito')]")
	WebElementFacade lblAddedProduct;
	
	@FindBy(xpath = "//input[@id='add-to-cart-button']")
	WebElementFacade btnAddToCart;

	public void searchBarWrite(String object) {
		SearchBar.typeAndEnter(object);
	}

	public void clickMoreBrand() {
		btnSeeMoreBrands.click();
	}

	public void brandSelection(String brand) {
		WebElement selectBrand = getDriver().findElement(By.xpath("//span[contains(text(),'" + brand + "')]"));
		selectBrand.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void selectLastProduct() {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();  
		js.executeScript("window.scrollBy(0,4000)");
		WebElement lastProductOnThePage =getDriver().findElement(By.cssSelector("div.s-main-slot.s-result-list.s-search-results.sg-row div[data-component-type='s-search-result']:nth-of-type("+lstProducts.size()+") img"));
		lastProductOnThePage.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void sendToCart() {
		if(btnAddToCart.isCurrentlyVisible()) {
			btnAddToCart.click();
		} else if(btnallOptions.isCurrentlyVisible()) {
			btnallOptions.click();
			btnAddToCart2.click();
		}
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void validateAddedProduct() {
		if(lblAddedProduct.isCurrentlyVisible()) {
			Assert.assertEquals(lblAddedProduct.getText(), "Agregado al carrito", "Message is not visible");
		}
	}

}
