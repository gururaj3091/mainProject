package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage {
	
	public WebDriver driver;
	
	@FindBy(xpath="//button[text()='Skip Sign In']")
	private WebElement skipSignIn;
	
	@FindBy(xpath="//button[text()='Sign In']")
	private WebElement signIn;
	
	@FindBy(id="logo")
	private WebElement logo;
	
	@FindBy(id="email")
	private WebElement emailTextBox;
	
	@FindBy(id="enterimg")
	private WebElement enterButton;
	
	public String getPageTitle()
	{
		String title = driver.getTitle();
		return title;
	}
	
	public IndexPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public RegisterPage clickSkipSignIn()
	{
		skipSignIn.click();
		return new RegisterPage(driver);
	}
	
	public SignInPage clickSignIn()
	{
		signIn.click();
		return new SignInPage(driver);
	}
	
	public boolean verifyLogo()
	{
		boolean value = logo.isDisplayed();
		return value;
	}
	
	public void enterEmail(String email)
	{
		emailTextBox.sendKeys(email);
	}
	
	public RegisterPage clickEnetrButton()
	{
		enterButton.click();
		return new RegisterPage(driver);
	}

}
