package operation;

import base.TestData;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.net.URL;

/**
 * Created by Administrator on 2017/6/27.
 */
public class Start_Chrome extends TestData {
    public static AndroidDriver driver;

    @BeforeSuite
    public void setUp() throws Exception{
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("noReset",true); //不初始化浏览器
        capabilities.setCapability("unicodeKeyboard", "True"); //设置中文输入
        capabilities.setCapability("resetKeyboard", "True");
        capabilities.setCapability("platformName","Android");  //平台名称
        capabilities.setCapability("deviceName","Honor 8");  //设备名称
        capabilities.setCapability("platformVersion", "7.0");  //模拟器版本
        capabilities.setCapability("appPackage", "com.android.chrome");   //测试apk包的名称
        capabilities.setCapability("appActivity", "org.chromium.chrome.browser.ChromeTabbedActivity");  //activity的名称
        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);   //appium的链接地址
        System.out.println("app is launched!");
    }
}
