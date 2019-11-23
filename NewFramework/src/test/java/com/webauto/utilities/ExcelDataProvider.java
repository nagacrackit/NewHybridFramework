package com.webauto.utilities;

import java.io.File;
import java.io.FileInputStream;


import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	XSSFWorkbook wb;
	public ExcelDataProvider(){
		File f=new File("./TestData/data.xlsx");
		try {
			FileInputStream fs=new FileInputStream(f);
			wb=new XSSFWorkbook(fs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Unable to find xl file"+ e.getMessage());
		} 
	}
	
	public String getStringData(int sheetIndex,int row,int col){
		return wb.getSheetAt(0).getRow(row).getCell(col).getStringCellValue();
	}
	

}
