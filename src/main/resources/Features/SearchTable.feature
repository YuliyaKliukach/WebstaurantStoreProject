Feature: Searching on WebstaurantStore website

  @SearchOnHomePage
  Scenario Outline: Search for given information using search bar on home page
    When User clicks on search text box
    And User enters "<Search Text>"
    And User clicks on search button
    Then Search results appears on home page and every result contains word "table" in its title
    And Last result is adding to cart
    And Cart is getting empty and header is "Your cart is empty."

    Examples:
    | Search Text         |
    | stainless work table|