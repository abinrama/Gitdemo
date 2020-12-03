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

public class DataDrivenTrial {
	public ArrayList<String> getData(String testcasename) throws IOException {
		FileInputStream fis=new FileInputStream("C://Users//Ramnath//Documents//demodata.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		ArrayList<String> ar=new ArrayList<String>();
		int sheetcount=workbook.getNumberOfSheets();//get no.of sheets in workbook
		for(int i=0;i<sheetcount;i++) {
			if(workbook.getSheetName(i).equalsIgnoreCase("credentials")) {
				XSSFSheet sheet=workbook.getSheetAt(i);
				Iterator<Row> rows=sheet.iterator();
				Row firstrow=rows.next();//accessing first row in the sheet
				Iterator<Cell> ce=firstrow.cellIterator();
				int column=0;
				int k=0;
				while(ce.hasNext()) {
					if(ce.next().getStringCellValue().equalsIgnoreCase(testcasename)) {
						column=k;
					}
					k++;
				}
				System.out.println(column);
				while(rows.hasNext()) {
					ar.add(rows.next().getCell(column).getStringCellValue());
				}
			}
		}
		return ar;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		

	}

}
