package test;

import org.testng.annotations.Test;

import base.ATPbase;
import page.ATPHome;

public class ATPhometest extends ATPbase{
	@Test
	public void Home()
	{
		ATPHome home=new ATPHome(driver);
		home.homeVerify();
	}

}
