package testcases;
import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SubscriptionVerify extends ReusableClass{
	public static String filePath="C:\\Users\\Kate\\Desktop\\AutomationExerciseData.xlsx";
	public static String sheetName="SignUpInfo";	
	
	project2.SubscriptionObject sbo=new project2.SubscriptionObject();
	project2.SignUpObjects so= new project2.SignUpObjects(driver);
	 @BeforeTest
	   public void startUp() throws Exception {
		   launchApp();
	   }
	 @Test(priority = 1)
	 public void verifySubs() {
		 elementAvailable(so.homepage, true);
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
//		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//			wait.until(ExpectedConditions.visibilityOf(sbo.subscribTxt));
		 innerTextEquals(sbo.subscribTxt, "SUBSCRIPTION");
		 sbo.subsEmail.sendKeys(readDataFromExcel(2, 2, filePath, sheetName));
		 sbo.subsBtn.click();
		 innerTextEquals(sbo.subscriptionAlert, "You have been successfully subscribed!");
	 }
	 @Test(priority = 2)
	 public void verifySubsInCart() {
		 elementAvailable(so.homepage, true);
		 sbo.cart.click();
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
//		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//		 wait.until(ExpectedConditions.visibilityOf(sbo.subscribTxt));
		 innerTextEquals(sbo.subscribTxt, "SUBSCRIPTION");
		 sbo.subsEmail.sendKeys(readDataFromExcel(2, 2, filePath, sheetName));
		 sbo.subsBtn.click();
		 innerTextEquals(sbo.subscriptionAlert, "You have been successfully subscribed!");
	 }
	 
	 @AfterSuite
	 public void close() {
		 close();
}
}
