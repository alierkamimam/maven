package Lessons.week04.cucumber;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src\\test\\java\\Lessons\\week04\\cucumber",
        glue ="\\Lessons\\week04\\rahulshettyacademy\\stepDefination",
        monochrome = true,
        plugin = {"html:target/cucumber.html"})
public class TestNGTestRunner extends AbstractTestNGCucumberTests {
}
