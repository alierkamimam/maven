package Lessons.ThirdLesson.Section16.Annotation01;

import org.testng.annotations.*;

public class BeforeAfterSuitAnnotation {
    @BeforeClass
    public void BeforeClass(){
        System.out.println("before executing any methods in the class");
    }
    @BeforeSuite
    public void BeforeSuit() {
        System.out.println("I am number one");
    }

    @BeforeTest
    public void BeforeAnn() {
        System.out.println("I will execute first");

    }

    @BeforeMethod
    public void beforeEvery(){
        System.out.println("I will execute before every test method in day 3 class");
    }

    @Test(timeOut = 4000)
    public void MobileApp() {
        System.out.println("MobileApp");
    }


    @Test(dependsOnMethods = {"WebApp"})
    public void MobilePhone() {
        System.out.println("MobilePhone");
    }
    @Test
    public void WebApp() {
        System.out.println("WebApp");
    }

    @Test(enabled = false)
    public void APIcarLoan(){
        System.out.println("APIlogincar");
    }

    @AfterClass
    public void AfterClass(){
        System.out.println("after executing any methods in the class");
    }

    @AfterMethod
    public void AfterEvery(){
        System.out.println("I will execute after every test method in day 3 class");
    }
    @AfterTest
    public void AfterAnn() {
        System.out.println("I will execute last");
    }

    @AfterSuite
    public void AfterSuit() {
        System.out.println("I am the number one from last");
    }
}
