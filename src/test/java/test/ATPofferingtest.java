package test;

import org.testng.annotations.Test;

import base.ATPbase;
import page.ATPOffering;

public class ATPofferingtest extends ATPbase{
	@Test
	public void offering() throws Exception
	{
		ATPOffering offering = new ATPOffering(driver);
		offering.offeringPage();
	}
	

}
