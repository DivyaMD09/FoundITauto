package Page;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	WebDriver driver;
	By log=By.xpath("//*[@id=\"topHeader\"]/div[3]/div[2]/div/div[2]/ul/li[1]/a/span");
	By email=By.id("signInName");
	By pass=By.id("password");
	By logbtn=By.id("signInbtn");
	By popup=By.xpath("//*[@id=\"topHeader\"]/div[2]/div/div/div/button");
	By profileBtn=By.xpath("//*[@id=\"topHeader\"]/div[3]/div[2]/div/div[2]/ul/li[3]/span/span/i");
	By fileUp=By.xpath("//*[@id=\"resume\"]");
	By save=By.xpath("//*[@id=\"modalDescription\"]/div/div[2]/div/div/button");
	By ham=By.xpath("//*[@class=\"hamburgerHolder\"]");
	By prof=By.xpath("//*[@title=\"My Profile\"]");
	By qualification=By.id("qualification");
	By specification=By.id("specialization");
	By inst=By.id("institute");
	By grade=By.id("gradSystem");
	By year=By.id("passYear");
	By ft=By.xpath("//*[@value=\"Full time\"]");
	By pt=By.xpath("//*[@value=\"Part time\"]");
	By cr=By.xpath("//*[@value=\"Correspondence\"]");
	By esave=By.xpath("//*[@id=\"educationInlineForm\"]/div/div/div/div[2]/button");
	By skill=By.xpath("//*[@id=\"no-logged\"]/li[2]/a");
	//By js=By.xpath("//*[@id=\"no-logged\"]/li[2]/div/ul[3]/li[4]/a");
	By js=By.xpath("//*[@id=\"headerLinks\"]/nav/ul/li[2]/a");
	By userProfile=By.xpath("//*[@id=\"header\"]/div/div[4]/button/img");
	By logout=By.xpath("/html/body/div[4]/div[3]/p/span[2]");
	
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	public void login(String eid,String pwd)
	{
		driver.findElement(log).click();
		driver.findElement(email).sendKeys(eid);
		driver.findElement(pass).sendKeys(pwd);
		driver.findElement(logbtn).click();
		
	}
	public void locate()
	{
		System.out.println("Locate Method");
		try
		{
			System.out.println("Inside try");
			WebElement t=driver.findElement(logout);
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));
			System.out.println("t-"+t);
			if (t.isDisplayed())
			{
				
               System.out.println("Drop Element is visible");	
            }
		}catch(Exception e)   
		{
			System.out.println("Drop Element is invisible");
		}
	}
	public void popClick()
	{
		//closing popup
		driver.findElement(popup).click();
	}
	public void profileicon()
	{
		driver.findElement(profileBtn).click();
	}
	public void fileUpload(String path)
	{
		driver.findElement(fileUp).sendKeys(path);
		System.out.println("success");
		driver.findElement(save).click();
	}
	public void hamburger()  
	{
		System.out.println("Hamburger Menu");
		driver.findElement(ham).click();//clicking hamburger menu.
		
	}
	public void profileSidemenu()
	{
		
		driver.findElement(prof).click();
		
	}
	public void educationDetails(String quali,String speci,String insti,String grad,String yr,String e_type) throws ElementNotInteractableException, Exception
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(2000));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		
		WebElement q= driver.findElement(qualification);
		q.sendKeys(quali);
		Actions action=new Actions(driver);
		//1.select send keys web element 2.select send keys
		action.sendKeys(q, Keys.ARROW_UP).sendKeys(Keys.ENTER).build().perform();
		try {
		System.out.println("Hi");
		WebElement s=driver.findElement(specification);
		wait.until(ExpectedConditions.visibilityOf(s));
		
		s.sendKeys(speci,Keys.ENTER);		
		
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		WebElement i= driver.findElement(inst);
		i.sendKeys(insti);
		action.sendKeys(i, Keys.ARROW_UP).sendKeys(Keys.ENTER).build().perform();
		
		WebElement g= driver.findElement(grade);
		g.sendKeys(grad);
		action.sendKeys(g, Keys.ARROW_UP).sendKeys(Keys.ENTER).build().perform();
		
		WebElement y= driver.findElement(year);
		y.sendKeys(yr);
		action.sendKeys(y, Keys.ARROW_UP).sendKeys(Keys.ENTER).build().perform();
		
		System.out.println("etype "+e_type);
		if(e_type.equalsIgnoreCase("Full time"))
		{
			driver.findElement(ft).click();
		}
		else if(e_type.equalsIgnoreCase("Part time"))
		{
			driver.findElement(pt).click();
		}
		else
		{
			driver.findElement(cr).click();
		}
	
	//	driver.findElement(esave).click();
	
		/*WebElement s= driver.findElement(specification);
		s.sendKeys(speci);
		Thread.sleep(2000);
		action.sendKeys(s, Keys.ARROW_UP).sendKeys(Keys.ENTER).build().perform();
		
		*/
	}
	public void mouseOver()
	{
		WebElement skill_link=driver.findElement(skill);
		Actions action=new Actions(driver);
		action.moveToElement(skill_link).perform();
		System.out.println("Done Mouse hover on 'skill tests' from Menu");
	}
	public void sub_menu()
	{
		WebElement j_s=driver.findElement(js);
		Actions action=new Actions(driver);
		action.moveToElement(j_s).click().perform();
	}
	public void scroll_down()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
	}
	public void log_out()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		driver.findElement(userProfile).click();
		driver.findElement(logout).click();
	}
}

