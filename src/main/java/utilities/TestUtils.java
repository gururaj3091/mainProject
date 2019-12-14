package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import testcase.BaseTest;

public class TestUtils extends BaseTest{
	
	public static void takeScreenshot(String name) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		File destFile = new File(System.getProperty("user.dir")+"/screenshots/"+name+".png");
		FileUtils.copyFile(srcFile, destFile);
	}
	
	public static Object[][] testData(String xlpath,String sh) throws IOException
	{
		Object[][] data;
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\testData\\TestData.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet(sh);
		int rc = sheet.getLastRowNum();
		int cc = sheet.getRow(0).getLastCellNum();
		data = new Object[rc][cc];
		
		for(int i=1;i<=rc;i++)
		{
			for(int j=0;j<cc;j++)
			{
				data[i-1][j] = sheet.getRow(i).getCell(j).toString();
			}
		}
		wb.close();
		return data;
	}

}
