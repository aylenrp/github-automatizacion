import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features="src/test/resources/features/registroUsuario.feature", 
		glue="stepDefinition", 
		monochrome = true, 
		tags="@smoketest", 
		plugin = { "pretty", "html:target/HtmlReports", 
				"json:target/JSONReports/cucumberreport.json", 
				"testng:target/TestNGReports/cucumberreport.xml"})

public class RunCukesTest extends AbstractTestNGCucumberTests{

}
