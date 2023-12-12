package testcases;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.Alert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ContactForms extends ReusableClass{
	
	project2.ContactFormObjects co= new project2.ContactFormObjects(ReusableClass.driver);
	project2.SignUpObjects so= new project2.SignUpObjects(ReusableClass.driver);
	 
	 @BeforeTest
	   public void startUp() throws Exception {
		   launchApp();
	   }
	
	 @Test
	 public void ContactTest() throws Exception {
		 elementAvailable(so.homepage, true);
		 co.ContactUs.click();
		 elementAvailable(co.GetInTch, true);
		 co.ContName.sendKeys("saylee");
		 co.ContEmail.sendKeys("sayleekate555@gmail.com");
		 co.ContSubj.sendKeys("Test Subject");
		 co.ContMsg.sendKeys("Test Message");
		// co.uploadFile.sendKeys("C:\\Users\\Kate\\Desktop\\xlsx");
		 Robot rb= new Robot();
		 StringSelection str = new StringSelection("C:\\Users\\Kate\\Desktop\\xlsx");
		 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
		 // press Contol+V for pasting
	     rb.keyPress(KeyEvent.VK_CONTROL);
	     rb.keyPress(KeyEvent.VK_V);
	     // release Contol+V for pasting
	     rb.keyRelease(KeyEvent.VK_CONTROL);
	     rb.keyRelease(KeyEvent.VK_V);	  
	     // for pressing and releasing Enter
	     rb.keyPress(KeyEvent.VK_ENTER);
	     rb.keyRelease(KeyEvent.VK_ENTER);
		 co.submitBtn.click();
		 Alert alert= driver.switchTo().alert();
		 alert.accept();
		 elementAvailable(co.succMsg, true);
		 co.home.click();
		 elementAvailable(so.homepage, true);
		 titleEquals("Automation Exercise");
		
	 }
	 
	 @AfterSuite
	   public void close() {
		  closeApp();
	   }
}
