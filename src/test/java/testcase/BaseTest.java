package testcase;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class BaseTest {
	
	public static WebDriver driver;
	public DesiredCapabilities cap;
	public Properties prop;
	public Logger log;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports reports;
	public static ExtentTest test;
	
	@BeforeSuite
	public void testReporter()
	{
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/reportsAndLogs/TestReoprt.html");
		htmlReporter.config().setDocumentTitle("Final Report");
		htmlReporter.config().setReportName("Guru");
		htmlReporter.config().setTheme(Theme.DARK);	
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);
		reports.setSystemInfo("Environment", "QA");
		reports.setSystemInfo("User", "Gururaj");
	}
	
	@BeforeMethod
	public void testInvokeBrowser() throws IOException
	{
		PropertyConfigurator.configure(System.getProperty("user.dir")+"\\propertyFiles\\log4j.properties");
		log = Logger.getLogger("devpinoyLogger");
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\propertyFiles\\config.properties");
		prop = new Properties();
		prop.load(fis);
		log.info("Setting browser capabilites");
		cap = new DesiredCapabilities();
		cap.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		
		String browser = prop.getProperty("browser");
		if(browser.equalsIgnoreCase("chrome"))
		{
			log.info("Opening chrome browser");
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\exes\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			cap.setCapability(ChromeOptions.CAPABILITY, options);
			driver = new ChromeDriver(cap);
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			log.info("Opening the Firefox browser");
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\exes\\geckodriver.exe");
			driver = new FirefoxDriver(cap);
		}
		else
		{
			log.info("Opening the  IE browser");
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\exes\\iedriver.exe");
			cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			cap.setCapability(InternetExplorerDriver.FORCE_CREATE_PROCESS, true);
			driver = new InternetExplorerDriver(cap);
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		log.info("Entering the site URL");
		String url = prop.getProperty("url");
		driver.get(url);	
	}
	
	@AfterMethod
	public void testCloseBrowser(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			test.fail(MarkupHelper.createLabel(result.getName()+" is Failed.", ExtentColor.RED));
			test.fail(result.getThrowable());
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			test.pass(MarkupHelper.createLabel(result.getName()+" is Passed.", ExtentColor.GREEN));
		}
		else
		{
			test.skip(MarkupHelper.createLabel(result.getName()+" is Skipped.", ExtentColor.ORANGE));
			test.skip(result.getThrowable());
		}
		driver.close();
	}
	
	@AfterSuite
	public void testFlushAll()
	{
		reports.flush();
		driver.quit();
	}

}
