package Lessons.week04.Section25;

import java.io.IOException;
import java.util.ArrayList;

public class ExcelDrivenTesting3 {
    public static void main(String[] args) throws IOException {
        solveNumericTypes solveNumericTypes=new solveNumericTypes();
         ArrayList a=solveNumericTypes.getData("Add Profile");

        for (int i = 0; i <a.size() ; i++) {
            System.out.println(a.get(i));
        }
    }
}
