package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	
	//DataProvider 1
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException
	{
		String path=".\\testData\\OpenCart_LoginData.xlsx"; // taking xl file from testData
		
		ExcelUtility xlutil = new ExcelUtility(path);
		
		int totalrows= xlutil.getRowCount("Sheet1");
		int totalcols =xlutil.getCellCount("Sheet1", 1);
		
		String logindata[][] = new String[totalrows][totalcols]; // created for two dimention array which can store
		
		for(int i=1; i<= totalrows; i++) //1 read the data from xl storing in two dimentional array
		{
			for(int j=0; j < totalcols; j++) //i is rows, j is columns/cols
			{
				logindata[i-1][j]= xlutil.getCellData("Sheet1", i, j);
			}
		}
		return logindata; // returning to dimention array

		//DataProvider2
		
		//DataProvider3
	}

}
