package testcase;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.IndexPage;
import utilities.TestUtils;

public class SignInTest extends BaseTest{

	@Test(dataProvider = "emails")
	public void  testSignin(String email)
	{
		test = reports.createTest("testSignin");
		IndexPage ip = new IndexPage(driver);
		ip.enterEmail(email);
		ip.clickEnetrButton();
	}
	
	@DataProvider(name="emails")
	public Object[][] excelData() throws IOException
	{
		String xlpath = System.getProperty("user.dir")+"/testData/TestData.xslx";
		String sh = "Sheet2";
		Object[][] excelData = TestUtils.testData(xlpath, sh);
		return excelData;
	}
}
