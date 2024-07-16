package api.utilities;


import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	public String datapath = System.getProperty("user.dir") + "\\TestData\\userdata.xlsx";
	public Path pdatapath = Paths.get(datapath);
	
	@DataProvider(name = "Data")
	public String[][] get_all_data() throws IOException{
		XLUtility xl = new XLUtility(pdatapath.toString());
		
		int rownum = xl.getRowCount("Sheet1");
		
		int colcount = xl.getcellcount("Sheet1", 0);
		
		String apidata[][] = new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++) {
			for(int j=0;j<colcount;j++) {
				apidata[i-1][j] = xl.getCellData("Sheet1",i,j);
			}
		}
		return apidata;
	}
	
	@DataProvider(name = "UserNames")
	public String[] getUserNames() throws IOException, InterruptedException{

		XLUtility xl = new XLUtility(pdatapath.toString());
		int rownum = xl.getRowCount("Sheet1");
		String payloaddata[] = new String[rownum];
		
		for(int i=1;i<=rownum;i++) {
			payloaddata[i-1] = xl.getCellData("Sheet1", i, 1);
		}
		return payloaddata;
	}

}
