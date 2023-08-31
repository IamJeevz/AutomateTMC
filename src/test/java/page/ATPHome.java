package page;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public class ATPHome {
		WebDriver driver;
	//homeverify
		By logo=By.xpath("/html/body/nav/div/div[1]/a/img");
		By welcome=By.xpath("/html/body/div[2]/div[1]/div/p[1]");
		By readmore=By.xpath("/html/body/div[2]/div[1]/div/p[3]/a");
		
		public ATPHome(WebDriver driver)
		{
			this.driver=driver;
		}
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

}
