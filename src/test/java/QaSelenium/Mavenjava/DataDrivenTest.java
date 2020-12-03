package QaSelenium.Mavenjava;

import java.io.IOException;
import java.util.ArrayList;

public class DataDrivenTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//DataDriven d=new DataDriven();
DataDrivenTrial d=new DataDrivenTrial();
ArrayList data=d.getData("Username");
System.out.println(data.get(0));
System.out.println(data.get(1));
System.out.println(data.get(2));
	}

}
