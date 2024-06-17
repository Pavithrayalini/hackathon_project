package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;

 
public class ExcelUtils {
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook xb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static CellStyle style;  
	
	public static void setCellData(String xlfile,String xlsheet,int rownum,int colnum,String data) throws IOException
	{
		fi = new FileInputStream(xlfile);
	    xb = new XSSFWorkbook(fi);
	    ws = xb.getSheet(xlsheet);
	    // Check if the row exists, and create one if it doesn't exist
	    row = ws.getRow(rownum);
	    if (row == null) {
	        row = ws.createRow(rownum);
	    }
	    // Create a cell in the row and set its value
	    cell = row.createCell(colnum);
	    cell.setCellValue(data);
	    // Write the changes back to the file
	    FileOutputStream fo = new FileOutputStream(xlfile);
	    xb.write(fo);
	    // Close all the resources to prevent memory leaks
	    xb.close();
	    fi.close();
	    fo.close();
	}
	
	public static void createExcel() throws IOException {
	    // Define the path to the Excel file
	    String file = System.getProperty("user.dir") + "\\OutputData\\Exceloutputfile.xlsx";
	    // Create a file output stream to write to the Excel file
	    FileOutputStream fo = new FileOutputStream(file);
	    // Create a new Excel workbook
	    XSSFWorkbook xb = new XSSFWorkbook();
	    // Create a new sheet named "profile"
	    XSSFSheet sheet1 = xb.createSheet("Course details");
	    XSSFSheet sheet2 = xb.createSheet("Language and levels");
	    Font font = xb.createFont();//creating
		font.setBold(true);//setting font as Bold
		CellStyle style = xb.createCellStyle();//creating cellStyle
		style.setFont(font);//Applying cell style as Bold
	    // Create the first row in the sheet
	    XSSFRow rowSheet1 = sheet1.createRow(0);
	    XSSFRow rowSheet2 = sheet2.createRow(0);
	    // Create cells for "NAME" and "EMAIL"
	    XSSFCell course_name = rowSheet1.createCell(0);
	    XSSFCell title = rowSheet1.createCell(1);
	    // Create cells for "Title","ToolTip", "Expected Output" and "Actual Output"
	    XSSFCell ratings = rowSheet1.createCell(2);
	    XSSFCell hours = rowSheet1.createCell(3);
	    XSSFCell language = rowSheet2.createCell(0);
	    XSSFCell level = rowSheet2.createCell(1);
	    
	    // Set the value of the cells
	    
	    course_name.setCellValue("COURSE NAME");
	    title.setCellValue("TITLE");
	    ratings.setCellValue("RATINGS");
	    hours.setCellValue("HOURS");
	    language.setCellValue("LANGUAGE");
	    level.setCellValue("LEVEL");
        
	    //Setting cell values as bold
        
	    course_name.setCellStyle(style);
	    title.setCellStyle(style);
	    ratings.setCellStyle(style);
	    hours.setCellStyle(style);
	    language.setCellStyle(style);
	    level.setCellStyle(style);
	    
        // Write the workbook to the file output stream
	    
	    xb.write(fo);
	    
	    // Close the workbook and the file output stream
	    
	    xb.close();
	    
	    fo.close();
	}

}