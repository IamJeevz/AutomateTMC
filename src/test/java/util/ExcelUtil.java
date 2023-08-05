package util;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	public static String cellVal(String path, String sheetname,int r, int c)
	{
		try {
		FileInputStream file=new FileInputStream(path);
		XSSFWorkbook wb=new XSSFWorkbook(file);
		XSSFSheet sh=wb.getSheet(sheetname);
		XSSFCell cell=sh.getRow(r).getCell(c);
		if(cell.getCellType()==CellType.STRING)
		{
			return cell.getStringCellValue();
		}
		else {
			double val=cell.getNumericCellValue();
			int value=(int)val;
			return String.valueOf(value);
		}
		
		}
	catch(Exception e)
		{
		//to do
		}
		return null;
		
	}
	public static int cellCount(String path, String sheetname)
	{
		try {
		FileInputStream file=new FileInputStream(path);
		XSSFWorkbook wb=new XSSFWorkbook(file);
		XSSFSheet sh=wb.getSheet(sheetname);
		return sh.getLastRowNum();
		}
		catch (Exception e) {
			e.getMessage();
		}
		return 0;
		
	}
	

}
