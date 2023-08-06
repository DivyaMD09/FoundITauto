package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
	WebDriver driver;
	By reg=By.xpath("//*[@id=\"heroSection-container\"]/div[3]/div[1]");
	By fullName=By.xpath("//*[@id=\"fullName\"]");
	By email=By.xpath("//*[@id=\"emailId\"]");
	By pass=By.xpath("//*[@id=\"password\"]");
	By mobile=By.xpath("//*[@id=\"mobileNumber\"]");
	By male=By.id("option-0");
	By female=By.id("option-1");
	By other=By.id("option-2");
	By btn=By.xpath("//*[@id=\"basicDetails\"]/div[1]/div[10]/label/div");
	By cntbtn=By.id("continue-btn");
	public RegisterPage(WebDriver driver)
	{
		this.driver=driver;
	}
	public void register()
	{
		driver.findElement(reg).click();
	}
	public void basicDetails(String fn,String eid,String pwd,String mob,String rd)
	{
		driver.findElement(fullName).sendKeys(fn);
		driver.findElement(email).sendKeys(eid);
		driver.findElement(pass).sendKeys(pwd);
		driver.findElement(mobile).sendKeys(mob);
		if(rd.equalsIgnoreCase("male"))
		{
			driver.findElement(male).click();
		}
		else if(rd.equalsIgnoreCase("female"))
		{
			driver.findElement(female).click();
		}
		else
		{
			driver.findElement(other).click();
		}
		driver.findElement(btn).click();
	}
		public void continues()
		{
			driver.findElement(cntbtn).click();
			//driver.close();
		}
		
	
}
