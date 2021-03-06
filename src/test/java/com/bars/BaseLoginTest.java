package com.bars;

import com.bars.generalСlasses.LoginPage;
import com.bars.generalСlasses.SearchPage;
import com.bars.generalСlasses.SwitchWindowOrFrame;
import com.bars.helperClasses.Calculation;
import com.bars.helperClasses.ConfigProperties;
import com.bars.helperClasses.DBoperation;
import com.codeborne.selenide.junit.ScreenShooter;
import com.codeborne.selenide.junit.TextReport;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.*;
import org.junit.rules.TestRule;

import java.sql.SQLException;

import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.open;


public class BaseLoginTest {
    private static LoginPage loginPage = new LoginPage();
    private static SearchPage searchPage = new SearchPage();
    private static SwitchWindowOrFrame switchWindowOrFrame = new SwitchWindowOrFrame();


    @Rule
    public ScreenShooter screenShooter = ScreenShooter.failedTests().to("test-results/reports");
    @Rule
    public TestRule report = new TextReport().onFailedTest(true).onSucceededTest(false);
    @BeforeClass
    public static void setup() throws SQLException {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));
//        Configuration.fastSetValue=true;
        loginPage.changeDbBankDate();
        timeout = 120000;
//        browser = "chrome";
        browser = "ie";
        startMaximized = true;
//        System.setProperty("webdriver.ie.driver", ".\\IEDriverServer.exe");
        InternetExplorerDriverManager.getInstance(DriverManagerType.IEXPLORER).arch32().setup();
        open("/");
        //Логин
        loginPage.writePolygon();
        loginPage.fillLoginForm(ConfigProperties.getTestProperty("login"), ConfigProperties.getTestProperty("password"));
        loginPage.goOn();
        switchWindowOrFrame.mainFrame();
        searchPage.h1();
        switchWindowOrFrame.defaultContent();
        searchPage.chooseBranch();
    }

    @AfterClass
    public static void tearDown() {
        close();
        SelenideLogger.removeListener("AllureSelenide");
    }

    @Before
    public void beforeMethod() {
        open("/");
    }

    @After
    public void afterMethod() {
        switchWindowOrFrame.defaultContent();
    }


}

