package Test;

import org.openqa.selenium.ElementNotInteractableException;
import org.testng.annotations.Test;

import Page.HomePage;
import Utilities.ExcelUtils;

public class HomeTest extends BaseClass{
	HomePage ob;
	
	@Test(priority=1)
	public void logtest() throws ElementNotInteractableException, Exception
	{
		System.out.println("Login");
		ob=new HomePage(driver);
		ob.login("abc@gmail.com","123456");
		Thread.sleep(3000);
		//ob.popClick();
		//Checking home page title.
		String src=driver.getTitle();
		System.out.println(src);
		if(src.contains("Latest Jobs in India"))
		{
			System.out.println("Logged In Successfully");
		}
		else
		{
			System.out.println("Log In Failed");
		}
		
	}
	
	@Test(priority=2)
	public void profileTest()
	{
		ob.profileicon();
		String p="D:\\Software Testing\\Project\\Automation\\60-resume-manager-97-2003.doc";
		ob.fileUpload(p);
		ob.hamburger();
	}
	@Test(priority=3)
	public void profileSidemenuTest()throws ElementNotInteractableException, Exception
	{
		System.out.println("profile");
		System.out.println("");
		Thread.sleep(1000);
		ob.profileSidemenu();
	}
	@Test(priority=4)
	public void educationDetails_test() throws Exception
	{
		System.out.println("education");
		ob=new HomePage(driver);
		String x1="D:\\Software Testing\\Project\\Automation\\Education Details.xlsx";
		String sheet="Sheet1";
		
		int rowCount=ExcelUtils.getRowCount(x1, sheet);
			String q=ExcelUtils.getCellValue(x1, sheet, 1, 1);
			String s=ExcelUtils.getCellValue(x1, sheet, 2, 1);
			String i=ExcelUtils.getCellValue(x1, sheet, 3, 1);
			String g=ExcelUtils.getCellValue(x1, sheet, 4, 1);
			String y=ExcelUtils.getCellValue(x1, sheet, 5, 1);
			String t=ExcelUtils.getCellValue(x1, sheet, 6, 1);
		System.out.println("q="+q);
		System.out.println("s="+s);
		ob.educationDetails(q,s,i,g,y,t);		
		//ob.educationDetails("M.Com","Taxation","MGU","pass","Distinction","2013");
		
		
	}
	@Test(priority=5)
	public void mousehover()
	{
		ob.mouseOver();
	}
	@Test(priority=6)
	public void subMenu()
	{
		ob.sub_menu();
	}
	@Test(priority=7)
	public void scrollDown()
	{
		ob.scroll_down();
	}
	@Test(priority=8)
	public void logOut()
	{
		ob.log_out();
		ob.locate();
	}
}
