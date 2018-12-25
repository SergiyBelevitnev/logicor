import base.BasePageLC;
import base.URL;
import org.testng.annotations.Test;

  @Test
public class DeletingItems extends BasePageLC {
    public void deleteAllItemsAdmin() {

        openURL(URL.ADMIN_TEST.toString() +"/admin/property/index");
        deleteAllItemsLogikor("//*[@id='w0']/table/tbody/tr/td/div", "//*[@id='w0']/table/tbody/tr[1]/td[7]/a/span");
    }
}
