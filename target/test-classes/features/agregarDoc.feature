#Author: aylen.rodriguez@willdom.com
#Date:1/6/2022
#Description:

Feature: Registro usuario portal

  Scenario Outline: Agregar documento
    Given una persona que no es usuario
    When agrega documentos en registro de usuario
    Then sale del formulario y va hacia el registro nuevamente
