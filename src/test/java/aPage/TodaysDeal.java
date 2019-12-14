package aPage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testcase.BaseTest;

public class TodaysDeal extends BaseTest {
	
	@FindBy(xpath="//span[contains(text(),'Collectible India 6ft Christmas Tree Xmas Tree with Solid P')]/../../..//span[contains(text(),'1199')]")
	private WebElement item1;

	public TodaysDeal(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	public Product scrollAndClick()
	{
		int p1 = item1.getLocation().getY();
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollTo(0,"+p1+")");
		item1.click();
		return new Product(driver);
	}

}
