package testcases;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TestCases extends ReusableClass {
	project2. TestCasesObjects to= new project2.TestCasesObjects(ReusableClass.driver);
	   project2.SignUpObjects so= new project2.SignUpObjects(ReusableClass.driver);
	   
	   @BeforeTest
	   public void startUp() throws Exception {
		   launchApp();
	   }
	   @Test
		 public void TestCasestest() throws Exception {
		   elementAvailable(so.homepage, true);
		   to.TestCases.click();
		   elementAvailable(to.validateTCTxt, true);
		   System.out.println(ReusableClass.driver.getCurrentUrl()); 
	     }
	   @AfterSuite
	   public void close() {
		  closeApp();
	   }
}
