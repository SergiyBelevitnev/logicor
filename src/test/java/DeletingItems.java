import base.BasePageLC;
import data.URL;
import org.testng.annotations.Test;

  @Test
public class DeletingItems extends BasePageLC {
    public void deleteAllItemsAdmin() {

        openURL(URL.ADMIN.toString() +"/admin/property/index");
        deleteAllItemsLogikor("//*[@id='w0']/table/tbody/tr/td/div", "//*[@id='w0']/table/tbody/tr[1]/td[7]/a/span");
    }
}
