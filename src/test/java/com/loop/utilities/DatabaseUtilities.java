package com.loop.utilities;

import java.sql.*;
import java.util.*;

public class DatabaseUtilities {
    //Declaring at class level so all methods can access
    private static Connection con;
    private static Statement stm;
    private static ResultSet rs;
    private static ResultSetMetaData rsmd;

    /**
     * Create Connection by jdbc url and username , password provided
     * @param url jdbc url for any database
     * @param username username for database
     * @param password password for database
     */
    public static void createConnection(String url, String username, String password) {
        try {
            con = DriverManager.getConnection(url, username, password);
            System.out.println("Connection successful!");
        } catch (Exception e) {
            System.out.println("Connection failed!" + e.getMessage());
        }
    }
    /**
     * Create connection method, just checking one connection successful or not
     */
    public static void createConnection() {
        String url = "jdbc:postgresql://35.222.62.70:5432/postgres";
        String username = "tstadmin";
        String password = "hoxBam-jaghuj-7cette";
        createConnection(url, username, password);
    }
    /**
     * Run the sql query provided and return ResultSet object
     * @param sql the query to run
     * @return ResultSet object that contains data
     */
    public static ResultSet runQuery(String sql) {   //DatabaseUtilities.runQuery("select * from employees");
        try {
            stm = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stm.executeQuery(sql); //Setting the value of ResultSet object
            rsmd = rs.getMetaData();  //Setting the value of ResultSetMetaData for reuse
        } catch (Exception e) {
            System.out.println("Running query failed!" + e.getMessage());
        }
        return rs;
    }
    /**
     * Destroy method to clean up all the resources after being used
     */
    public static void destroy() {
        // We have to check if we have THE VALID OBJECT FIRST BEFORE CLOSING THE RESOURCE
        // BECAUSE WE CAN NOT TAKE ACTION ON AN OBJECT THAT DOES NOT EXIST
        try {
            if (rs != null) rs.close();
            if (stm != null) stm.close();
            if (con != null) con.close();
        } catch (Exception e) {
            System.out.println("Closing resources failed!" + e.getMessage());
        }
    }
    /**
     * This method will reset the cursor to before first location
     */
    public static void resetCursor() {
        try {
            rs.beforeFirst();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * Find out the row count
     * @return row count of this ResultSet
     */
    public static int getRowCount() {

        int rowCount = 0;
        try {
            rs.last();
            rowCount = rs.getRow();
        } catch (Exception e) {
            System.out.println("ERROR OCCURRED WHILE GETTING ROW COUNT " + e.getMessage());
        } finally {
            resetCursor();
        }
        return rowCount;
    }
    /**
     * Find out the column count
     * @return column count of this ResultSet
     */
    public static int getColumnCount() {
        int columnCount = 0;
        try {
            columnCount = rsmd.getColumnCount();
        } catch (Exception e) {
            System.out.println("ERROR OCCURRED WHILE GETTING COLUMN COUNT " + e.getMessage());
        }
        return columnCount;
    }
    /**
     * Get all the column names as a list
     * @return List<String>
     */
    public static List<String> getAllColumnNamesAsList() {
        List<String> columnNameLst = new ArrayList<>();
        try {
            for (int colIndex = 1; colIndex <= getColumnCount(); colIndex++) {
                //String columnName = rsmd.getColumnName(colIndex);
                //columnNameLst.add(columnName);
                columnNameLst.add(rsmd.getColumnName(colIndex));
            }
        } catch (Exception e) {
            System.out.println("ERROR OCCURRED WHILE getAllColumnNamesAsList " + e.getMessage());
        }
        return columnNameLst;
    }
    /**
     * Getting entire row of data in a List of String
     * @param rowNum row number to get as a list
     * @return row data as List of String
     */
    public static List<String> getRowDataAsList(int rowNum) {
        List<String> rowDataAsLst = new ArrayList<>();
        int colCount = getColumnCount();
        try {
            rs.absolute(rowNum);
            for (int colIndex = 1; colIndex <= colCount; colIndex++) {
                String cellValue = rs.getString(colIndex);
                rowDataAsLst.add(cellValue);
            }
        } catch (Exception e) {
            System.out.println("ERROR OCCURRED WHILE getRowDataAsList " + e.getMessage());
        } finally {
            resetCursor();
        }
        return rowDataAsLst;
    }
    /**
     * Getting the cell value according to row num and column index
     * @param rowNum row number to get the data from
     * @param columnIndex column number to get the data from
     * @return the value in String at that location
     */
    public static String getCellValue(int rowNum, int columnIndex) {
        String cellValue = "";
        try {
            rs.absolute(rowNum);
            cellValue = rs.getString(columnIndex);
        } catch (Exception e) {
            System.out.println("ERROR OCCURRED WHILE getCellValue " + e.getMessage());
        } finally {
            resetCursor();
        }
        return cellValue;
    }
    /**
     * Getting the cell value according to row num and column name
     * @param rowNum row number to get the data from
     * @param columnName column Name to get the data from
     * @return the value in String at that location
     */
    public static String getCellValue(int rowNum, String columnName) {
        String cellValue = "";
        try {
            rs.absolute(rowNum);
            cellValue = rs.getString(columnName);
        } catch (Exception e) {
            System.out.println("ERROR OCCURRED WHILE getCellValue " + e.getMessage());
        } finally {
            resetCursor();
        }
        return cellValue;
    }
    /**
     * Get First Cell Value at First row First Column
     */
    public static String getFirstRowFirstColumn() {
        return getCellValue(1, 1);
    }
    /**
     * Getting entire column data as list according to column number
     * @param columnNum column number to get all data
     * @return List object that contains all rows of that column
     */
    public static List<String> getColumnDataAsList(int columnNum) {
        List<String> columnDataLst = new ArrayList<>();
        try {
            rs.beforeFirst(); // make sure the cursor is at before first location
            while (rs.next()) {
                String cellValue = rs.getString(columnNum);
                columnDataLst.add(cellValue);
            }
        } catch (Exception e) {
            System.out.println("ERROR OCCURRED WHILE getColumnDataAsList " + e.getMessage());
        } finally {
            resetCursor();
        }
        return columnDataLst;
    }
    /**
     * Getting entire column data as list according to column Name
     * @param columnName column name to get all data
     * @return List object that contains all rows of that column
     */
    public static List<String> getColumnDataAsList(String columnName) {
        List<String> columnDataLst = new ArrayList<>();
        try {
            rs.beforeFirst(); // make sure the cursor is at before first location
            while (rs.next()) {
                String cellValue = rs.getString(columnName);
                columnDataLst.add(cellValue);
            }
        } catch (Exception e) {
            System.out.println("ERROR OCCURRED WHILE getColumnDataAsList " + e.getMessage());
        } finally {
            resetCursor();
        }
        return columnDataLst;
    }
    /**
     * Display all data from the ResultSet Object
     */
    public static void displayAllData() {
        int columnCount = getColumnCount();
        resetCursor();
        try {
            while (rs.next()) {
                for (int colIndex = 1; colIndex <= columnCount; colIndex++) {
                    //System.out.print( rs.getString(colIndex) + "\t" );
                    System.out.printf("%-25s", rs.getString(colIndex));
                }
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println("ERROR OCCURRED WHILE displayAllData " + e.getMessage());
        } finally {
            resetCursor();
        }
    }
    /**
     * Save entire row data as Map<String, String>
     * @param rowNum row number
     * @return Map object that contains key value pair
     * key : column name
     * value : cell value
     */
    public static Map<String, String> getRowMap(int rowNum) {
        Map<String, String> rowMap = new LinkedHashMap<>();
        int columnCount = getColumnCount();
        try {
            rs.absolute(rowNum);
            for (int colIndex = 1; colIndex <= columnCount; colIndex++) {
                String columnName = rsmd.getColumnName(colIndex);
                String cellValue = rs.getString(colIndex);
                rowMap.put(columnName, cellValue);
            }
        } catch (Exception e) {
            System.out.println("ERROR OCCURRED WHILE getRowMap " + e.getMessage());
        } finally {
            resetCursor();
        }
        return rowMap;
    }
    /**
     * We know how to store one row as map object
     * Now Store All rows as List of Map object
     * @return List of Map object that contain each row data as Map<String,String>
     */
    public static List<Map<String, String>> getAllRowsAsListOfMap() {
        List<Map<String, String>> allRowLstOfMap = new LinkedList<>();
        int rowCount = getRowCount();
        //Move from first row till last row
        //Get each row as map object and add it to the list
        for (int rowIndex = 1; rowIndex <= rowCount; rowIndex++) {
            Map<String, String> rowMap = getRowMap(rowIndex);
            allRowLstOfMap.add(rowMap);
        }
        resetCursor();
        return allRowLstOfMap;
    }
}