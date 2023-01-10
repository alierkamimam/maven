package Lessons.week04.Section25;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class solveNumericTypes {


    public ArrayList<String> getData(String testCaseName) throws IOException {

        ArrayList<String> a = new ArrayList<>();


        FileInputStream fis = new FileInputStream("C:\\Users\\Ali Erkam İMAM\\Documents\\excelfile\\Kitap1.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        int sheets = workbook.getNumberOfSheets();

        for (int i = 0; i < sheets; i++) {
            if (workbook.getSheetName(i).equalsIgnoreCase("TestData")) {
                XSSFSheet sheet = workbook.getSheetAt(i);

                //Identify Testcases column by scanning the entire 1st row

                Iterator<Row> rows = sheet.iterator();//sheet is collecting of rows
                Row firstRow = rows.next();
                Iterator<Cell> ce = firstRow.cellIterator();//row is collection of cells
                int k = 0;
                int column = 0;
                while (ce.hasNext()) {
                    Cell value = ce.next();
                    if (value.getStringCellValue().equalsIgnoreCase("TestCases ")) {
                        //desired column

                        column = k;
                    }
                    k++;

                }
                System.out.println(column);

                //once column is identified the scan entire testcases column to identify purchase testcase row

                while (rows.hasNext()) {

                    Row r = rows.next();
                    if (r.getCell(column).getStringCellValue().equalsIgnoreCase(testCaseName)) {

                        //after you grab purchase testcase row=pull all the data of that row and feed into test

                        Iterator<Cell> cv = r.cellIterator();
                        while (cv.hasNext()) {

                            Cell c=cv.next();
                            if (c.getCellType()== CellType.STRING){
                                a.add(c.getStringCellValue());
                            }else
                                a.add(NumberToTextConverter.toText(c.getNumericCellValue()));


                               // a.add(String.valueOf(c.getNumericCellValue()));



                        }
                    }
                }
            }
        }
        return a;
    }
}
