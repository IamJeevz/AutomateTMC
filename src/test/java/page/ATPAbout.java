package page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ATPAbout {
	WebDriver driver;
	//aboutUs
		By aboutus=By.xpath("//*[@id=\"navbar-collapse-1\"]/ul/li[2]/a");
		By history= By.xpath("//*[@id=\"navbar-collapse-1\"]/ul/li[2]/ul/li[2]/a");
		public ATPAbout(WebDriver driver)
		{
			this.driver=driver;
		}
		public void aboutUs()
		{
			Actions act=new Actions(driver);
			JavascriptExecutor js=(JavascriptExecutor)driver;
			WebElement abtUs=driver.findElement(aboutus);
			act.moveToElement(abtUs).perform();
			driver.findElement(history).click();
			js.executeScript("window.scrollBy(0,600)", "");
		}

}
