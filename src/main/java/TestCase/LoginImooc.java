package TestCase;
import business.LoginPro;
import base.DriverBase;
import org.openqa.selenium.By;
//import org.junit.*;
//import org.testng.*;
public class LoginImooc extends CaseBase {

    public DriverBase driverBase;
    public LoginPro loginPro;
    //构造方法
    public LoginImooc() {
        //确定运行脚本的为chrome浏览器，并且赋值给当前类的DriverBase
        this.driverBase=InitDriver("chrome");
        loginPro=new LoginPro(driverBase);
    }
    //@Test
    public void getLoginHome() {
        driverBase.get("http://www.imooc.com");
        driverBase.getDriver().manage().window().maximize();
        //点击登录
        //driverBase.findElement(By.id("js-signin-btn")).click();
        driverBase.driver.findElement(By.id("js-signin-btn")).click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    //@Test
    public void testLogin() {
        loginPro.login("lvwucn@sina.com", "lou342349156");
    }

    public static void  main(String[] arges){
        LoginImooc login = new LoginImooc();
            login.getLoginHome();
            login.testLogin();

    }

}
