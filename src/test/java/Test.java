import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test {
    public  static  void  main(String[] arges){
        //设置环境变量，指定chromedriver的路径
//        System.setProperty("webdriver.chrome.driver",
//                "F:\\JavaWeb_auto\\Auto_Spring\\driver\\chromedriver.exe");

//        System.setProperty ( "webdriver.firefox.bin",
//                   "E:\\应用程序\\MozilaFirefox\\firefox.exe");
        System.setProperty ( "webdriver.firefox.bin",
                "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");

        WebDriver driver = new FirefoxDriver();


        driver.get("http://erp-test.qihaiyun.com");

        driver.findElement(By.xpath(".//*[@id='app']/div/div[1]/div[2]/div[2]/div[1]/input")).sendKeys("999");

        driver.findElement(By.xpath(".//*[@id='app']/div/div[1]/div[2]/div[2]/div[2]/input")).sendKeys("123456");

        driver.findElement(By.xpath("//*[@id='app']/div/div[1]/div[2]/div[2]/div[3]/button")).click();

//        driver.findElement(By.xpath(".//*[@id='app']/div/div[1]/button")).click();
//        System.out.println("The testing page title is: " + driver.getTitle());

        driver.quit();


    }
}
