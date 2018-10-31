package page;

import base.DriverBase;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebElement;

import java.util.List;

//基本页面的类方法
public class BasePage {

    public DriverBase driver;
    //构造方法
    public BasePage(DriverBase driverBase) {
        //把初始化传入的DriverBase赋值给当前BasePage类的DriverBase的变量
        this.driver=driverBase;
    }

    /*
     * 定位Element
     *
     * @param By by
     *
     * */
    public WebElement element(By by) {
        WebElement ele=driver.findElement(by);
        return ele;
    }

    /*
     * 封装click（点击）方法
     * 需要传入一个WebElement类型的元素
     *
     * */
    public void click(WebElement element) {
        if(element!=null) {
            element.click();
        }else {
            System.out.println("元素未定位到,定位失败");
        }
    }

    /*
     * 封装输入方法
     *
     * */
    public void sendKeys(WebElement element, String value) {
        if(element!=null) {
            element.sendKeys(value);
        }else {
            System.out.println(element+"元素没有定位到,输入失败"+value);
        }
    }

    /*
     * 判断元素是否显示方法
     *
     * */
    public boolean assertElementIs(WebElement element) {
        return element.isDisplayed();
    }

    /**
     * 层级定位,通过父节点定位到子节点
     * 需要传入父节点和子节点的By
     * */
    public WebElement getChildrenElement(By parentBy,By childrenBy) {
        WebElement ele=this.element(parentBy);
        return ele.findElement(childrenBy);
    }
    /**
     * 层级定位传入element，以及子的by
     *
     * */
    public WebElement getChildrenElement(WebElement element,By by){
        return element.findElement(by);
    }

    /**
     * 定位一组elements
     * */
    public List<WebElement> elements(By by){
        return driver.findElements(by);
    }
    /**
     * 通过父节点定位一组elements
     * */
    public List<WebElement> elements(WebElement element,By by){
        return element.findElements(by);
    }


    /*
     * 获取文本信息
     *
     * */
    public String getText(WebElement element) {
        return element.getText();
    }
    /**
     * action事件
     * */
    public void action(WebElement element){
        driver.action(element);
    }
    /**
     * 获取title
     * */
    public String getTitle(){
        return driver.getDriver().getTitle();
    }
    /**
     * 关闭浏览器
     * */
    public void close(){
        driver.getDriver().close();
    }

    /**
     * 获取当前窗口所有的windows
     * */
    public List<String> getWindowsHandles(){
        List<String> handles = driver.getWindowsHandles();
        return handles;
    }

    /**
     * 根据title切换新窗口
     * */
    public boolean switchToWindow_Title(String windowTitle) {
        boolean flag = false;
        try {
            String currentHandle = driver.getWindowHandle();
            List<String> handles = driver.getWindowsHandles();
            for (String s : handles) {
                if (s.equals(currentHandle))
                    continue;
                else {
                    driver.switchWindows(s);
                    if (driver.getDriver().getTitle().contains(windowTitle)) {
                        flag = true;
                        System.out.println("切换windows成功: " + windowTitle);
                        break;
                    } else
                        continue;
                }
            }
        } catch (NoSuchWindowException e) {
            System.out.println("Window: " + windowTitle + " 没找到!!!"
                    + e.fillInStackTrace());
            flag = false;
        }
        return flag;
    }

}
