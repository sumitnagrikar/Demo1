package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;

public class LoginPage {

	public LoginPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	WebDriver driver;
	
	public void dashBoard(){
	
	WebElement email = driver.findElement(By.id("email"));
	email.sendKeys("kiran@gmail.com");
		
	driver.findElement(By.id("password")).sendKeys("123456");
	
	driver.findElement(By.xpath("//button")).click();

	
	}
	
	public void userPage(){
		
			WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("kiran@gmail.com");
			
		driver.findElement(By.id("password")).sendKeys("123456");
		
		driver.findElement(By.xpath("//button")).click();

		driver.findElement(By.xpath("//a[@href='users.html']")).click();
		}
	
	
	
}
