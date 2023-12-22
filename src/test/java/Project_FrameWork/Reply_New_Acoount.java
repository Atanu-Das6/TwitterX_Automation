package Project_FrameWork;

import Utill.ExtentReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


@Listeners(ExtentReporter.class)

public class Reply_New_Acoount {
    public WebDriver webDriver;
    public  String string;
    public Properties properties;
    public PageElements_FirstComment_Reply pageElements_firstComment_reply;
    public  PageElements_SignInAccount pageElementsSignInAccount;

    @BeforeClass()
    public void Invoke_Broswer() {
        properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream("Setup.properties");
            properties.load(fileInputStream);
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        string= properties.getProperty("url");
        String broswer = properties.getProperty("broswername");

        if (broswer.equalsIgnoreCase("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--remote--allow-origins=*");
            webDriver = new ChromeDriver(chromeOptions);
            webDriver.get(string);
            webDriver.manage().window().maximize();
            webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            String name = webDriver.getTitle();
            System.out.println("Title of the SITE " +name);


        }
        else {
            WebDriverManager.edgedriver().setup();
            webDriver = new EdgeDriver() ;
            webDriver.get(string);
            webDriver.manage().window().maximize();
            webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            String name = webDriver.getTitle();
            System.out.println("Title of the SITE " +name);
        }
    }
    @DataProvider(name = "data-providerB")
    public Object[][] getUserDat() {
        return new Object[][]{
                {"Hello", "World"},
                // Add more sets of data as needed
        };
    }
    @Test(dataProvider = "data-providerB")
    void Reply(String string,String s) throws InterruptedException {
        String post = string.concat(s);
        pageElementsSignInAccount = new PageElements_SignInAccount(webDriver);
        pageElementsSignInAccount.Sign_CreateAccount("TestAutoma69","JavaSelenium_Testng");
        pageElements_firstComment_reply = new PageElements_FirstComment_Reply(webDriver);
        pageElements_firstComment_reply.Post_reply(post);
    }
    @AfterClass
    void  End_session() throws IOException {

        Screenshot Screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(webDriver);

        ImageIO.write(Screenshot.getImage(), "jpg", new File(System.getProperty("user.dir")+"\\screenshots\\fullscreenREPLYPOST.jpg"));

        webDriver.close();

    }
}
