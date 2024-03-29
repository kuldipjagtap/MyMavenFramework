package com.learnAutomation.utility;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	
	XSSFWorkbook wb;
	public ExcelDataProvider() {

		File file = new File("./TestData/Data.xlsx");

		try {
			FileInputStream fileInputStream = new FileInputStream(file);
			wb = new XSSFWorkbook(fileInputStream);
		} catch (Exception e) {
			System.out.println("Unable to print excel file"+e.getMessage());
		}		
	}

	public String getStringData(int sheetIndex, int row, int col) {

		return wb.getSheetAt(sheetIndex).getRow(row).getCell(col).getStringCellValue();
	}

	public String getStringData(String sheetName, int row, int col) {
		return wb.getSheet(sheetName).getRow(row).getCell(col).getStringCellValue();

	}
	public double getNumericData(String sheetName, int row, int col) {

		return wb.getSheet(sheetName).getRow(row).getCell(col).getNumericCellValue();
	}
}
