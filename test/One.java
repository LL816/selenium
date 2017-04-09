package test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import org.testng.Assert;

public class One {

//		System.setProperty("webdriver.firefox.marionette","C:\\Users\\bennyhuo\\IdeaProjects\\selenium\\geckodriver.exe");
	String baseurl="http://newtours.demoaut.com";
	WebDriver driver;
	@BeforeTest
	public void launchBrowser() {
		System.setProperty("webdriver.firefox.bin", "C:/Program Files/Mozilla Firefox/firefox.exe");
		driver = new FirefoxDriver();
		driver.get(baseurl);
	}
	@Test(priority = 0)
	public void verifyHomepage() {
		String expectedTitle = "Welcome: Mercury Tours";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle,expectedTitle);
	}

	@Test(priority = 1)
	public void verifyLink() {
		String actualText = driver.findElement(By.linkText("featured vacation destinations")).getText();
		String expectedText = "featured vacation destinations";
		Assert.assertEquals(actualText, expectedText);
	}
//		WebElement username = driver.findElement(By.name("userName"));

	@AfterTest
	public void closeBrowser(){
		//driver.close();
		driver.quit();
//		System.exit(0);
	}
	
}
