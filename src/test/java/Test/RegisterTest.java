package Test;

import org.testng.annotations.Test;

import Page.RegisterPage;

public class RegisterTest extends BaseClass {
	RegisterPage ob;
	@Test
	public void regTest()
	{
		ob=new RegisterPage(driver);
		ob.register();
		ob.basicDetails("Niharika","abc@gmail.com","123456","1234432643","female");
		ob.continues();
		
	}
	

}
