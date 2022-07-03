package pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {

	WebDriver driver = null;
	LoginPage lp=null;
	DashboardPage dp = null;

	@Test
	public void test01(){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\abc\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("file:///C:/Users/abc/Downloads/javabykiran-Selenium-Softwares/Offline%20Website/index.html");

		lp = new LoginPage(driver);
		dp =lp.getDashboard();//new DashboardPage object
		//lp.loginToPage("kiran@gmail.com","123456");

		Assert.assertEquals(driver.getTitle(), "JavaByKiran | Dashboard");
	}


	@Test(priority=1)
	public void test02(){
		Assert.assertTrue(dp.verifyCourses());
	}

	@Test(priority=2)
	public void test03(){
		dp.getUserPage();
		Assert.assertTrue(dp.userlist.isDisplayed());
	}

}


