package test;

import org.testng.annotations.Test;

import base.ATPbase;
import page.ATPAbout;

public class ATPaboutustest extends ATPbase{
	@Test
	public void AboutUs()
	{
		ATPAbout about=new ATPAbout(driver);
		about.aboutUs();
	}

}
