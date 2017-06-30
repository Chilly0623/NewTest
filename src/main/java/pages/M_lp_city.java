package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/6/27.
 */
public class M_lp_city {

    public void select_city(AndroidDriver<AndroidElement> driver, String city) throws InterruptedException {
        //选择贷款城市
        driver.findElementByAccessibilityId(city).click();
        System.out.println("select city success!");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
}
