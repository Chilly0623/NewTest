package pages;

import operation.NumSwipe;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/6/27.
 * 这个页面中还使用了M_lp_city页面
 */
public class M_lp_daikuan {

    // 获取页面元素
    @FindBy(id="currentCity")
    @CacheLookup
    public WebElement CITY;

    @FindBy(id="userName")
    @CacheLookup
    public WebElement NAME;

    @FindBy(id="buttonMan")
    @CacheLookup
    public WebElement MAN_SELECT;

    @FindBy(id="buttonWoman")
    @CacheLookup
    public WebElement WOMAN_SELECT;

    @FindBy(id="cellPhoneNumber")
    @CacheLookup
    public WebElement PHONE;

    @FindBy(id="inputImgCode")
    @CacheLookup
    public WebElement IMGCODE;

    @FindBy(id="inputSmsCode")
    @CacheLookup
    public WebElement SMSCODE;

    @FindBy(id="oneKeyBtnSubmit")
    @CacheLookup
    public WebElement SUBMIT;


    // 声明对象时，自动加载页面
    public M_lp_daikuan(AndroidDriver driver) {
        PageFactory.initElements(driver, this); //初始化
    }

    public NumSwipe Swipe = new NumSwipe();

    public M_lp_city SelCity = new M_lp_city();

    public void city_click() throws InterruptedException {
        CITY.click();
        System.out.println("open city page success!");
    }

    public void name_input(String name) throws InterruptedException {
        NAME.clear();
        NAME.sendKeys(name);
        System.out.println("input name success!");
    }

    public void sex_select(String sex) throws InterruptedException {
        if (sex.equals("先生")){
            MAN_SELECT.click();
        }else{
            WOMAN_SELECT.click();
        }
        System.out.println("select sex success!");
    }

    public void phone_input(String phone) throws InterruptedException {
        PHONE.clear();
        PHONE.sendKeys(phone);
        System.out.println("input phone success!");
    }

    public void imgcode_input() throws InterruptedException {
        IMGCODE.clear();
        IMGCODE.sendKeys("1234");
        System.out.println("input imgcode success!");
    }

    public void smscode_input() throws InterruptedException {
        SMSCODE.clear();
        SMSCODE.sendKeys("123456");
        System.out.println("input smscode success!");
    }

    public void click_button() {
        SUBMIT.click();
        System.out.println("submit success!");
    }

    public void daikuan(List<String> params, AndroidDriver driver) throws InterruptedException {
        city_click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        SelCity.select_city(driver, params.get(0)); //选择贷款城市

        Swipe.swipeToUp(driver, 1000, 1); //向上滑动屏幕1次
        System.out.println("swipe up 1 success!");

        name_input(params.get(1)); //输入其它信息
        sex_select(params.get(2));
        phone_input(params.get(3));
        //driver.pressKeyCode(AndroidKeyCode.ENTER);  //没有禁止虚拟键盘的时候，输入右下方确认键

        imgcode_input(); //输入图形验证码

        //向上滑动屏幕，不滑动定位不到提交按钮，可能和H5设计有关
        Swipe.swipeToUp(driver, 1000, 1);
        System.out.println("swipe up 2 success!");

        smscode_input(); //输入短信验证码

        click_button(); //点击按钮
    }
}
