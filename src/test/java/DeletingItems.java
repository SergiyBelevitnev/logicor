import base.BasePageLC;
import org.testng.annotations.Test;

  @Test
public class DeletingItems extends BasePageLC {
    public void deleteAllItemsAdmin() {

        openURL("http://ec2-3-8-87-222.eu-west-2.compute.amazonaws.com/admin/property/index");
        deleteAllItemsLogikor("//*[@id='w0']/table/tbody/tr/td/div", "//*[@id='w0']/table/tbody/tr[1]/td[7]/a/span");
    }
}
