package com.bars;

import com.codeborne.selenide.junit.ScreenShooter;
import com.codeborne.selenide.junit.TextReport;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.*;
import org.junit.rules.TestRule;
import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.*;


public class BaseLoginTest {
    private static LoginPage loginPage = new LoginPage();
    private static SearchPage searchPage = new SearchPage();
    private static SwitchWindow switchWindow = new SwitchWindow();

    @Rule
    public ScreenShooter screenShooter = ScreenShooter.failedTests().to("test-results/reports");
    @Rule
    public TestRule report = new TextReport().onFailedTest(true).onSucceededTest(false);
    @BeforeClass
    public static void setup() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));
//        Configuration.fastSetValue=true;
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
        switchWindow.switchToMainFrame();
        searchPage.h1();
        switchWindow.switchToDefaultContent();
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
        switchWindow.switchToDefaultContent();
    }


}

