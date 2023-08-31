package test;

import org.testng.annotations.Test;

import base.ATPbase;
import page.ATPContact;
import util.ExcelUtil;
import util.ScreenShotUtil;

public class ATPcontacttest extends ATPbase{

	@Test
	public void contact() throws Exception
	{
		ATPContact contacts=new ATPContact(driver);
		String filepath="D:\\JEEVZ\\userdatas.xlsx";
		String Sheet="Sheet1";
		int rowcount=ExcelUtil.cellCount(filepath, Sheet);
		for(int i=1;i<=rowcount;i++)
		{
			String FullName=ExcelUtil.cellVal(filepath, Sheet, i, 0);
			String Mailid=ExcelUtil.cellVal(filepath, Sheet, i, 1);
			String Phno=ExcelUtil.cellVal(filepath, Sheet, i, 2);
			contacts.contactData(FullName, Mailid, Phno);
			ScreenShotUtil ss=new ScreenShotUtil(driver);
			ss.screenshot("datadiven"+i);
			contacts.contactSubmit();
		}
	}
}
