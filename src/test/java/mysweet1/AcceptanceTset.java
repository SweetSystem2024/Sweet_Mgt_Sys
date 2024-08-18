package mysweet1;


import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;




@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/use_cases",
    plugin = {"summary", "html:target/cucumber/report.html"},
    monochrome = true,
    snippets = SnippetType.UNDERSCORE, 
    glue = "mysweet1"
)








public class AcceptanceTset {

}
