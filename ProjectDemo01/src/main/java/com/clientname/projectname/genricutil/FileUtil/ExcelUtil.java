package com.clientname.projectname.genricutil.FileUtil;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {
	private static final String excelPath = "\\Users\\KAIF KHAN\\Desktop\\TestData\\TestDAtaFB.xlsx";
	public String readDataFromExcel(String sheet, int rowIndex, int cellIndex)
			throws EncryptedDocumentException, IOException {
		FileInputStream fIS = new FileInputStream(excelPath);
		Workbook wb = WorkbookFactory.create(fIS);
		String data = wb.getSheet(sheet).getRow(rowIndex).getCell(cellIndex).getStringCellValue().toString();
		fIS.close();
		wb.close();
		return data;
	}

	public void writeDataInExcel(String sheet, int rowIndex, int cellIndex, String data)
			throws EncryptedDocumentException, IOException {
		FileInputStream fIS = new FileInputStream(excelPath);
		Workbook wb = WorkbookFactory.create(fIS);
		wb.getSheet(sheet).createRow(rowIndex).createCell(cellIndex).setCellValue(data);
		FileOutputStream fOS = new FileOutputStream(excelPath);
		wb.write(fOS);
		fOS.close();
		fIS.close();
		wb.close();
	}

	public int getrowCount(String sheet) throws EncryptedDocumentException, IOException {
		FileInputStream fIS = new FileInputStream(excelPath);
		Workbook wb = WorkbookFactory.create(fIS);
		int lastRowNum = wb.getSheet(sheet).getLastRowNum();
		wb.close();
		fIS.close();
		return lastRowNum;
	}

	public int getCellCount(String sheet) throws EncryptedDocumentException, IOException {
		FileInputStream fIS = new FileInputStream(excelPath);
		Workbook wb = WorkbookFactory.create(fIS);
		int lastCellNum = wb.getSheet(sheet).getRow(0).getLastCellNum();
		wb.close();
		fIS.close();
		return lastCellNum;
	}

}
