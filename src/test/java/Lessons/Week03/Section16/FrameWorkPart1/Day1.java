package Lessons.Week03.Section16.FrameWorkPart1;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Day1 {

    @Parameters({  "URL" })
    @Test
    public void WebLoginCarLoan(@Optional String urlname) {
        //Selenium
        System.out.println("WebLoginCarLoan");
        System.out.println(urlname);
    }

    @Test
    public void MobileLoginCarLoan() {
        //Selenium
        System.out.println("MobileLoginCarLoan");
    }

    @Test
    public void LoginAPICarLoan() {
        //Selenium
        System.out.println("LoginAPICarLoan");
    }
}

