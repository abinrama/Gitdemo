package QaSelenium.Mavenjava;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriven {
public ArrayList<String> getData(String testcasename) throws IOException {
	FileInputStream fis=new FileInputStream("C://Users//Ramnath//Documents//demodata.xlsx");
	XSSFWorkbook workbook=new XSSFWorkbook(fis);
	int sheetscount=workbook.getNumberOfSheets();
	ArrayList<String> ar=new ArrayList<String>();
	for(int i=0;i<sheetscount;i++) {
		if(workbook.getSheetName(i).equalsIgnoreCase("testdata")) {
			XSSFSheet sheet=workbook.getSheetAt(i);
			//Identify testcases column by scanning the entire 1st row
			Iterator<Row> rows=sheet.iterator();//sheet is collection of rows
			Row firstrow=rows.next();
			Iterator<Cell> ce=firstrow.cellIterator();//row is collection of cells
			int column=0;
			int k=0;
			while(ce.hasNext()) {
				Cell value=ce.next();
				if(value.getStringCellValue().equalsIgnoreCase("Testcase")) {
					//desired column
					column=k;
				}
				k++;
			}
			System.out.println(column);
			//once column is identified scan the entire testcase column to find purchase testcase row
			while(rows.hasNext()) {
				Row r=rows.next();
				if(r.getCell(column).getStringCellValue().equalsIgnoreCase(testcasename)) {
					//after grabbing purchase testcase row-> pull all the data of that row and feed into test
					Iterator<Cell> cv=r.cellIterator();
					while(cv.hasNext()) {
						ar.add(cv.next().getStringCellValue());
						
					}
				}
			}
		}
		
	}
	return ar;
}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
	}

}
