package Lessons.FirstLesson;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FireFoxExercises {
    public static void main(String[] args) throws InterruptedException {



        WebDriver driver=new FirefoxDriver();


        driver.get("https://rahulshettyacademy.com");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        Thread.sleep(5000);
        driver.close();



    }
}
