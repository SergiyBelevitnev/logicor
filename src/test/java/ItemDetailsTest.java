import base.BasePageLC;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

@Test

public class ItemDetailsTest extends BasePageLC {
    public void itemDetailsTest(){
        LaunchBrowser("chrome");
        openURL("http://ec2-35-178-97-148.eu-west-2.compute.amazonaws.com/en/fr/find-a-warehouse/warehouse-detail?id=1629");
       System.out.println(getElementText(By.xpath("//*[@id=\"block-system-main\"]/div[2]/div/div/div[4]/div/div[1]/p")));

    }

}
