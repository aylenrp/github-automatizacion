package stepDefinition;

import java.util.concurrent.TimeUnit;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	WebDriver driver;

	@Given("^un usuario accede al portal$")
	public void accedePortal() {
		System.setProperty("webdriver.gecko.driver", "Drivers/geckodriver.exe"); //driver para firefox
		driver = new FirefoxDriver();
		//System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe"); //driver para chrome
	    //driver = new ChromeDriver();
		
		driver.navigate().to("https://sso.test.vue.gov.py/auth/realms/develop/protocol/openid-connect/auth?client_id=react-app&redirect_uri=http%3A%2F%2Fwildfly-codium.vue.gov.py%2Fportal%2Fhome&state=19eaf247-8f1a-4015-820d-58076de995bb&response_mode=fragment&response_type=code&scope=openid&nonce=a355b893-3bd9-4a1c-a28b-ed6551647e89");
		
		driver.manage().window().maximize(); //maximizar browser
		driver.manage().window().setSize(new Dimension (375, 812));
		Point target = new Point(100, 100);
		driver.manage().window().setPosition(target);
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

	}

	@When("^escribe el usuario (.*)$")
	public void escribeUsuario(String username) throws InterruptedException {
		driver.findElement(By.id("username")).sendKeys(username);
 
		Thread.sleep(2000); //para que se quede un rato antes de continuar
	}

	@When("^escribe la contrasenna (.*)$")
	public void escribeContraseñaCorrecta(String password) throws InterruptedException {
		driver.findElement(By.id("password")).click();
		driver.findElement(By.id("password")).sendKeys(password);
		
		Thread.sleep(2000); //para que se quede un rato antes de continuar
	}
	
	@When("^da click en aceptar$")
	public void clickAceptar() {
		driver.findElement(By.className("mdc-button__label")).click();
	}

	@Then("^el estado de la autenticacion es (.*)$")
	public void autenticaionCorrecta(String status) throws InterruptedException {
		String url = driver.getCurrentUrl();
		if(url.equals("http://wildfly-codium.vue.gov.py/portal/home")) {
			Assert.assertEquals(status, "Success");
			Thread.sleep(2000);
		}else{
			String title = driver.findElement(By.className("kc-feedback-text")).getText();
			Assert.assertEquals(title, "Usuario o contraseña inválidos.");
			Thread.sleep(2000);
		}
		//String title = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div/h3")).getText();
		//String title = driver.findElement(By.className("MuiTypography-root MuiTypography-h3")).getText();
        driver.close();
        //driver.close();
	}
}

