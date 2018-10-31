package util;

import org.openqa.selenium.By;

public class GetByLocator {

    public static By getLocator(String key) {
        //properties文件路径，返回元素属性
        ProUtil proUtil=new ProUtil("F:\\Web_Auto_Java\\element.properties");
        String locator=proUtil.getPro(key);
        String locatorType=locator.split(">")[0];
        String locatorValue=locator.split(">")[1];

        if(locatorType.equals("id"))
        {
            return By.id(locatorValue);
        }
        else if(locatorType.equals("name"))
        {
            return By.name(locatorValue);
        }
        else if(locatorType.equals("className"))
        {
            return By.className(locatorValue);
        }
        else if(locatorType.equals("link_text"))
        {
             return By.linkText(locatorValue);
        }
        else if(locatorType.equals("xpath"))
        {
            return By.xpath(locatorValue);
        }
        else
        {
            return By.tagName(locatorValue);
        }
    }
}
