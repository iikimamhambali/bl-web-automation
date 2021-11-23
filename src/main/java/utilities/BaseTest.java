package utilities;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

public class BaseTest {

    public static ThreadLocal<Config[]> threadLocalConfig = new ThreadLocal<Config[]>();

    @DataProvider(name = "getTestConfig")
    public Object[][] getTestConfiguration(Method method) {
        Config testConfig = new Config();
        testConfig.testcaseName = method.getName();

        threadLocalConfig.set(new Config[]{testConfig});
        return new Object[][]{{testConfig}};
    }

    @AfterMethod
    public void afterMethod() {
        Config[] testConfigs = threadLocalConfig.get();
        for (Config testConfig : testConfigs) {
            if (testConfig.driver != null) {
                testConfig.driver.quit();
                testConfig.logComment("Browser is closed now.");
            }
        }
    }

    public static void main(String[] args){

    }
}
