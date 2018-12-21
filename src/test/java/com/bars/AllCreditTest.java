package com.bars;

import com.codeborne.selenide.junit.ScreenShooter;
import com.codeborne.selenide.junit.TextReport;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class AllCreditTest {
    //    private LoginPage loginPage = page(LoginPage.class);
    private static LoginPage loginPage = new LoginPage();
    private Calculation calculation = page(Calculation.class);
    private NewCreditPage newCreditPage = page(NewCreditPage.class);
    private SearchPage searchPage = page(SearchPage.class);
    private SwitchWindow switchWindow = page(SwitchWindow.class);
    private BriefcaseNewCreditPage briefcaseNewCreditPage = page(BriefcaseNewCreditPage.class);
    private FilterBeforFillingTable filterBeforFillingTable = page(FilterBeforFillingTable.class);
    private WorkCreditPage workCreditPage = page(WorkCreditPage.class);
    @Rule
    public ScreenShooter screenShooter = ScreenShooter.failedTests().to("test-results/reports");
    @Rule
    public TestRule report = new TextReport().onFailedTest(true).onSucceededTest(false);
    @BeforeClass
    public static void setup() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));
//        Configuration.fastSetValue=true;
        timeout = 80000;
//        baseUrl = getPolygon(); /*!!!!Выбор полигона!!!!*/
//        browser = "chrome";
//        browser = "ie";
        startMaximized = true;
//        System.setProperty("webdriver.ie.driver", ".\\IEDriverServer.exe");
        InternetExplorerDriverManager.getInstance(DriverManagerType.IEXPLORER).arch32().setup();
        open("/");
        //Логин
        loginPage.fillLoginForm(ConfigProperties.getTestProperty("login"), ConfigProperties.getTestProperty("password"));
        loginPage.goOn();
    }



    @Test
    public void creditLegalEntityTest() {

        //Страница поиска
        switchWindow.switchToMainFrame();
        searchPage.h1();
        switchWindow.switchToDefaultContent();
        searchPage.chooseBranch();
        loginPage.prof();
        String base = loginPage.getPolygon();
//        String pol = $x("(//*[text()='База даних:']/following::span)[1]").shouldBe(visible).getText();
        searchPage.searchFunction("Портфель НОВИХ кредитів ЮО");
        switchWindow.switchToMainFrame();
        if(base.equals("RCMMFO"))
        {
            //Робота з фільтром
            filterBeforFillingTable.clearFilter();
            filterBeforFillingTable.furtherButtonClick();
        }
        //Кнопка Новый КД(переключение на окно Нового КД)
        String briefcaseNewKdWindow = getWebDriver().getWindowHandle();
        briefcaseNewCreditPage.pressCreateNewKD();
        switchWindow.forceSwitchToWindow(briefcaseNewKdWindow);
        switchWindow.windowMaximize();
        // !!Заполнение полей КД!!
        // Вкладка Параметри КД
        String newKdWindow = getWebDriver().getWindowHandle();
        String numSum = calculation.randomNum();
        newCreditPage.fillNumSum(numSum, numSum);
        newCreditPage.initiativeButtonClick();
        newCreditPage.filterInput(ConfigProperties.getTestProperty("branch"));
        switchWindow.switchToOldWindow(newKdWindow);
        newCreditPage.okpoButtonClick();
        newCreditPage.filterInputClick();
        newCreditPage.filterInput(ConfigProperties.getTestProperty("rnkfo"));
        switchWindow.switchToOldWindow(newKdWindow);
        newCreditPage.ratesInput(ConfigProperties.getTestProperty("rate"));
        newCreditPage.typeOfCredit("ЮО Стандартний");
        newCreditPage.goalOfCredit("Поточна дiяльнiсть");
        newCreditPage.productOfCredit1();
        switchWindow.switchToOldWindow(newKdWindow);
        newCreditPage.productOfCredit2();
        newCreditPage.filterInput(ConfigProperties.getTestProperty("productfo"));
        if( base.equals("MMFOT")|| base.equals("OBMMFOT1"))
        {
            newCreditPage.chooseGKD("Ні");
        }

        //Вкладка Дані про погашення
        String firstPaymentDate = newCreditPage.getConclusionDate();
        newCreditPage.firstPaymentDate(firstPaymentDate);
        //Вкладка Дод. параметри КД
        newCreditPage.creditInsurance();
        newCreditPage.filterInput("NO");
        switchWindow.switchToOldWindow(newKdWindow);
        newCreditPage.updateParameter();
        newCreditPage.contractStatus();
        newCreditPage.filterInputClick();
        newCreditPage.filterInput("0");
        switchWindow.switchToOldWindow(newKdWindow);
        newCreditPage.updateParameter();
        newCreditPage.creditProduct();
        newCreditPage.filterInputClick();
        newCreditPage.filterInput("2");
        switchWindow.switchToOldWindow(newKdWindow);
        newCreditPage.updateParameter();
        newCreditPage.fillEIBCB();
        newCreditPage.filterInputClick();
        newCreditPage.filterInput("2");
        switchWindow.switchToOldWindow(newKdWindow);
        newCreditPage.updateParameter();
        newCreditPage.fillEIBCE("33");
        newCreditPage.updateParameter();
        newCreditPage.fillEIBCR("33");
        newCreditPage.updateParameter();
        newCreditPage.fillEIBCS();
        newCreditPage.filterInputClick();
        newCreditPage.filterInput("2");
        switchWindow.switchToOldWindow(newKdWindow);
        newCreditPage.updateParameter();
        newCreditPage.fillEIBCW("33");
        newCreditPage.updateParameter();
        newCreditPage.fillEIBIE("33");
        newCreditPage.updateParameter();
        newCreditPage.fillEIBIS();
        newCreditPage.filterInput("NO");
        switchWindow.switchToOldWindow(newKdWindow);
        newCreditPage.updateParameter();
        newCreditPage.fillEIBND("33 тест");
        newCreditPage.updateParameter();
        newCreditPage.fillEIBNE("33 тест");
        newCreditPage.updateParameter();
        newCreditPage.fillEIBPF();
        newCreditPage.filterInputClick();
        newCreditPage.filterInput("1");
        switchWindow.switchToOldWindow(newKdWindow);
        newCreditPage.updateParameter();
        newCreditPage.fillEIBSF();
        newCreditPage.filterInputClick();
        newCreditPage.filterInput("1");
        switchWindow.switchToOldWindow(newKdWindow);
        newCreditPage.updateParameter();
        newCreditPage.fillEIBTV("33");
        newCreditPage.updateParameter();
        newCreditPage.notary();
        newCreditPage.filterInputClick();
        newCreditPage.filterInput("2134");
        switchWindow.switchToOldWindow(newKdWindow);
        newCreditPage.updateParameter();
        //Нажимаем на кнопку "Зберігти"
        newCreditPage.saveButtonClick();
        newCreditPage.confirmOfCreditCreate();
        String newCreditREF = newCreditPage.getREF();
        switchWindow.closeWindow(newKdWindow);
        switchWindow.switchToOldWindow(briefcaseNewKdWindow);
        switchWindow.switchToMainFrame();
        briefcaseNewCreditPage.pressRefreshBriefcase();
        //Авторизація
        workCreditPage.chooseCredit(newCreditREF);
        briefcaseNewCreditPage.сreditAuthorization(ConfigProperties.getTestProperty("autorizationtype"));
        switchWindow.switchToDefaultContent();

/*
        String numSum = "449";
        String firstPaymentDate = "01/08/2018";
*/
        //Портфель Робочих КД ФО
        searchPage.searchFunction("Портфель РОБОЧИХ кредитів ЮО");
        switchWindow.switchToMainFrame();
        //Робота з фільтром
        filterBeforFillingTable.clearFilter();
        filterBeforFillingTable.setUserFilter(newCreditREF);
        filterBeforFillingTable.saveUserFilter(newCreditREF);
        filterBeforFillingTable.deleteUserFilter(newCreditREF);
        filterBeforFillingTable.furtherButtonClick();
        //Портфель Робочих кредитів(Побудава ГПК та Графіку подій по портфелю)
        String workCreditOfLegalEntityBriefcaseWindow = getWebDriver().getWindowHandle();
        workCreditPage.chooseCredit(newCreditREF);
        workCreditPage.buildRepaymentSchedule();
        switchWindow.forceSwitchToWindow(workCreditOfLegalEntityBriefcaseWindow);
        switchWindow.windowMaximize();
        String gpkWindow = getWebDriver().getWindowHandle();
        workCreditPage.getTableName();
        workCreditPage.matchingSumInGPK(numSum+".00");
        switchWindow.closeWindow(gpkWindow);
        switchWindow.switchToOldWindow(workCreditOfLegalEntityBriefcaseWindow);
        switchWindow.switchToMainFrame();
        workCreditPage.chooseCredit(newCreditREF);
        workCreditPage.eventsTimetableOfBriefcaseButton();
        switchWindow.forceSwitchToWindow(workCreditOfLegalEntityBriefcaseWindow);
        switchWindow.windowMaximize();
        workCreditPage.chooseInterval(firstPaymentDate);
        filterBeforFillingTable.clearFilter();
        filterBeforFillingTable.setUserFilter(newCreditREF);
        filterBeforFillingTable.furtherButtonClick();
        String eventsTimetableWindow = getWebDriver().getWindowHandle();
        workCreditPage.progressBar();
        workCreditPage.checkEventsTimetableOfBriefcase(numSum);
        switchWindow.closeWindow(eventsTimetableWindow);
    }

    @AfterClass
    public static void tearDown() {
        SelenideLogger.removeListener("AllureSelenide");
    }

}

