package page;

import base.DriverBase;
import util.GetByLocator;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    public LoginPage(DriverBase driverBase) {
        super(driverBase);
        // TODO Auto-generated constructor stub
    }
    /*
     * 获取用户名输入框Element
     *
     * */
    public WebElement getUserElement() {
        //找到properties中的userName变量
        return element(GetByLocator.getLocator("yunuser"));
    }

    /*
     * 获取密码输入框Element
     *
     * */
    public WebElement getPasswordElement() {
        return element(GetByLocator.getLocator("yunpassword"));
    }

    /*
     * 获取登录按钮element
     *
     * */
    public WebElement getLoginButtonElement() {
        return element(GetByLocator.getLocator("yunbutton"));
    }

    /*
     * 获取自动登录Element勾选框
     *
     * */
//    public WebElement getAutoLoginElement() {
//        return element(GetByLocator.getLocator("autoSigin"));
//    }

}
