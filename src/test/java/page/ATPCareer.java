package page;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import util.ScreenShotUtil;

public class ATPCareer {
	WebDriver driver;
	//Careerpage
		By career=By.xpath("//*[@id=\"navbar-collapse-1\"]/ul/li[4]/a");
		By joblink=By.xpath("/html/body/div[1]/div[2]/div[1]/div[2]/table/tbody/tr[1]/td[1]/a");
		By applybtn=By.xpath("/html/body/div[1]/div[2]/div/div[2]/button");
		By fullname=By.xpath("//input[@id=\'\']");
		By email=By.xpath("//*[@id=\"applynow\"]/div/div/div[2]/form/div[3]/div/input");
		By phonenumber=By.xpath("//*[@id=\"applynow\"]/div/div/div[2]/form/div[4]/div/input");
		By resume=By.xpath("//input[@id=\'exampleInputFile\']");
		By submit=By.xpath("//*[@id=\"applynow\"]/div/div/div[2]/form/div[8]/div/button");
	
	
	public ATPCareer(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//career page
		public void careerPage()
		{
			driver.findElement(career).click();
			List <WebElement> linksource=driver.findElements(By.tagName("a"));
			int linkcount=linksource.size();
			System.out.println("Total No Of Links:"+linkcount);
			for(WebElement eachlink:linksource)
			{
				String link=eachlink.getAttribute("href");
				linkverify(link);
			}
		}
		
		public void application(String FN, String mail,String phno,String filepath) throws Exception
		{	
				//JavascriptExecutor js=(JavascriptExecutor)driver;
				Actions act=new Actions(driver);
			   	driver.findElement(By.linkText("Careers")).click();
			    driver.findElement(By.linkText("Business Development Manager")).click();
			    driver.findElement(By.xpath("//div[2]/button")).click();
			    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
			    driver.findElement(fullname).sendKeys(FN);
			    driver.findElement(email).sendKeys(mail);
			    driver.findElement(phonenumber).sendKeys(phno);
			    WebElement fileup= driver.findElement(resume);
			  // js.executeScript("arguments[0].click();", fileup);
			    act.click(fileup).perform();
			    //robot class upload file
			    Robot rob=new Robot();
			    StringSelection str=new StringSelection(filepath);
			    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
			    rob.keyPress(KeyEvent.VK_CONTROL);
			    rob.keyPress(KeyEvent.VK_V);
			    rob.keyRelease(KeyEvent.VK_CONTROL);
			    rob.keyRelease(KeyEvent.VK_V);
			    rob.keyPress(KeyEvent.VK_ENTER);
			    rob.keyRelease(KeyEvent.VK_ENTER);
			    rob.delay(3000);
			    ScreenShotUtil ss=new ScreenShotUtil(driver);
			    ss.screenshot("careerapplication");
			    driver.findElement(submit).click();
			    }
		
		
		
		
		//linkverify
		public void linkverify(String link) {
			try {
				URL u=new URL(link);
				HttpURLConnection url=(HttpURLConnection)u.openConnection();
				url.connect();
				if(url.getResponseCode()==200)
				{
					System.out.println("Success>>>"+link);
				}
				else if(url.getResponseCode()==404)
				{
					System.out.println("Failed>>>"+link);
				}
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
			
		}
}
