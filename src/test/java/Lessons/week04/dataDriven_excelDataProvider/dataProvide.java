package Lessons.week04.dataDriven_excelDataProvider;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class dataProvide {


    @Test(dataProvider = "driveTest")
    public void testCaseData(String greeting, String communication, String id) {

        System.out.println(greeting + communication + id);

    }


    //   Object[][] data = {{"hello", "text", "1"}, {"bye", "message", "143"}, {"solo", "call", "453"}};
    //every row of Excel should be sent to 1 array
    //  return data;


    @DataProvider(name = "driveTest")
    public Object[][] getData() throws IOException {
        FileInputStream fis = new FileInputStream("C:\\Users\\Ali Erkam İMAM\\Documents\\excelfile\\Book1.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheetAt(0);
        int rowCount = sheet.getPhysicalNumberOfRows();
        XSSFRow row = sheet.getRow(0);
        int colcount = row.getLastCellNum();
        Object Data[][] = new Object[rowCount - 1][colcount];

        for (int i = 0; i < rowCount - 1; i++) {

            row = sheet.getRow(i + 1);

            for (int j = 0; j < colcount; j++) {

                System.out.println( row.getCell(j));

            }

        }

        return Data;
    }
}
