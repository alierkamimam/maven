package Lessons.Week03.Section16.Annotation01;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BeforeAfterAnnotation {

    @Test
    public void MobileApp() {
        System.out.println("MobileApp");
        Assert.assertTrue(false);
    }

    @Test
    public void MobilePhone() {
        System.out.println("MobilePhone");
    }

    @Test
    public void WebApp() {
        System.out.println("WebApp");
    }

    @BeforeTest
    public void BeforeAnn() {
        System.out.println("I will execute first");

    }

    @AfterTest
    public void AfterAnn() {
        System.out.println("I will execute last");
    }


}
