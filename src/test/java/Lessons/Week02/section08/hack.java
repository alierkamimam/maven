package Lessons.Week02.section08;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class hack {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://web.whatsapp.com/");
        Thread.sleep(15000);


        driver.findElement(By.xpath("//*[@id=\"side\"]/div[1]/div/div/div[2]/div/div[2]")).sendKeys("Etka Berk Orman\n");
        Thread.sleep(3000);

        for (int i = 0; i <100 ; i++) {
            driver.findElement(By.xpath(" //p[@class='selectable-text copyable-text']")).sendKeys("YOU ARE HACKED\n");
        }





    }
}
