package aPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testcase.BaseTest;

public class SignIn extends BaseTest {

	@FindBy(id="ap_email")
	private WebElement mobNo;
	
	@FindBy(id="continue")
	private WebElement cont;
	
	@FindBy(id="ap_password")
	private WebElement pwd;
	
	@FindBy(id="signInSubmit")
	private WebElement lgn;
	
	public SignIn(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public OnlineShopping logIn(String no,String pass)
	{
		mobNo.sendKeys(no);
		cont.click();
		pwd.sendKeys(pass);
		lgn.click();
		return new OnlineShopping(driver);
	}
	
}
