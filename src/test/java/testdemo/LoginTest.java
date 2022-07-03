package testdemo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import demo.LoginPage;

public class LoginTest {

	WebDriver driver;
	LoginPage lp;
	@BeforeMethod
	public void openBrowser(){
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("file:///C:/Users/abc/Downloads/javabykiran-Selenium-Softwares/Offline%20Website/index.html");
		driver.manage().window().maximize();
		lp = new LoginPage(driver);
	}
	@AfterMethod
	void closeDriver(){
		driver.close();
	}

	@Test
	public void verifyDashboardAppeared(){
		lp.dashBoard();
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | Dashboard");

	}
	
	@Test
	public void verifyUserPageShowed(){
		lp.userPage();
		
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | User");

	}
}
