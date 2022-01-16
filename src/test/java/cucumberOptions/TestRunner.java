package cucumberOptions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)
@CucumberOptions(features="C:\\Users\\hp\\eclipse-workspace\\javaDurgaclass\\EndtoEndProject\\src\\test\\java\\feature\\Login.feature",glue= "stepDefinations",monochrome=true,

plugin = { "pretty","json:target/JSONReports","html:target/HtmlReports","junit:target/JUnitReports/reports.xml"})


public class TestRunner extends AbstractTestNGCucumberTests

{

}
