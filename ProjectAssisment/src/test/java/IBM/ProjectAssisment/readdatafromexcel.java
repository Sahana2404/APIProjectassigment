package IBM.ProjectAssisment;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class readdatafromexcel {
	public static void main(String[] args) throws IOException{
		 
		String pathofExcelSheet = "C:\\Users\\000E4U744\\Documents\\API\\Testdata.xls";
		
		File file =new File(pathofExcelSheet);
		FileInputStream fis= new FileInputStream (file);
		
		HSSFWorkbook wb =new HSSFWorkbook (fis);
		HSSFSheet Sheet3 = wb.getSheet("Sheet3");
		HSSFRow row1= Sheet3.getRow(1);
		System.out.println(row1.getCell(1).getStringCellValue());
			
	}

}
