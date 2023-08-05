package page;



import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;


public class ATPpage {
	 WebDriver driver;

	//homeverify
	By logo=By.xpath("/html/body/nav/div/div[1]/a/img");
	By welcome=By.xpath("/html/body/div[2]/div[1]/div/p[1]");
	By readmore=By.xpath("/html/body/div[2]/div[1]/div/p[3]/a");
	//aboutUs
	By aboutus=By.xpath("//*[@id=\"navbar-collapse-1\"]/ul/li[2]/a");
	By history= By.xpath("//*[@id=\"navbar-collapse-1\"]/ul/li[2]/ul/li[2]/a");
	//offeringPage
	By offer=By.xpath("//*[@id=\"navbar-collapse-1\"]/ul/li[3]/a");
	By management=By.xpath("//*[@id=\"navbar-collapse-1\"]/ul/li[3]/ul/li[2]/a");
	By linkmgnt=By.linkText("Management Services");
	//Careerpage
	By career=By.xpath("//*[@id=\"navbar-collapse-1\"]/ul/li[4]/a");
	By joblink=By.xpath("/html/body/div[1]/div[2]/div[1]/div[2]/table/tbody/tr[1]/td[1]/a");
	By applybtn=By.xpath("/html/body/div[1]/div[2]/div/div[2]/button");
	By fullname=By.xpath("//input[@id=\'\']");
	By email=By.xpath("//*[@id=\"applynow\"]/div/div/div[2]/form/div[3]/div/input");
	By phonenumber=By.xpath("//*[@id=\"applynow\"]/div/div/div[2]/form/div[4]/div/input");
	By resume=By.xpath("//input[@id=\'exampleInputFile\']");
	By submit=By.xpath("//*[@id=\"applynow\"]/div/div/div[2]/form/div[8]/div/button");
	
	//contactUs
	By contactus=By.xpath("//*[@id=\"navbar-collapse-1\"]/ul/li[5]/a");
	By resetbtn=By.xpath("/html/body/div[1]/div[2]/div/div[1]/form/div[8]/div/button[2]");
	By fname=By.xpath("/html/body/div[1]/div[2]/div/div[1]/form/div[1]/div/input");
	By mailadd=By.xpath("/html/body/div[1]/div[2]/div/div[1]/form/div[2]/div/input");
	By phnum=By.xpath("/html/body/div[1]/div[2]/div/div[1]/form/div[3]/div/input");
	By findus=By.xpath("/html/body/div[1]/div[2]/div/div[1]/form/div[4]/div/select");
	By message=By.xpath("/html/body/div[1]/div[2]/div/div[1]/form/div[5]/div/textarea");
	By submitbtn=By.xpath("/html/body/div[1]/div[2]/div/div[1]/form/div[8]/div/button[1]");
	
	
	
	
	public ATPpage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//home
	public void homeVerify()
	{
		System.out.println("Page Title is:"+driver.getTitle());
		Boolean a=driver.findElement(logo).isDisplayed();
		assertTrue(a);
		{
			System.out.println("The company Logo is Present");
		}
		String text=driver.findElement(welcome).getText();
		String exptext="Welcome to ThomasMount Consulting Pvt Ltd";
		assertEquals(text, exptext);
		{
			System.out.println("Welcome Text Matches");
		}
		
		driver.findElement(readmore).click();
	}
	
	//aboutUs
	public void aboutUs()
	{
		Actions act=new Actions(driver);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		WebElement abtUs=driver.findElement(aboutus);
		act.moveToElement(abtUs).perform();
		driver.findElement(history).click();
		js.executeScript("window.scrollBy(0,600)", "");
	}
	
	//offering
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
	
	public void application(String FN, String mail,String phno,String filepath) throws Exception
	{	
			JavascriptExecutor js=(JavascriptExecutor)driver;
		   	driver.findElement(By.linkText("Careers")).click();
		    driver.findElement(By.linkText("Business Development Manager")).click();
		    driver.findElement(By.xpath("//div[2]/button")).click();
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		    driver.findElement(fullname).sendKeys(FN);
		    driver.findElement(email).sendKeys(mail);
		    driver.findElement(phonenumber).sendKeys(phno);
		    WebElement fileup= driver.findElement(resume);
		    js.executeScript("arguments[0].click();", fileup);
		    //robot class uploa file
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
		    screenshot("careerapplication");
		    driver.findElement(submit).click();
		    }
	
	public void contactData(String FN,String mail,String phno)
	{
		driver.findElement(contactus).click();
		driver.findElement(fname).sendKeys(FN);
		driver.findElement(mailadd).sendKeys(mail);
		driver.findElement(phnum).sendKeys(phno);
		WebElement findussrop=driver.findElement(findus);
		Select dd=new Select(findussrop);
		dd.selectByVisibleText("Friend");
		WebElement copyname=driver.findElement(fname);
		WebElement pastemsg=driver.findElement(message);
		Actions act=new Actions(driver);
		act.keyDown(copyname,Keys.CONTROL).sendKeys("a","c").keyUp(Keys.CONTROL);
		act.keyDown(pastemsg, Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL);
		act.perform();
	}
	
	public void contactSubmit()
	{
		driver.findElement(submitbtn).click();
	}
	

	//screenshot
	public void screenshot(String filename) throws Exception
	{
		File ss= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(ss, new File("./projectScreenShot/"+filename+".png"));
	}
	

}
