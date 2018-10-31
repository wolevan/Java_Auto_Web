package TestCase;

import base.DriverBase;

//初始化浏览器
public class CaseBase {

        public DriverBase InitDriver(String browser) {

            DriverBase driver = new DriverBase(browser);
            return driver;
        }
}
