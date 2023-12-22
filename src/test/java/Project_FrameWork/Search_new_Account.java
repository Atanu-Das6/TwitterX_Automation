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

public class Search_new_Account {
    public WebDriver webDriver;
    public  String string;
    public Properties properties;
    public PageElements_Search pageElementsSearch;
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
    @DataProvider(name = "data-providerD")
    public Object[][] getUserDat() {
        return new Object[][]{
                {"Helloo", "MYWorld"},
                // Add more sets of data as needed
        };
    }
    @Test(dataProvider = "data-providerD")
    public void Search(String string,String s) throws InterruptedException  {
        pageElementsSignInAccount = new PageElements_SignInAccount(webDriver);
        pageElementsSignInAccount.Sign_CreateAccount("TestAutoma69","JavaSelenium_Testng");
        pageElementsSearch = new PageElements_Search(webDriver);
        String searh="Genshin Impact";
        pageElementsSearch.search_karo("Genshin Impact");


    }

    @AfterClass
    void  End_session() throws IOException {

        Screenshot Screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(webDriver);

        ImageIO.write(Screenshot.getImage(), "jpg", new File(System.getProperty("user.dir")+"\\screenshots\\fullscreenSearch.jpg"));

        webDriver.close();

    }

}
