package com.bk_automation_testNG_prototype.helper.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;


import com.bk_automation_testNG_prototype.helper.logger.LoggerHelper;

public class ExcelHelper {

	private Logger log = LoggerHelper.getLogger(ExcelHelper.class);

	public Object[][] getExcelData(String excelLocation, String sheetName) {

		try {
			Object dataSets[][] = null;
			FileInputStream file = new FileInputStream(new File(excelLocation));
			// Create Workbook instance
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			// Get sheet Name from Workbook
			XSSFSheet sheet = workbook.getSheet(sheetName);

			// count number of active rows in excel sheet
			int totalRow = sheet.getLastRowNum();
            System.out.println(totalRow);
			// count active columns in row
			int totalColumn = sheet.getRow(0).getLastCellNum();

			dataSets = new Object[totalRow][totalColumn-1];

			// Iterate Through each Rows one by one.
			Iterator<Row> rowIterator = sheet.iterator();
			int i = 0;
			while (rowIterator.hasNext()) {
				i++;
				// for Every row , we need to iterator over columns
				Row row = rowIterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();
				int j = 0;
				while (cellIterator.hasNext()) {
					
					Cell cell = cellIterator.next();
					if (cell.getStringCellValue().contains("Start")) {
						i = 0;
						break;
					}
					switch (cell.getCellType()) {
					case STRING:
						dataSets[i-1][j] = cell.getStringCellValue();
						break;
					case NUMERIC:
						dataSets[i-1][j] = cell.getNumericCellValue();
						break;
					case BOOLEAN:
						dataSets[i-1][j] = cell.getBooleanCellValue();
					case FORMULA:
						dataSets[i-1][j] = cell.getCellFormula();
						break;

					default:
						System.out.println("no matching enum date type found");
						break;
					}
				}
			}
			file.close();
			return dataSets;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String[][] getDataFromSheet(String excelLocation, String sheetName) {
		String dataSets[][] = null;
			try {
				
				FileInputStream file = new FileInputStream(new File(excelLocation));
				XSSFWorkbook workbook = new XSSFWorkbook(file);
				XSSFSheet sheet = workbook.getSheet(sheetName);
				int totalRow = sheet.getLastRowNum() + 1;
				int totalColumn = sheet.getRow(0).getLastCellNum();
				dataSets = new String[totalRow - 1][totalColumn];
				for (int i = 1; i < totalRow; i++) {
					XSSFRow rows = sheet.getRow(i);
					for (int j = 0; j < totalColumn; j++) {
						XSSFCell cell = rows.getCell(j);
						System.out.println(cell.getCellType());
						switch(cell.getCellType()) {
						case STRING : dataSets[i - 1][j] = cell.getStringCellValue();
									  //System.out.println( dataSets[i - 1][j]);
									  break;
							
						case NUMERIC : String cellText = String.valueOf(cell.getNumericCellValue());
									   dataSets[i - 1][j] = cellText;
									   //System.out.println( dataSets[i - 1][j]);
									   break;
							
						case BOOLEAN : dataSets[i - 1][j] = String.valueOf(cell.getBooleanCellValue());
									   //System.out.println( dataSets[i - 1][j]);
										break;
						}

					}
				}
				return dataSets;
			} catch (Exception e) {
				System.out.println("Exception in reading Xlxs file" + e.getMessage());
				e.printStackTrace();
			}
			return dataSets;
		}

	public List<List<Object>> readExcel(String filePath, int sheetindex, String testCaseId, String runMode) {
		List<List<Object>> mainListL = new ArrayList<List<Object>>();
		try {
			FileInputStream fisL = new FileInputStream(filePath);
			Workbook bookL = WorkbookFactory.create(fisL);
			Sheet sheetL = bookL.getSheetAt(sheetindex);
			Iterator<org.apache.poi.ss.usermodel.Row> rowItrL = sheetL.rowIterator();
			while (rowItrL.hasNext()) {
				List<Object> listL = new ArrayList<Object>();
				Row rowValueL = rowItrL.next();
				Iterator<Cell> cellItrL = rowValueL.cellIterator();
				while (cellItrL.hasNext()) {
					Cell cellValueL = cellItrL.next();
					switch (cellValueL.getCellType()) {
					case STRING:
						listL.add(cellValueL.getStringCellValue());
						break;
					case NUMERIC:
						listL.add(cellValueL.getNumericCellValue());
						break;
					case FORMULA:
						listL.add(cellValueL.getCellFormula());
						break;
					case BOOLEAN:
						listL.add(cellValueL.getBooleanCellValue());
						break;
					case BLANK:
						listL.add("");
						break;
					default:
						break;
					}
				}
				if (testCaseId.equals(listL.get(0).toString()) && runMode.toLowerCase().equals(listL.get(1).toString().toLowerCase())) {
					mainListL.add(listL);
				}
			}
			// mainList.remove(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mainListL;
	}


	
	
	public void updateResult(String excelLocation, String sheetName, String testCaseName, String testStatus){
		try{
			FileInputStream file = new FileInputStream(new File(excelLocation));
			// Create Workbook instance
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			// Get sheet Name from Workbook
			XSSFSheet sheet = workbook.getSheet(sheetName);
			// count number of active rows in excel sheet
			int totalRow = sheet.getLastRowNum()+1;
			for(int i =1; i<totalRow; i++){
				XSSFRow r = sheet.getRow(i);
				String ce = r.getCell(0).getStringCellValue();
				if(ce.contains(testCaseName)){
					r.createCell(1).setCellValue(testStatus);
					file.close();
					log.info("result updated..");
					FileOutputStream out = new FileOutputStream(new File(excelLocation));
					workbook.write(out);
					out.close();
					break;
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	

}
