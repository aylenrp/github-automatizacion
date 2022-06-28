package stepDefinition;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SeleniumSteps {
	private WebDriver driver;
	private By linkAutenticacion = By.linkText("Form Authentication");
	private By usernameField = By.id("username");
	private By passwordField = By.id("password");
	private By botonLogin = By.cssSelector("#login button");
	private By statusAlert = By.id("flash");
	private By linkDropdown = By.linkText("Dropdown");
	private By dropdown = By.id("dropdown");
	private Select dropdownElement;
	private By linkHover = By.linkText("Hovers");
	private By figureBox= By.className("figure");
	private WebElement caption;
	private By boxCaption= By.className("figcaption");
	private By header = By.tagName("h5");
	private By link=By.tagName("a");
	

	@Given("^the user is in the page$")
	public void given() {
		System.setProperty("webdriver.gecko.driver", "Drivers/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://the-internet.herokuapp.com/");
	}

	// probando credenciales incorrectas
	@When("^the user do anything$")
	public void when() {
		driver.findElement(linkAutenticacion).click();
		driver.findElement(usernameField).sendKeys("tomsmith");
		driver.findElement(passwordField).sendKeys("SuperSecretPassword");
		driver.findElement(botonLogin).click();

	}

	@Then("^status autenticacion (.*)$")
	public void then(String status) {
		String mensaje = driver.findElement(statusAlert).getText();
		if (status.equals("fail")) {
			assertTrue(mensaje.contains("Your password is invalid!"), "Alert text is incorrect");

			// Assert.assertEquals(mensaje,"Your password is invalid!");
		} else {
			assertTrue(mensaje.contains("You logged into a secure area!"), "Alert text is incorrect");

			// Assert.assertEquals(mensaje,"You logged into a secure area!");
		}
		driver.close();

	}

	// probando dropdowns
	@When("^the user select dropdown and select an (.*)$")
	public void Dropdowns(String option) {
		driver.findElement(linkDropdown).click();
		dropdownElement = new Select(driver.findElement(dropdown));
		dropdownElement.selectByVisibleText(option);
	}

	@Then("^the status test (.*)$")
	public void Status(String option) {
		List<WebElement> selectedElements = dropdownElement.getAllSelectedOptions();
		// selectedElements.stream().map(e->e.getText()).collect(Collectors.toList());
		assertTrue(selectedElements.stream().map(e -> e.getText()).collect(Collectors.toList()).contains(option),
				"Option not selected");
		driver.close();

	}

	// probando hovers
	@When("^the user click hover and hover it (.*)$")
	public void Hovers(int index) {
		driver.findElement(linkHover).click();
		WebElement figure = driver.findElements(figureBox).get(index-1);
        Actions actions = new Actions(driver);
        actions.moveToElement(figure).perform();
        
	}

	@Then("^status test hover$")
	public void StatusTest() {
		assertTrue(caption.isDisplayed(), "Caption not displayed");
		assertEquals(caption.findElement(header).getText(), "name: user1", "Caption title incorrect");
        assertEquals(caption.findElement(link).getAttribute("href"), "View profile", "Caption link text incorrect");
        assertTrue(caption.findElement(link).getText().endsWith("/users/1"), "Link incorrect");
		driver.close();

	}

}
