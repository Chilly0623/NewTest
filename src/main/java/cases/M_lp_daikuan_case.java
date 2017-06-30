package cases;

import operation.Close_ChromeTab;
import operation.Start_Chrome;
import org.testng.annotations.Test;
import pages.M_lp_daikuan;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;



/**
 * Created by Administrator on 2017/6/27.
 * 这个用例使用的是M_lp_daikuan页面
 */

public class M_lp_daikuan_case extends Start_Chrome {
    private String Url;
    private M_lp_daikuan page;

    @Test(dataProvider="providerMethod")
    public void M_lp_daikuan(Map<?, ?> param)  throws InterruptedException
    {
        this.Url = "http://m.rongzi.com/lp/daikuan";
        driver.get(this.Url);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        this.page = new M_lp_daikuan(this.driver);

        List<String> inforParam = new ArrayList<>();
        inforParam.add(param.get("city").toString());
        inforParam.add(param.get("name").toString());
        inforParam.add(param.get("sex").toString());
        inforParam.add(param.get("phone").toString());

        try {
            this.page.daikuan(inforParam, driver);
            //补充断言
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            Close_ChromeTab closetab = new Close_ChromeTab();
            closetab.close_tabs(driver);
        }
    }
}
