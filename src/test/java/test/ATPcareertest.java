package test;

import org.testng.annotations.Test;

import base.ATPbase;
import page.ATPCareer;

public class ATPcareertest extends ATPbase{
	
@Test
public void career() throws Exception
{
	ATPCareer career=new ATPCareer(driver);
	career.careerPage();
	career.application("Name", "sample@mail.com", "9876543210","D:\\res.docx");
	
}
}
