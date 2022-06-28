package stepDefinition;

import static org.testng.AssertJUnit.assertArrayEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.*;
import org.testng.Assert;


public class RegistroUsuario {
	WebDriver driver;
	
	private By rolSelect = By.id("rolSolicitado");
	private By tipoDocumentoReg = By.id("tipoDocumento");
	//private By tipoDocDrops = By.id("tipoDocumento");
	private By numDoc = By.id("ruc");
	private By numTelefono = By.id("telefono");
	private By razonSocial = By.id("razonsocial");
	private By email = By.id("email");
	private By agregarDocButton = By.className("MuiButton-label");
    private By selectTipoDoc = By.id("DocumentoUsuario_siglaDocumento"); 
	private By documento = By.className("MuiTypography-root MuiTypography-body1 MuiTypography-colorTextSecondary");
	private By fechaExp = By.id("DocumentoUsuario_fechaExpedicion");
    private By fechVenc = By.id("DocumentoUsuario_fechaVencimiento");
    private By numDocUs = By.id("DocumentoUsuario_numeroDocumento");
    private By numRef = By.id("DocumentoUsuario_numeroReferencia");
	private By botonGuardar = By.xpath("/html/body/div[3]/div[3]/div/div[2]/form/div[2]/div/div[1]/button/span[1]");
	private By observacion = By.id("observacion");
	
	@Given("^una persona que no es usuario y accede al Registro de usuario$")
	public void una_persona_que_no_es_usuario() {
		System.setProperty("webdriver.gecko.driver", "Drivers/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.navigate().to("http://wildfly-codium.vue.gov.py/portal/registro-usuario");
	}

	@When("^envia solicitud con los datos introducidos correctamente$")
	public void envia_solicitud_con_los_datos_introducidos() throws InterruptedException, IOException {	
		//Select selectRol = new Select(driver.findElement(By.id("rolSolicitado")));
		//selectRol.selectByVisibleText("Exportador, Importador o Despachante");
		//selectRol.selectByValue("Regente (DINAVISA)");
		
		//Select selectTipoDocReg = new Select(driver.findElement(By.id("tipoDocumento")));
		//selectTipoDocReg.selectByVisibleText("Cédula"); //opcion cedula
		
		
		driver.findElement(rolSelect).sendKeys("Exportador, Importador o Despachante");
		driver.findElement(tipoDocumentoReg).sendKeys("Cédula");
		driver.findElement(numDoc).sendKeys("17395224"); //esto es un ruc cambiar luego
		driver.findElement(razonSocial).click();
		//driver.findElement(numTelefono).clear();
		
		//driver.findElement(numTelefono).sendKeys("231243242");
		
		//driver.findElement(email).sendKeys("aylen.rodriguez@willdom.com");
		
		
		
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //esperar segundos
		
		
		driver.findElement(agregarDocButton).click();
		//Select selectTipoDoc = new Select(driver.findElement(selectTipoDocButton));
		//selectTipoDoc.selectByValue("CERTIFICADO DE AGENTE MARITIMO");
		
		//driver.findElement(selectTipoDoc).sendKeys("CERTIFICADO DE AGENTE MARITIMO");
		
		//WebElement adjuntar= driver.findElement(By.id("DocumentoUsuario_nombreArchivo"));
		//adjuntar.sendKeys("C:/Users/aylen/Documents/WillDom/Testing/Datos de pruebas/Captura.png");
		
		///html/body/div[1]/div[2]/div[2]/div/main/div/div/form/div[1]/div[2]/div[7]/div[3]/div/button
		//driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/main/div/div/form/div[1]/div[2]/div[7]/div[3]/div/button")).click(); // open the Upload window using selenium    
		//Thread.sleep(20000); // wait for page load    
		//Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + "C:/Users/aylen/Documents/WillDom/Proyecto cucumber/cargaarchivos.exe"); // Give  path where the exe is saved.
		
		driver.findElement(fechaExp).sendKeys("22/03/2022");
		driver.findElement(fechVenc).sendKeys("26/03/2029");
		driver.findElement(numDocUs).sendKeys("2");
		driver.findElement(numRef).sendKeys("2");
		driver.findElement(botonGuardar).click();
		
		driver.findElement(observacion).sendKeys("nueva observacion");
		
		
		driver.findElement(By.className("MuiButtonBase-root MuiButton-root MuiButton-contained jss41 MuiButton-containedPrimary")).click();

	}

	@Then("^se envia la solicitud correctamente y muestra el mensaje$")
	public void el_estado_de_la_solicitud_es() {
		String mensaje=driver.findElement(By.className("jss79")).getText();
		Assert.assertEquals(mensaje,"Solicitud Enviada");
          
	}

}
