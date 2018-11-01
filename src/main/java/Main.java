import org.testng.TestNG;
import java.util.ArrayList;
import java.util.List;

/*
* 测试入口
*/
public class Main {

    public static void main(String[] args) {
        TestNG test = new TestNG();
        List<String> suites = new ArrayList<>();
        suites.add("testng.xml");//生成报告配置文件
        test.setTestSuites(suites);//运行测试套件
        test.run();
    }
}
