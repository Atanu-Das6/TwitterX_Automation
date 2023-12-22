package Project_FrameWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PageElements_Search {
    public WebDriver webDriver;
    @FindBy(xpath = "//input[@placeholder='Search']")
    WebElement serach_link;

    public PageElements_Search(WebDriver webDriver) {
        this.webDriver=webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public  void  search_karo(String ss)  throws InterruptedException{
        serach_link.sendKeys(ss);
        Thread.sleep(3000);
        List<WebElement> options = webDriver.findElements(By.xpath("span[@class='css-1qaijid r-dnmrzs r-1udh08x r-3s2u2q r-bcqeeo r-qvutc0 r-poiln3']"));
        ////span[@class='css-1qaijid r-dnmrzs r-1udh08x r-3s2u2q r-bcqeeo r-qvutc0 r-poiln3']
        ////div[@class='css-175oi2r r-1iusvr4 r-16y2uox r-1777fci']
        for(WebElement option :options)

        {

            if(option.getText().equalsIgnoreCase("Genshin Impact"))

            {

                option.click();

                break;

            }

        }

    }
}
