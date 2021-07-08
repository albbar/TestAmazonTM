package com.TechMachindra.Amazon.Runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)

@CucumberOptions(
		features = "src/test/resources/features/productSearches.feature",
		glue = "com.TechMachindra.Amazon.StepsDefinition",
		snippets = SnippetType.CAMELCASE,
		tags = {"@productSearches"}
		)

public class productSearchRunner {

}
