#Author: aylen.rodriguez@willdom.com
#Date:21/3/2022
#Description:

@SmokeFeature
Feature: Login user

  @smoketest
  Scenario Outline: Autenticacion
    Given un usuario accede al portal
    When escribe el usuario <username>
    And escribe la contrasenna <password>
    And da click en aceptar
    Then el estado de la autenticacion es <status>

    Examples: 
      | username   | password  | status  |
      | 9999999999 | SanSe!20  | Success |
      | 9999999999 |  12343543 | Fail    |
      | 9999999999 |           | Fail    |
      | dsdfsffg   |           | Fail    |
      |            |           | Fail    |
      |            | fcfxgvxfc | Fail    |
