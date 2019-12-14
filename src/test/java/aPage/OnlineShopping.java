package aPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testcase.BaseTest;

public class OnlineShopping extends BaseTest {
	
	@FindBy(xpath="//span[contains(text(),'Hello. Sign in')]")
	private WebElement signIn;
	
	@FindBy(xpath="//a[contains(text(),'s Deals')]")
	private WebElement todaysDeal;
	
	public OnlineShopping(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public SignIn clickSignIn()
	{
		signIn.click();
		return new SignIn(driver);
	}
	
	public TodaysDeal clickDeals()
	{
		todaysDeal.click();
		return new TodaysDeal(driver);
	}
}
