package TestCase;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import util.CsvUtility;
import business.LoginPro;
import base.DriverBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class YunErp_Login_test extends  CaseBase{

    public static DriverBase driverBase;
    public LoginPro loginPro;
    //构造方法
    public YunErp_Login_test() {
        //确定运行脚本的为chrome浏览器，并且赋值给当前类的DriverBase
        this.driverBase=InitDriver("chrome");
        loginPro=new LoginPro(driverBase);
    }
    @BeforeTest
    public void setUp() {
        driverBase.get("http://erp-test.qihaiyun.com");
        driverBase.getDriver().manage().window().maximize();


        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    @AfterTest
    public  void tearDown(){
        driverBase.close();
    }
    @Test
    public void logintest() {
        loginPro.login("999", "123456");

        System.out.println("This page title is :"+driverBase.driver.getTitle());
    }





}
