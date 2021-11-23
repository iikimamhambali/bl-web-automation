package utilities;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.FileInputStream;
import java.util.Enumeration;
import java.util.Properties;

public class Config {

    public static String environment;
    public static String browserName;
    public static String browserVersion;
    public static String resultsDirectory;
    public static boolean isRemoteExecution = true;
    public static boolean isDebugMode = false;
    public static String osName = System.getProperty("os.name");
    public WebDriver driver = null;
    public boolean endExecutionOnfailure = false;
    String testLog = "";
    public String testcaseName;
    SoftAssert softAssert = null;
    Properties runTimeProperties = null;
    boolean enableScreenshot = true;
    boolean testResult = true;
    boolean retry = true;

    public Config() {
        softAssert = new SoftAssert();
        runTimeProperties = new Properties();
        Properties properties = null;
        // Code to read .properties file and put key value pairs into RunTime Property file
        try {
            String parametersPath = System.getProperty("user.dir") + File.separator + "Parameters" + File.separator;
            FileInputStream fileInputStream = new FileInputStream(parametersPath + "config.properties");
            properties = new Properties();
            properties.load(fileInputStream);
            fileInputStream.close();
        } catch (Exception e) {
            logComment("Exception while reading config.properties file...");
            e.printStackTrace();
        }

        Enumeration<Object> enumeration = properties.keys();
        while (enumeration.hasMoreElements()) {
            String str = (String) enumeration.nextElement();
            putRunTimeProperty(str, (String) properties.get(str));
        }

        // override param values if passed through TestNG.xml
        if (!StringUtils.isEmpty(resultsDirectory)) {
            putRunTimeProperty("ResultsDirectory", resultsDirectory);
        } else {
            resultsDirectory = System.getProperty("user.dir") + File.separator + "test-output";
            putRunTimeProperty("ResultsDirectory", resultsDirectory);
        }
        if (!StringUtils.isEmpty(browserName))
            putRunTimeProperty("Browser", browserName);
        if (!StringUtils.isEmpty(browserVersion))
            putRunTimeProperty("BrowserVersion", browserVersion);

        // Putting values into variables from RunTime properties
        endExecutionOnfailure = endExecutionOnfailure || getRunTimeProperty("EndExecutionOnFailure").equalsIgnoreCase("true");
        isRemoteExecution = isRemoteExecution || getRunTimeProperty("RemoteExecution").equalsIgnoreCase("true");
        isDebugMode = isDebugMode || getRunTimeProperty("debugMode").equalsIgnoreCase("true");
        environment = getRunTimeProperty("Environment");
    }

    /**
     * Add the given key value pair in the Run Time Properties
     *
     * @param key
     * @param value
     */
    public void putRunTimeProperty(String key, String value) {
        if (isDebugMode)
            logComment("Putting RunTime key-" + key.toLowerCase() + " value:-'" + value + "'");
        runTimeProperties.put(key.toLowerCase(), value);
    }

    /**
     * Add the given key value pair in the Run Time Properties
     *
     * @param key
     * @param value
     */
    public void putRunTimeProperty(String key, Object value) {
        String keyName = key.toLowerCase();
        runTimeProperties.put(keyName, value);
        if (isDebugMode)
            logComment("Putting Run-Time key-" + keyName + " value:-'" + value + "'");
    }

    /**
     * Get the Run Time Property value
     *
     * @param key name whose value is needed
     * @return value of the specified key
     */
    public String getRunTimeProperty(String key) {
        String keyName = key.toLowerCase();
        String value = "";
        try {
            value = runTimeProperties.get(keyName).toString();
            if (isDebugMode)
                logComment("Read RunTime Property -'" + keyName + "' as -'" + value + "'");
        } catch (Exception e) {
            if (isDebugMode)
                logComment("'" + key + "' not found in Run Time Properties");
            return null;
        }
        return value;
    }

    /**
     * Replaces the arguments like {$someArg} present in input string with its value from RuntimeProperties
     *
     * @param input string in which some Argument is present
     * @return replaced string
     */
    public String replaceArgumentsWithRunTimeProperties(String input) {
        if (input.contains("{$")) {
            int index = input.indexOf("{$");
            input.length();
            input.indexOf("}", index + 2);
            String key = input.substring(index + 2, input.indexOf("}", index + 2));
            String value = getRunTimeProperty(key);
            input = input.replace("{$" + key + "}", value);
            return replaceArgumentsWithRunTimeProperties(input);
        }
        return input;
    }

    public void logComment(String message) {
        Log.Comment(this, message);
    }

    public void logCommentJson(String message, String color) {
        Log.CommentJson(this, message, color);
    }

    public void logColorfulComment(String message, String color) {
        Log.Comment(this, message, color);
    }

    public void logCommentForDebugging(String message) {
        if (isDebugMode)
            Log.Comment(this, message);
    }

    public void logWarning(String message) {
        Log.Warning(this, message);
    }

    public void logWarning(String message, boolean pageCapture) {
        Log.Warning(this, message, pageCapture);
    }

    public void logWarning(String what, String expected, String actual) {
        String message = "Expected '" + what + "' was :-'" + expected + "'. But actual is '" + actual + "'";
        Log.Warning(this, message);
    }

    public void logFail(String message) {
        testResult = false;
        Log.Fail(this, message);
    }

    public void logFailToEndExecution(String message) {
        Browser.takeScreenshot(this);
        enableScreenshot = false;
        retry = false;
        endExecutionOnfailure = true;
        testResult = false;
        Log.Fail(this, message);
    }

    public <T> void logFail(String what, T expected, T actual) {
        testResult = false;
        String message = "Expected '" + what + "' was :-'" + expected + "'. But actual is '" + actual + "'";
        Log.Fail(this, message);
    }

    public void logPass(String message) {
        Log.Pass(this, message);
    }

    public <T> void logPass(String what, T actual) {
        String message = "Verified '" + what + "' as :-'" + actual + "'";
        Log.Pass(this, message);
    }

    public void logExceptionAndFail(Throwable e) {
        logExceptionAndFail("", e);
    }

    public void logExceptionAndFail(String message, Throwable e) {
        testResult = false;
        String fullStackTrace = ExceptionUtils.getStackTrace(e);
        Log.Fail(this, message + "\nException Message:- " + fullStackTrace);
    }
}
