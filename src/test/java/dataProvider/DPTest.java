package dataProvider;

import org.testng.annotations.Test;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

public class DPTest {
	
	WebDriver driver=null;
	
	@BeforeSuite
	public void openDriver(){
		System.setProperty("webdriver.driver.chromedriver", "chromedriver.exe");
		 driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
  @Test(dataProvider = "logindata")
  public void logintest(String uname, String pass, String errMsg, String passErr) {
  driver.get("file:///C:/Users/abc/Downloads/javabykiran-Selenium-Softwares/Offline Website/index.html");
  
  driver.findElement(By.id("email")).sendKeys(uname);
  driver.findElement(By.id("password")).sendKeys(pass);
  driver.findElement(By.xpath("//button")).click();
  
  if(driver.getTitle().equals("JavaByKiran | Dashboard"))
  Assert.assertEquals(driver.getTitle(), "JavaByKiran | Dashboard");
  else{
	  
	  WebElement emailErr = driver.findElement(By.id("email_error"));
	  Assert.assertEquals(emailErr.getText(), errMsg);
  
	  WebElement passError = driver.findElement(By.id("password_error"));
	  Assert.assertEquals(passError.getText(), passErr);
  }
  
  }
  
  @DataProvider
  public Object[][] logindata() {
    return new Object[][] {
      new Object[] { "", "" ,"Please enter email.","Please enter password."},
      new Object[] { "sumit", "154545" ,"Please enter email as kiran@gmail.com","Please enter password 123456" },
      new Object[] { "kiran@gmail.com", "123456","",""},
      new Object[] { "kiran@gmail.com", "254487","","Please enter password 123456"}
    
    };
  }
}

