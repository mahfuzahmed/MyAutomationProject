package TestFramework.java.Modules;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Browser {

    public static WebDriver driver;

    public static Properties prop = new Properties();

    public static FileReader fr;

    public void setup() throws IOException {

        if(driver==null){
            FileReader  fr = new FileReader("src/TestFramework/resources/configfiles/config.properties");
            prop.load(fr);
        }
        if(prop.getProperty("browser").equalsIgnoreCase("Chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.get(prop.getProperty("testurl"));
            driver.manage().window().maximize();
        }
        else if (prop.getProperty("browser").equalsIgnoreCase("Firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.get(prop.getProperty("testurl"));
            driver.manage().window().maximize();
        }
        System.out.println("Setup Successful");
    }

    public void teardown(){
        driver.close();
        System.out.println("Teardown Successful");

    }
}
