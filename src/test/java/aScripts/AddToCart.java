package aScripts;

import org.testng.annotations.Test;

import aPage.OnlineShopping;
import aPage.Product;
import aPage.SignIn;
import aPage.TodaysDeal;
import testcase.BaseTest;

public class AddToCart extends BaseTest {
	
	@Test
	public void testAddToCart()
	{
		test = reports.createTest("testAddToCart");
		OnlineShopping os = new OnlineShopping(driver);
		SignIn si  = os.clickSignIn();
		os = si.logIn("8939115562", "welcome1@");
		TodaysDeal dp = os.clickDeals();
		Product pr = dp.scrollAndClick();
	}

}
