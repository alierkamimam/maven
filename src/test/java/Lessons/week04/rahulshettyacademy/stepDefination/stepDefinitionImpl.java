package Lessons.week04.rahulshettyacademy.stepDefination;

import Lessons.Week03.Section19.TestComponents.BaseTest;
import io.cucumber.java.en.Given;

import java.io.IOException;

public class stepDefinitionImpl extends BaseTest {
    @Given("I landed on Ecommerce Page")
    public void I_landed_on_Ecommerce_Page() throws IOException {
        launchApplication();
    }

}
