#Author: aylen.rodriguez@willdom.com
#Date:18/3/2022
#Description:
@SmokeFeature
Feature: Pruebas selenium

  Scenario Outline: Autenticar
    Given the user is in the page
    When the user do anything
    Then status autenticacion <status>

    Examples: 
      | status |
      | fail   |

  Scenario Outline: Dropdown
    Given the user is in the page
    When the user select dropdown and select an <option>
    Then the status test <option>

    Examples: 
      | option   |
      | Option 1 |
      | Option 2 |

  #Hovers: cuando pasas el cursor por encima del elemento
  @smoketest
  Scenario Outline: Hovers
    Given the user is in the page
    When the user click hover and hover it <index>
    Then status test hover

    Examples: 
      | index |
      |     1 |
      |     2 |
      |     3 |
