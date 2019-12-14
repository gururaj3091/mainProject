package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
	public WebDriver driver;
	
	@FindBy(xpath="//input[ng-model='FirstName']")
	private WebElement firstName;
	
	@FindBy(xpath="//input[ng-model='LastName']")
	private WebElement lastName;
	
	@FindBy(xpath="//input[ng-model='EmailAdress']")
	private WebElement emailAddress;
	
	@FindBy(xpath="//input[ng-model='Phone']")
	private WebElement phone;
	
	@FindBy(name="signup")
	private WebElement signUp;

	public RegisterPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public String getPageTitle()
	{
		String title = driver.getTitle();
		return title;
	}
	
	public void enterDetails(String fn,String ln,String email,String mob)
	{
		firstName.sendKeys(fn);
		lastName.sendKeys(ln);
		emailAddress.sendKeys(email);
		phone.sendKeys(mob);
	}
	
	public void clickSignUp()
	{
		signUp.click();
	}

}
