package com.loop.utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.*;

public class ExcelUtilities {
    private Sheet sheet;
    private Workbook workbook;
    private String path;
    private static final Logger LOG = LogManager.getLogger();

    public ExcelUtilities(String path, String sheetName) {
        this.path = path;
        try {
            //Opening Excel file
            FileInputStream excelFile = new FileInputStream(path);
            //Accessing the required test data sheet
            workbook = WorkbookFactory.create(excelFile);
            sheet = workbook.getSheet(sheetName);
        } catch (Exception e) {
            LOG.error(e.getMessage());
            throw new RuntimeException();
        }
    }

    public String getCellData(int rowNum, int colNum) {
        Cell cell;
        try {
            cell = sheet.getRow(rowNum).getCell(colNum);
            return cell.toString();
        } catch (Exception e) {
            LOG.error(e.getMessage());
            throw new RuntimeException();
        }
    }

    public int columnCount() {
        return sheet.getRow(0).getLastCellNum();
    }

    public int rowCount() {
        return sheet.getLastRowNum();
    }

    public String[][] getDataArray() {
        String[][] data = new String[rowCount()][columnCount()];
        for (int i = 0; i < rowCount(); i++) {
            for (int j = 0; j < columnCount(); j++) {
                String value = getCellData(i, j);
                data[i][j] = value;
            }
        }
        return data;
    }

    public List<Map<String, String>> getDataList() {
        // get all columns
        List<String> columns = getColumnsNames();
        // this will be returned
        List<Map<String, String>> data = new ArrayList<>();

        for (int i = 1; i < rowCount(); i++) {
            // get each row
            Row row = sheet.getRow(i);
            // create map of the row using the column and value
            // column map key, cell value --> map bvalue
            Map<String, String> rowMap = new HashMap<String, String>();
            for (Cell cell : row) {
                int columnIndex = cell.getColumnIndex();
                rowMap.put(columns.get(columnIndex), cell.getCellStyle().toString());
            }
            data.add(rowMap);
        }
        return data;
    }

    public List<String> getColumnsNames() {
        List<String> columns = new ArrayList<>();

        for (Cell cell : sheet.getRow(0)) {
            columns.add(cell.toString());
        }
        return columns;
    }

    public void setCellData(String value, int rowNum, int colNum) {
        Cell cell;
        Row row;

        try {
            row = sheet.getRow(rowNum);
            cell = row.getCell(colNum);

            if (cell == null) {
                cell = row.createCell(colNum);
                cell.setCellValue(value);
            } else {
                cell.setCellValue(value);
            }
            FileOutputStream fileOut = new FileOutputStream(path);
            workbook.write(fileOut);

            fileOut.close();
        } catch (Exception e) {
            LOG.error(e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Unable to set cell value.");
        }
    }

    public void setCellData(String value, String columnName, int row) {
        int column = getColumnsNames().indexOf(columnName);
        setCellData(value, row, column);
    }
}