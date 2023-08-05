package test;




import org.testng.annotations.Test;

import base.ATPbase;
import page.ATPpage;
import util.ExcelUtil;

public class ATPtest extends ATPbase {
	@Test
	public void setUp() throws Exception
	{
		ATPpage ob=new ATPpage(driver);
		
		ob.homeVerify();
		ob.aboutUs();
		ob.offeringPage();
		ob.careerPage();
		ob.application("Name", "sample@mail.com", "9876543210","D:\\res.docx");
		
		String filepath="D:\\JEEVZ\\userdatas.xlsx";
		String Sheet="Sheet1";
		int rowcount=ExcelUtil.cellCount(filepath, Sheet);
		for(int i=1;i<=rowcount;i++)
		{
			String FullName=ExcelUtil.cellVal(filepath, Sheet, i, 0);
			String Mailid=ExcelUtil.cellVal(filepath, Sheet, i, 1);
			String Phno=ExcelUtil.cellVal(filepath, Sheet, i, 2);
			ob.contactData(FullName, Mailid, Phno);
			ob.screenshot("datadriven"+i);
			ob.contactSubmit();
		}
	}
}
