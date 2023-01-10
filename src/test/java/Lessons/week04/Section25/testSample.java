package Lessons.week04.Section25;

import java.io.IOException;
import java.util.ArrayList;

public class testSample {
    public static void main(String[] args) throws IOException {

        ExcelDrivenTesting2 d = new ExcelDrivenTesting2();
        ArrayList data = d.getData("Add Profile");


        for (int i = 0; i < data.size(); i++) {
            System.out.println(data.get(i));
        }

       /* driver.findElement(By.ByXPath("fhht")).sendKeys(data.get(1));*/


    }
}
