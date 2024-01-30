package com.loop.utilities;

import java.util.List;
import java.util.Map;

public class TestExcel {

    public static void main(String[] args) {

        ExcelUtils excelUtils = new ExcelUtils("/Users/nsh/Documents/Repo/cucumber-project-b2/src/test/resources/Sample.xlsx", "Nadir");
       // System.out.println("excelUtils.getCellData(1, 2) = " + excelUtils.getCellData(3, 1));

        List<Map<String, String>> dataList = excelUtils.getDataListV2();

        for (Map<String, String> row : dataList) {
            for (Map.Entry<String, String> entry : row.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
            System.out.println("-------------------------------");
        }



    }
}
