package test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class One {
	public static void main(String[] args){
		
//		System.setProperty("webdriver.firefox.marionette","C:\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		String baseurlString="http://newtours.demoaut.com";
		String expectedTitleString="Welcome: Mercury Tours";
		String actualTitleString="";
		driver.get(baseurlString);
		actualTitleString=driver.getTitle();
		if(actualTitleString.contentEquals(expectedTitleString)){
			System.out.println("test passed");
		}else{
			System.out.println("test failed");
		}
		driver.close();
		System.exit(0);
	}
	
}
