package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//判断并且选择自动化运行的浏览器类型
public class SelectDriver {

    public WebDriver driverName(String browser) {
        //equalsIgnoreCase代表不区分大小写
        //判断浏览器的类型是"firefox"或者"chrome"又或者是"IE"
        if(browser.equalsIgnoreCase("fireFox"))
        {
            System.setProperty("webdriver.firefox.marionette", "D:\\java\\geckodriver\\geckodriver.exe");
            return new FirefoxDriver();
        }else{
            System.setProperty("webdriver.chrome.driver","F:\\JavaWeb_auto\\Auto_Spring\\driver\\chromedriver.exe");
            return new ChromeDriver();
        }

    }

}

