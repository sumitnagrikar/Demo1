package pageobjectmodel;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

	@FindBy(xpath="//h3")
	public List<WebElement> courses;
	
	@FindBy(xpath="//h3[@Class='box-title']")
	WebElement userlist;
	
	@FindBy(xpath="/html/body/div/aside/section/ul/li[3]/a")
	WebElement user;
	public DashboardPage(WebDriver driver) {	
		PageFactory.initElements(driver, this);
	}

	public boolean verifyCourses(){
		boolean flag = false;
		for (WebElement course : courses) {
			flag =course.isDisplayed();	
		//	String nameCourse = course.getText();
			//System.out.println("Name of the courses are :"+nameCourse);
		}
		 return flag;
	}
			public void getUserPage(){
				
					user.click();
			}	
	
}
