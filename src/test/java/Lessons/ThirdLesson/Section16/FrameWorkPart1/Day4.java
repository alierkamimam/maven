package Lessons.ThirdLesson.Section16.FrameWorkPart1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Day4 {


    @Test(dataProvider = "getData")
    public void WebLogin(String username, String password) {
        System.out.println("WebLogin");
        System.out.println(username);
        System.out.println(password);


    }

    @Parameters({"Url"})
    @Test
    public void MobileApp(String urlname) {
        System.out.println("MobileApp");
        System.out.println(urlname);
    }

    @DataProvider
    public Object[][] getData() {

        Object[][] data = new Object[3][2];


        data[0][0] = "firstsetusername";
        data[0][1] = "password";

        data[1][0] = "secondsetusername";
        data[1][1] = "secondpassword";

        data[2][0] = "seconsetusername";
        data[2][1] = "thirdpassword";
        return data;

    }
}

