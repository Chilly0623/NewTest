package cases;

import operation.Start_Chrome;
import org.testng.annotations.AfterSuite;

/**
 * Created by Administrator on 2017/6/28.
 */

public class Driver_quit extends Start_Chrome {

    @AfterSuite
    public void driver_quit() throws InterruptedException {
        driver.quit();
    }
}
