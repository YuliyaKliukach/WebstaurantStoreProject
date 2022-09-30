package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class CommonMethods extends PageManager{
    public static WebDriver driver;

    //open browser method with WebDriverManager
    public static void setUp(){
        ConfigReader.readProperties(Constants.CONFIGURATION_FILEPATH);
        switch(ConfigReader.getPropertyValue("browser")){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver=new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver=new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("Invalid browser input");
        }

        driver.get(ConfigReader.getPropertyValue("url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);
    }

    //wait method
    public static WebDriverWait getWait(){
        WebDriverWait wait=new WebDriverWait(driver,Constants.EXPLICIT_WAIT);
        return wait;
    }

    //clicking on WebElement
    public static void click(WebElement element){
       element.click();
   }

    //sending text to WebElement
    public static void sendText(WebElement element,String text){
        element.clear();
        element.sendKeys(text);
    }

    //creating JavaScript executor object
    public static JavascriptExecutor getJSexecutor(){
        JavascriptExecutor js=(JavascriptExecutor) driver;
        return js;
    }

    //JavaScript scroll by method
    public static void jsScrollBy(){
        getJSexecutor().executeScript("window.scrollBy(0,500)");

    }

    public static void jsScrollByElement(WebElement element){
        getJSexecutor().executeScript("arguments[0].scrollIntoView(true);", element);
    }
    //closing driver
    public static void tearDown(){
        if(driver!=null){
            driver.quit();
        }
    }
}
