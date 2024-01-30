package com.loop.utilities;

import java.util.List;
import java.util.Map;

/**
 * A test class demonstrating the usage of ExcelUtils to read data from an Excel file.
 */
public class TestExcel {

    public static void main(String[] args) {

        // Creating an instance of ExcelUtils with the Excel file path and sheet name
        ExcelUtils excelUtils = new ExcelUtils("Users/shely/OneDrive/Рабочий стол/Sample.xlsx", "Nadir");

        // Uncomment the following line to print the data of a specific cell
        // System.out.println("excelUtils.getCellData(3, 1) = " + excelUtils.getCellData(3, 1));

        // Getting the data from the Excel sheet as a list of maps
        List<Map<String, String>> dataList = excelUtils.getDataListV2();

        // Printing each row's data in the console
        for (Map<String, String> row : dataList) {
            for (Map.Entry<String, String> entry : row.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
            System.out.println("-------------------------------");
        }
    }
}
