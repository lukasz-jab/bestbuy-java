Feature: BestBuy Customer Flow

  Scenario Outline: Search item by nav input
    Given main page is open
    When I fill search input with <item> and click search btn
    Then list of found items will be displayed

    Examples:
      | item         |
      | headphones   |
      | p i l l o w  |
      | sport camera |