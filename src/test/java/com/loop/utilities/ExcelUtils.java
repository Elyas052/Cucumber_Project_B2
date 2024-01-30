package com.loop.utilities;

import io.cucumber.java.an.E;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Utility class for interacting with Excel files. Provides methods to read and write data.
 */
public class ExcelUtils {

    private final Sheet workSheet;
    private final Workbook workBook;
    private final String path;

    private static final Logger LOG = LogManager.getLogger();

    /**
     * Constructor to initialize the ExcelUtils with the given file path and sheet name.
     *
     * @param path      Path of the Excel file
     * @param sheetName Name of the sheet within the Excel file
     */
    public ExcelUtils(String path, String sheetName) {
        this.path = path;
        try {
            // Open Excel file
            FileInputStream ExcelFile = new FileInputStream(path);
            // Access the required test data sheet
            workBook = WorkbookFactory.create(ExcelFile);
            workSheet = workBook.getSheet(sheetName);
        } catch (Exception e) {
            LOG.error(e.getMessage());
            throw new RuntimeException();
        }
    }

    /**
     * Gets the data of a specific cell in the Excel sheet.
     *
     * @param rowNum Row number (0-based index)
     * @param colNum Column number (0-based index)
     * @return Data of the specified cell
     */
    public String getCellData(int rowNum, int colNum) {
        Cell cell;
        try {
            cell = workSheet.getRow(rowNum).getCell(colNum);
            String cellData = cell.toString();
            return cellData;
        } catch (Exception e) {
            LOG.error(e.getMessage());
            throw new RuntimeException();
        }
    }

    /**
     * Gets the number of columns in the Excel sheet.
     *
     * @return Number of columns
     */
    public int columnCount() {
        return workSheet.getRow(0).getLastCellNum();
    }

    /**
     * Gets the number of rows in the Excel sheet.
     *
     * @return Number of rows
     */
    public int rowCount() {
        return workSheet.getLastRowNum();
    }

    /**
     * Gets the data from the Excel sheet and returns it as a 2D array.
     *
     * @return 2D array containing the sheet data
     */
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

    /**
     * Gets the data from the Excel sheet and returns it as a list of maps.
     * Each map represents a row where column names are keys and cell values are values.
     *
     * @return List of maps containing the sheet data
     */
    public List<Map<String, String>> getDataList() {
        List<String> columns = getColumnsNames();
        List<Map<String, String>> data = new ArrayList<>();
        for (int i = 1; i < rowCount(); i++) {
            Row row = workSheet.getRow(i);
            Map<String, String> rowMap = new HashMap<>();
            for (Cell cell : row) {
                int columnIndex = cell.getColumnIndex();
                rowMap.put(columns.get(columnIndex), cell.getCellStyle().toString());
            }
            data.add(rowMap);
        }
        return data;
    }

    /**
     * Gets the column names from the Excel sheet.
     *
     * @return List of column names
     */
    public List<String> getColumnsNames() {
        List<String> columns = new ArrayList<>();
        for (Cell cell : workSheet.getRow(0)) {
            columns.add(cell.toString());
        }
        return columns;
    }

    /**
     * Sets the data of a specific cell in the Excel sheet.
     *
     * @param value  Data to be set
     * @param rowNum Row number (0-based index)
     * @param colNum Column number (0-based index)
     */
    public void setCellData(String value, int rowNum, int colNum) {
        Cell cell;
        Row row;
        try {
            row = workSheet.getRow(rowNum);
            cell = row.getCell(colNum);
            if (cell == null) {
                cell = row.createCell(colNum);
                cell.setCellValue(value);
            } else {
                cell.setCellValue(value);
            }
            FileOutputStream fileOut = new FileOutputStream(path);
            workBook.write(fileOut);
            fileOut.close();
        } catch (Exception e) {
            LOG.error(e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Unable to set cell value.");
        }
    }

    /**
     * Sets the data of a specific cell in the Excel sheet using column name and row number.
     *
     * @param value      Data to be set
     * @param columnName Column name
     * @param row        Row number (0-based index)
     */
    public void setCellData(String value, String columnName, int row) {
        int column = getColumnsNames().indexOf(columnName);
        setCellData(value, row, column);
    }

    /**
     * Gets the data from the Excel sheet and returns it as a list of maps.
     * This version handles different cell types and converts them to string values.
     *
     * @return List of maps containing the sheet data
     */
    public List<Map<String, String>> getDataListV2() {
        List<Map<String, String>> data = new ArrayList<>();
        List<String> columns = getColumnsNames();

        for (int i = 1; i <= rowCount(); i++) {
            Row row = workSheet.getRow(i);
            if (row == null) continue; // Skip empty rows

            Map<String, String> rowMap = new HashMap<>();
            for (int j = 0; j < columnCount(); j++) {
                Cell cell = row.getCell(j);
                String cellValue = "";

                if (cell != null) {
                    switch (cell.getCellType()) {
                        case STRING:
                            cellValue = cell.getStringCellValue();
                            break;
                        case NUMERIC:
                            if (DateUtil.isCellDateFormatted(cell)) {
                                cellValue = cell.getDateCellValue().toString();
                            } else {
                                cellValue = Double.toString(cell.getNumericCellValue());
                            }
                            break;
                        case BOOLEAN:
                            cellValue = Boolean.toString(cell.getBooleanCellValue());
                            break;
                        case FORMULA:
                            cellValue = cell.getCellFormula();
                            break;
                        case BLANK:
                            cellValue = "";
                            break;
                        default:
                            cellValue = cell.toString();
                            break;
                    }
                }

                rowMap.put(columns.get(j), cellValue);
            }
            data.add(rowMap);
        }
        return data;
    }
}
