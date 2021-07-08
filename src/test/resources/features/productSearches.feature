#Author: alcabarme@gmail.com
#Keywords Summary :
#Feature: Product Search

@productSearches
Feature: Select the lastest motorola cell phone

  @cellPhoneSearches
  Scenario Outline: Title of your scenario outline
    Given The user is on the amazon page
    When search for the desired product <search> <brand>
    Then the user verifies that the product has been added to the cart

    Examples: 
	    | search          | brand          |
      | "Mobile phones" |     "Motorola" |
