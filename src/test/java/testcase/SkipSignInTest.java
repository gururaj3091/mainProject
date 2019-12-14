package testcase;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import pages.IndexPage;
import pages.RegisterPage;

public class SkipSignInTest extends BaseTest {
	
	@Test
	public void testSkipSignIn()
	{
		test = reports.createTest("testSkipSignIn");
		IndexPage ip = new IndexPage(driver);
		RegisterPage rp = ip.clickSkipSignIn();
		String pageTitle = driver.getTitle();
		Assert.assertEquals(pageTitle, "Register");
	}

}
