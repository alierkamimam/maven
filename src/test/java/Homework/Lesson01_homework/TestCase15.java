package Homework.Lesson01_homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class TestCase15{
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2fTestComplete12%2fWebOrders%2fDefault.aspx");
        //Valid username
        driver.findElement(By.xpath("//input[@id=\"ctl00_MainContent_username\"]")).sendKeys("Tester");
        //Invalid username
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
        //click the login button
        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']")).click();
        Thread.sleep(1);
        //click 'Order' Button
        driver.findElement(By.xpath("//a[normalize-space()='Order']")).click();
        Thread.sleep(1000);


        driver.findElement(By.xpath("(//option[@value='ScreenSaver'])[1]")).click();


        driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity")).clear();
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity")).sendKeys("90");

        driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtUnitPrice")).clear();
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtUnitPrice")).sendKeys("100");

        driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtDiscount")).clear();
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtDiscount")).sendKeys("20");

        driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName")).sendKeys("Ali Erkam Imam");
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2")).sendKeys("Pasa");
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3")).sendKeys("Istanbul");
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4")).sendKeys("Turkiye");

        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5")).sendKeys("06300");

        driver.findElement(By.xpath("(//input[@id='ctl00_MainContent_fmwOrder_cardList_0'])[1]")).click();

        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox6']")).sendKeys("159753852456");

        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox1']")).sendKeys("88/44");

        driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton")).click();
        //driver.findElement(By.id("ctl00_logout")).click();
        //Thread.sleep(2000);

        String url=driver.getCurrentUrl();


        /*if (url.equals("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2fTestComplete12%2fWebOrders%2fDefault.aspx")){
            System.out.println("Test passed");
        }else System.out.println("Test failed");*/
        Assert.assertEquals(driver.getTitle(), "Web Orders Login");
        System.out.println("Test passed");
        driver.quit();
    }
}
