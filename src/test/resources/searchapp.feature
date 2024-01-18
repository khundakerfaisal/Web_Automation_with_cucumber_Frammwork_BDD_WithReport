Feature: search or find the result using github functionalities

  Scenario Outline: User visits Github site as a guest for doing some actions
    Given User visited the Github page enter the website url
    When User search With "<searchName>"
    Then User can find with "<searchExpectName>"
    And User click on the About page

    Examples:
      | searchName       | searchExpectName          |
      | create-react-app | facebook/create-react-app |

