package operation;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

/**
 * Created by Administrator on 2017/6/28.
 */
public class NumSwipe {

    /**
     * This Method for swipe up
     */
    public void swipeToUp(AndroidDriver<AndroidElement> driver,int during,int num){
        int width = driver.manage().window().getSize().width;//获取当前屏幕的宽度
        int height = driver.manage().window().getSize().height;//获取当前屏幕的高度
        for(int i = 0;i < num;i++){
            driver.swipe(width/2, height/4, width/2, height/8, during);
        }
    }

    /**
     * This Method for swipe down
     */
    public void swipeToDown(AndroidDriver<AndroidElement> driver,int during,int num){
        int width = driver.manage().window().getSize().width;//获取当前屏幕的宽度
        int height = driver.manage().window().getSize().height;//获取当前屏幕的高度
        for(int i = 0;i < num;i++){
            driver.swipe(width/2, height/8, width/2, height/4, during);
        }
    }

    /**
     * This Method for swipe Left
     */
    public void swipeToLeft(AndroidDriver<AndroidElement> driver,int during,int num){
        int width = driver.manage().window().getSize().width;//获取当前屏幕的宽度
        int height = driver.manage().window().getSize().height;//获取当前屏幕的高度
        for(int i = 0;i < num;i++){
            driver.swipe(width*3/4, height/2, width/4, height/2, during);
        }
    }

    /**
     * This Method for swipe right
     */
    public void swipeToRight(AndroidDriver<AndroidElement> driver,int during,int num){
        int width = driver.manage().window().getSize().width;//获取当前屏幕的宽度
        int height = driver.manage().window().getSize().height;//获取当前屏幕的高度
        for(int i = 0;i < num;i++){
            driver.swipe(width/4, height/2, width*3/4, height/2, during);
        }
    }
}
