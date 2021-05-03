package Common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.internal.collections.Pair;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;


public class ExcelHandler 

{

	public List<Pair<String, String> > readExcel(String fileName,String sheetName) throws IOException{

	    //Create an object of File class to open xlsx file

	    File file =    new File(fileName);

	    //Create an object of FileInputStream class to read excel file

	    FileInputStream inputStream = new FileInputStream(file);

	    Workbook workBook = null;

	    //Find the file extension by splitting file name in substring  and getting only extension name

	    String fileExtensionName = fileName.substring(fileName.indexOf("."));

	    //Check condition if the file is xls file

	    if(fileExtensionName.equals(".xls")){

	    	workBook = new HSSFWorkbook(inputStream);

	    }

	    //Read sheet inside the workbook by its name

	    Sheet excelSheet = workBook.getSheet(sheetName);

	    //Find number of rows in excel file

	    int rowCount = excelSheet.getLastRowNum()-excelSheet.getFirstRowNum();

	    //Create a loop over all the rows of excel file to read it
	    List<Pair<String, String> > list = new ArrayList<Pair<String, String> >();
	    for (int i = 1; i < rowCount+1; i++) {

	        Row row = excelSheet.getRow(i);

	        //Create a loop to print cell values in a row

	        for (int j = 0; j < row.getLastCellNum(); j++) {

	            //Save Excel data in an Arrary list
	        	list.add(new Pair<String, String>(row.getCell(j).getStringCellValue(), row.getCell(j+1).getStringCellValue()));
	        	break;
	        }
	    } 

	    return list;
	    }  
	
}
