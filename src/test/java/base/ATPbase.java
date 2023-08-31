package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class ATPbase {
public static WebDriver driver;
	public String url="http://www.thomasmount.com/";
	@BeforeTest
	public void testBase()
	{
		//ChromeOptions opt=new ChromeOptions();
		//opt.addArguments("--disable-notifications");
		driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}

}
