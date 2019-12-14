package aPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import testcase.BaseTest;

public class Product extends BaseTest {

	public Product(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
