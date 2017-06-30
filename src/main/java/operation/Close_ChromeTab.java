package operation;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import java.util.List;

/**
 * Created by Administrator on 2017/6/28.
 */
public class Close_ChromeTab {
    /**
     * This Method for close chrome web tabs
     */
    public void close_tabs(AndroidDriver<AndroidElement> driver) throws InterruptedException {
        driver.findElementById("com.android.chrome:id/tab_switcher_button").click();
        Thread.sleep(1000);
        driver.findElementById("com.android.chrome:id/menu_button").click();
        Thread.sleep(1000);
        List<AndroidElement> Fields = driver.findElementsById("com.android.chrome:id/menu_item_text");
        Fields.get(2).click();
        Thread.sleep(1000);
    }
}
