package page;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ATPOffering {
	WebDriver driver;
	//offeringPage
		By offer=By.xpath("//*[@id=\"navbar-collapse-1\"]/ul/li[3]/a");
		By management=By.xpath("//*[@id=\"navbar-collapse-1\"]/ul/li[3]/ul/li[2]/a");
		By linkmgnt=By.linkText("Management Services");
		
		public ATPOffering(WebDriver driver)
		{
			this.driver=driver;
		}
		public void offeringPage() throws Exception
		{
			Actions act=new Actions(driver);
			WebElement offerelement=driver.findElement(offer);
			WebElement mngtelement=driver.findElement(management);
			act.moveToElement(offerelement).perform();
			act.moveToElement(mngtelement).perform();
			String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN); 
			driver.findElement(linkmgnt).sendKeys(selectLinkOpeninNewTab);
			String parent=driver.getWindowHandle();
			Set <String> handles=driver.getWindowHandles();
			for(String link:handles)
			{
				if(!parent.equalsIgnoreCase(link))
				{
					driver.switchTo().window(link);
				}
			}
			String p1="Leadership Hiring";
			String p2="Management Consulting";
			String offersrc=driver.getPageSource();
			if(offersrc.contains(p1) && offersrc.contains(p2))
			{
				System.out.println("The expected text is Present in Offering Page");
			}
			driver.switchTo().window(parent);
					
		}

}
