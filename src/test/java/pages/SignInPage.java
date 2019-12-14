package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
	
	public WebDriver driver;
	
	@FindBy(id="logo")
	private WebElement logo;
	
	@FindBy(xpath="//input[@ng-model='Email']")
	private WebElement email;
	
	@FindBy(xpath="//input[@ng-model='Password']")
	private WebElement password;
	
	@FindBy(id="enterbtn")
	private WebElement enterButton;
	
	public String getPageTitle()
	{
		String title = driver.getTitle();
		return title;
	}
	
	public SignInPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyLogo()
	{
		boolean value = logo.isDisplayed();
		return value;
	}
	
	public void enterUserAndPass(String user,String pass)
	{
		email.sendKeys(user);
		password.sendKeys(pass);
	}
	
	public void clickEnterButton()
	{
		enterButton.click();
	}

}
