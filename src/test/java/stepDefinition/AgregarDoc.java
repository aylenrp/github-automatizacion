package stepDefinition;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AgregarDoc {
	WebDriver driver;
	private By agregarDocButton = By.className("MuiButton-label");
    private By selectTipoDocButton = By.id("DocumentoUsuario_siglaDocumento"); 
	
    
	@Given("^una persona que no es usuario$")
	public void given() throws Throwable {
	}

	@When("^agrega documentos en registro de usuario$")
	public void agrega_documentos_en_registro_de_usuario() throws InterruptedException, IOException {
		driver.findElement(agregarDocButton).click();
		Select selectTipoDoc = new Select(driver.findElement(selectTipoDocButton));
		selectTipoDoc.selectByValue("CERTIFICADO DE AGENTE MARITIMO");
		
	}

	@Then("^sale del formulario y va hacia el registro nuevamente$")
	public void then() throws Throwable {
	}

}
