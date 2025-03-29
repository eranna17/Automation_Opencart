package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

		// public static
		//public -- we can access the methods wherever we want 
		// static -- we no need to create  any objects for utils class	to access these methods
		// directly we can access by using this class names
		
		public  FileInputStream fi;
		public  FileOutputStream fo;
		public  XSSFWorkbook wb;
		public  XSSFSheet sheet;
		public  XSSFSheet ws;
		public  XSSFCell cell;
		public  XSSFRow row;
		public  CellStyle style;
		
		String path;
		
		
		public ExcelUtility(String path)
		{
			this.path=path;
		}
		
		
		public  int getRowCount(String sheetName) throws IOException 
		{
			fi= new FileInputStream(path); // opening file in reading mood
			wb=	new XSSFWorkbook(fi);	
			ws = wb.getSheet(sheetName);// getting the sheet 
			int rowcount= ws.getLastRowNum();// finding the last row
			wb.close();
			fi.close();
			return rowcount;
		}
		
		public  int getCellCount(String sheetName, int rownum) throws IOException
		{
			fi= new FileInputStream(path);
			wb=new XSSFWorkbook(fi);
			ws=wb.getSheet(sheetName);
			row = ws.getRow(rownum);
			int cellcount =row.getLastCellNum();
			wb.close();
			fi.close();
			return cellcount;
		}
		
		public  String getCellData( String sheetName, int rownum, int column) throws IOException
		{
			
			fi= new FileInputStream(path);
			wb= new XSSFWorkbook(fi);
			ws = wb.getSheet(sheetName);
			row=ws.getRow(rownum);
			cell =row.getCell(column);
			
			DataFormatter formatter = new DataFormatter();
			String data;
			try
			{
				//read the excel data in 2 way and go with any one approch
				//data=cell.toString(); //1 approch
				//DataFormatter formatter = new DataFormatter();//2.approch : we can import from apache poi
				data = formatter.formatCellValue(cell);// return the formatted value of a cell as a string regarding less of cell 
				
			}
			catch (Exception e)
			{
				data =" ";
			}
			wb.close();
			fi.close();
			return data;
			
		}
		
		public  void setCellData( String sheetName, int rownum, int column , String data) throws IOException
		{
			File xlfile=  new File(path);
			if(!xlfile.exists()) // if file not exists create a new file
			{
				wb =new XSSFWorkbook();
				fo= new FileOutputStream(path);
				wb.write(fo);
			}
			
			fi = new FileInputStream(path);
			wb = new XSSFWorkbook(fi);
			
			if(wb.getSheetIndex(sheetName)==-1) // if sheet not existws then create a new sheet
				wb.createSheet(sheetName);
				sheet =wb.getSheet(sheetName);
			
			if(sheet.getRow(rownum)==null) // if row not exists then create a new row
				
				sheet.createRow(rownum);
				row = sheet.getRow(rownum);
			
			ws =wb.getSheet(sheetName);
			row =ws.getRow(rownum);
			
			cell= row.createCell(column);
			cell.setCellValue(data);
			fo= new FileOutputStream(path);
			wb.write(fo);
			wb.close();
			fi.close();
			fo.close();
		}

		
		public  void fillGreenColor(String path, String sheetName,int rownum, int column) throws IOException
		{
			
			fi= new FileInputStream(path);
			wb =new XSSFWorkbook(fi);
			ws =wb.getSheet(sheetName);
			row=ws.getRow(rownum);
			cell =row.getCell(column);
			
			style= wb.createCellStyle();
			style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
			style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			
			cell.setCellStyle(style);
			wb.write(fo);
			wb.close();
			fi.close();
			fo.close();
			
		}
		
		public void fillRedColor(String path, String sheetName,int rownum, int column) throws IOException
		{
			fi= new FileInputStream(path);
			wb =new XSSFWorkbook(fi);
			ws =wb.getSheet(sheetName);
			row=ws.getRow(rownum);
			cell =row.getCell(column);
			
			style= wb.createCellStyle();
			style.setFillForegroundColor(IndexedColors.RED.getIndex());
			style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			
			cell.setCellStyle(style);
			wb.write(fo);
			wb.close();
			fi.close();
			fo.close();
		}
		
}
