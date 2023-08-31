package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ATPContact {
	WebDriver driver;
	//contactUs
		By contactus=By.xpath("//*[@id=\"navbar-collapse-1\"]/ul/li[5]/a");
		By resetbtn=By.xpath("/html/body/div[1]/div[2]/div/div[1]/form/div[8]/div/button[2]");
		By fname=By.xpath("/html/body/div[1]/div[2]/div/div[1]/form/div[1]/div/input");
		By mailadd=By.xpath("/html/body/div[1]/div[2]/div/div[1]/form/div[2]/div/input");
		By phnum=By.xpath("/html/body/div[1]/div[2]/div/div[1]/form/div[3]/div/input");
		By findus=By.xpath("/html/body/div[1]/div[2]/div/div[1]/form/div[4]/div/select");
		By message=By.xpath("/html/body/div[1]/div[2]/div/div[1]/form/div[5]/div/textarea");
		By submitbtn=By.xpath("/html/body/div[1]/div[2]/div/div[1]/form/div[8]/div/button[1]");
	
	
	public ATPContact(WebDriver driver)
	{
		this.driver=driver;
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
	

}
