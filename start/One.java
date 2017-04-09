package start;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.*;


/**
 * Created by bennyhuo on 2017/4/7.
 */
public class One {
    WebDriver driver;
    String faName;
    String baseurl ;
    WebDriverWait wait;
    public One(String definedFaName){
        faName=definedFaName;
    }
    public One(){
        faName ="fuscdrmsmc88";
//        faName = "adcgen15";
    }
    @BeforeTest
    public void launchBrowser() {
        System.setProperty("webdriver.firefox.bin", "C:\\program Files\\Mozilla Firefox\\firefox.exe");
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\bennyhuo\\IdeaProjects\\selenium\\geckodriver.exe");
        DesiredCapabilities cap = DesiredCapabilities.firefox();
        cap.setCapability("marionette", true);
        ProfilesIni profile = new ProfilesIni();
        FirefoxProfile myProfile = profile.getProfile("cheryl");
        myProfile.setAcceptUntrustedCertificates(true);
        myProfile.setAssumeUntrustedCertificateIssuer(false);
        cap.setCapability(FirefoxDriver.PROFILE, myProfile);
        cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        //firefoxOptions.setProfile(myProfile).addDesiredCapabilities(cap);
        driver = new FirefoxDriver(cap);

        baseurl= "https://"+faName+"-fa-ext.us.oracle.com/homePage/faces/AtkHomePageWelcome";
//        baseurl = "https://"+faName+".us.oracle.com:10614/homePage";
        wait = new WebDriverWait(driver,50);
    }
    @Test(priority = 0)
    public void verifyHomepage(){
        driver.get(baseurl);
        try{
            wait.until(ExpectedConditions.titleIs("Sign In"));
        }catch(TimeoutException e){
            System.out.println(e.toString());
        }

    }
    @Test(priority = 1)
    public void verifyLogin(){
        WebElement username = driver.findElement(By.id("userid"));
        WebElement passwd = driver.findElement(By.id("password"));
        try{
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("userid")));
            username.sendKeys("ZHRA-HRSPC1");
            passwd.sendKeys("Welcome1");
            passwd.submit();
        }catch(TimeoutException e){
            System.out.println(e.toString());
        }
        try{
            wait.until(ExpectedConditions.titleIs("Welcome"));
        }catch(TimeoutException e){
            System.out.println(e.toString());
        }
    }
    @Test(priority = 2)
    public void clickNavigator(){
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pt1:_UISmmLink::icon")));
            WebElement navigator = driver.findElement(By.id("pt1:_UISmmLink::icon"));
            navigator.click();
        }catch(TimeoutException e){
            System.out.println(e.toString());
        }
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pt1:_UISmmp::popup-container")));
        }catch(TimeoutException e){
            System.out.println(e.toString());
        }

    }
 //   @Test(priority = 3)
    public void clickPerformance(){
        WebElement performance = driver.findElement(By.id("pt1:nv_WORKFORCE_MANAGEMENT_HRA_HCMPERFORMANCE_FUSE_PERFORMANCE"));
        wait.until(ExpectedConditions.visibilityOf(performance));
        performance.click();
        wait.until(ExpectedConditions.titleIs("My Evaluations - Performance - Oracle Applications"));

    }
//    @Test(priority = 4)
    public void cancelPD(){

    }
//    @Test(priority = 5)
    public void deletePD(){

    }
//    @Test(priority = 6)
    public void logOut(){

    }
    @AfterTest
    public void exitBrowser(){
        driver.quit();
    }



}
