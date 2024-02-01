package com.loop.utilities;

public class TestExcel {
    public static void main(String[] args) {
        String path = "C:\\Users\\ahmad\\OneDrive\\Desktop\\testExcel.xlsx";
        ExcelUtilities excelUtilities = new ExcelUtilities(path, "testExcel");
        System.out.println(excelUtilities.getCellData(1, 1));
    }
}