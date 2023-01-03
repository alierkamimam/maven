package Lessons.FirstLesson;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class EdgeBrowserExercises {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new EdgeDriver();

        driver.get("https://rahulshettyacademy.com");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        Thread.sleep(5000);

        driver.close();
    }
}
