package Lessons.Week01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class enterWikipedia {
    public static void main(String[] args) {

        //We create driver objects
        WebDriver driver = new ChromeDriver();
        //Enter wikipedia webpage
        driver.get("https://www.wikipedia.org/");

        //finding searching element and then typing 'Turkcell' and enter
        driver.findElement(By.xpath("//input[@id='searchInput']")).sendKeys("Turkcell \n");

        //finding 'history' element and then click
        driver.findElement(By.className("sidebar-toc-text")).click();
        //finding first paragraph and then take this paragraph with getText()
        // method and assign to paragraph of string
         String paragraph = driver.findElement(By.xpath("(//p[contains(text(),'n')])[3]")).getText();
         //closed driver.
        driver.close();

        //is split with whitespace and then output taken
        String[] a = paragraph.split(" ");
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }

    }


}


