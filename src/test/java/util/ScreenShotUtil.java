package util;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import base.ATPbase;

public class ScreenShotUtil extends ATPbase {
	
	public ScreenShotUtil(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void screenshot(String filename) throws Exception
	{
		File ss= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(ss, new File("./projectScreenShot/"+filename+".png"));
	}
	

}



