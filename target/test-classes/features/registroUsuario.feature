#Author: aylen.rodriguez@willdom.com
#Date:22/3/2022
#Description:

@SmokeFeature
Feature: Registro usuario portal

  @smoketest
  Scenario Outline: Solicitud Registro usuario correcta
    Given una persona que no es usuario y accede al Registro de usuario
    When envia solicitud con los datos introducidos correctamente
    Then se envia la solicitud correctamente y muestra el mensaje


