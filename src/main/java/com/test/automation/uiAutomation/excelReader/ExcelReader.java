package com.test.automation.uiAutomation.excelReader;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	public String path;
	public FileInputStream fis;
	public XSSFWorkbook workbook;

	public ExcelReader(String path) {
		this.path = path;
		try {
			fis = new FileInputStream(path);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String[][] getDataFromSheet(String sheetName, String ExcelName){
		String[][] dataset = null;
		try{
			
			XSSFSheet sheet  = workbook.getSheet(sheetName);
			int totalRow = sheet.getLastRowNum() + 1;
			
			int totalColumn = sheet.getRow(0).getLastCellNum();
			
			dataset = new String[totalRow -1][totalColumn];
			 
		
			/*for(int i =1; i < totalRow; i++){
				XSSFRow row = sheet.getRow(i);
				
				for(int j=0; j< totalColumn; j++){
					XSSFCell cell = row.getCell(j);
					
					if(cell.getCellType() == cell.CELL_TYPE_STRING){
						dataset[i - 1][j] = cell.getStringCellValue();
						}
						else if(cell.getCellType() == cell.CELL_TYPE_NUMERIC){
							String cellText = String.valueOf(cell.getNumericCellValue());
									dataset[i - 1][j] = cellText;
						}else{
							dataset[i - 1][j] = String.valueOf(cell.getBooleanCellValue());
						}
					}
				
				}
				
			}*/
			
		}catch(Exception e)
	{
			
		}return dataset;

}}
