package TestCase;
import org.apache.commons.csv.CSVRecord;
import org.openqa.selenium.By;
import org.testng.Assert;
import base.DriverBase;
import business.LoginPro;
import com.csvreader.CsvReader;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import util.CsvUtility;
import javax.sql.rowset.serial.SerialStruct;
import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeUnit;

public class Yun_Login_Test extends  CaseBase{
    public  DriverBase driver;
    public LoginPro loginPro;
    //构造方法
    @BeforeTest
    public void setUp() {
        //确定运行脚本的为chrome浏览器，并且赋值给当前类的DriverBase
        this.driver=InitDriver("chrome");
        loginPro=new LoginPro(driver);
        driver.get("http://erp-test.qihaiyun.com");
        driver.maximize_window();
        //隐式等待10秒
        driver.implicitly_time(10);
        //页面加载超时时间设置为5s
        // driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        //driver.manage.script_timeout = 3 #seconds
        //driver.driver.manage().timeouts().setScriptTimeout(3, TimeUnit.SECONDS);


    }

    @AfterTest
    public  void tearDown(){
        driver.close();
    }

    @Test
    public void testLogin() throws FileNotFoundException {

        // 打开 Csv文件
        CsvUtility utility = new CsvUtility();
        Iterable<CSVRecord> csvData =
                utility.readCsvFile("F:\\Java_Auto_Web\\src\\main\\resources\\logintest.csv");

        // 布尔型 true false
        boolean isFirstLine = true;
        // 循环每一个行，接下来根据每一行的值（数据），进行测试
        for (CSVRecord row : csvData) {
            if (isFirstLine) {
                isFirstLine = false;
                continue;
                // continue的作用
                // 当前循环到此为止，直接进入下一条循环
            }
            //获取登录用户和密码
            String account = row.get(0);
            String password = row.get(1);
            String exception = row.get(2);
            String type = row.get(3);
            //登录系统
            loginPro.login(account, password);
            //页面跳转，设置等待时间
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (type.equals("1")) {
                //断言,截图
                try {
                    Assert.assertEquals(driver.getUrl(), "http://erp-test.qihaiyun.com/#/home");

                } catch(Exception e){
                    System.out.println("断言失败，已截图");
                }
                finally {
                    //点击退出
                    driver.findElement(By.className("el-button")).click();
                }
                }
                else if (type.equals("2")) {
                    //driver.get_screenshot();
                    //断言
                    Assert.assertEquals(driver.get_text(By.className("el-message-box__message")),exception);
                    //确定
                    driver.findElement(By.xpath("html/body/div[2]/div/div[3]/button")).click();
                    //刷新页面
                    driver.refresh();
                } else if (type.equals("3")) {
                    //断言
                    Assert.assertEquals(driver.get_text(By.className("el-message-box__message")),exception);
                    //driver.get_screenshot();
                    driver.findElement(By.xpath("html/body/div[2]/div/div[3]/button")).click();
                    driver.refresh();
                } else {
                    //断言
                    Assert.assertEquals(driver.get_text(By.className("el-message-box__message")),exception);
                    //driver.get_screenshot();
                    driver.findElement(By.xpath("html/body/div[2]/div/div[3]/button")).click();
                    driver.refresh();
                }
            }
        }
    }


