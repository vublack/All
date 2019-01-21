package com.bars;

import com.codeborne.selenide.junit.ScreenShooter;
import com.codeborne.selenide.junit.TextReport;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class AllCreditTest extends BaseLoginTest {
    //    private LoginPage loginPage = page(LoginPage.class);
    private static LoginPage loginPage = new LoginPage();
    private Calculation calculation = page(Calculation.class);
    private NewCreditPage newCreditPage = page(NewCreditPage.class);
    private static SearchPage searchPage = new SearchPage();
    private static SwitchWindow switchWindow = new SwitchWindow();
    private BriefcaseNewCreditPage briefcaseNewCreditPage = page(BriefcaseNewCreditPage.class);
    private FilterBeforFillingTable filterBeforFillingTable = page(FilterBeforFillingTable.class);
//    private BriefcaseWorkCreditPage briefcaseWorkCreditPage = page(BriefcaseWorkCreditPage.class);
    @Rule
    public ScreenShooter screenShooter = ScreenShooter.failedTests().to("test-results/reports");
    @Rule
    public TestRule report = new TextReport().onFailedTest(true).onSucceededTest(false);

//    @Ignore
    @Test
    public void creditLegalEntityTest() {
        open("/");
        //Страница поиска
        loginPage.prof();
        String base = loginPage.getPolygon();
        searchPage.searchFunction("Портфель НОВИХ кредитів ЮО", "$RM_UCCK");
        switchWindow.switchToMainFrame();
        if(base.equals("RCMMFO"))
        {
            //Робота з фільтром
            filterBeforFillingTable.clearFilter();
            filterBeforFillingTable.furtherButtonClick();
        }
        //Кнопка Новый КД(переключение на окно Нового КД)
        String briefcaseNewKdUoWindow = getWebDriver().getWindowHandle();
        briefcaseNewCreditPage.pressCreateNewKD();
        switchWindow.forceSwitchToWindow(briefcaseNewKdUoWindow);
        switchWindow.windowMaximize();
        // !!Заполнение полей КД!!
        // Вкладка Параметри КД
        String newKdUoWindow = getWebDriver().getWindowHandle();
        String numSum = calculation.randomNum();
        newCreditPage.fillNumSum(numSum, numSum);
//        newCreditPage.initiativeButtonClick();
//        newCreditPage.filterInput(ConfigProperties.getTestProperty("branch"));
//        switchWindow.switchToOldWindow(newKdUoWindow);
        newCreditPage.fillInitiative(ConfigProperties.getTestProperty("branch"));
        newCreditPage.okpoButtonClick();
        newCreditPage.filterInputClick();
        newCreditPage.filterInput(ConfigProperties.getTestProperty("rnkuo"));
        switchWindow.switchToOldWindow(newKdUoWindow);
        newCreditPage.ratesInput(ConfigProperties.getTestProperty("rate"));
//        executeJavaScript("$('#ddlVidd').data('kendoDropDownList').select(1);");
        newCreditPage.typeOfCredit("ЮО Стандартний");
        newCreditPage.goalOfCredit("Поточна дiяльнiсть");
        newCreditPage.productOfCredit1();
        switchWindow.switchToOldWindow(newKdUoWindow);
        newCreditPage.productOfCredit2();
        newCreditPage.filterInput(ConfigProperties.getTestProperty("productuo"));

        if( base.equals("MMFOT")|| base.equals("OBMMFOT1"))
        {
//            newCreditPage.chooseGKD("Ні");
            newCreditPage.chooseGKD();
        }

        //Вкладка Дані про погашення
        String firstPaymentDate = newCreditPage.getConclusionDate();
        newCreditPage.firstPaymentDate(firstPaymentDate);
        //Вкладка Дод. параметри КД
        newCreditPage.creditInsurance();
        newCreditPage.filterInput("NO");
        switchWindow.switchToOldWindow(newKdUoWindow);
        newCreditPage.updateParameter();
        newCreditPage.contractStatus();
        newCreditPage.filterInputClick();
        newCreditPage.filterInput("0");
        switchWindow.switchToOldWindow(newKdUoWindow);
        newCreditPage.updateParameter();
        newCreditPage.creditProduct();
        newCreditPage.filterInputClick();
        newCreditPage.filterInput("2");
        switchWindow.switchToOldWindow(newKdUoWindow);
        newCreditPage.updateParameter();
        newCreditPage.fillEIBCB();
        newCreditPage.filterInputClick();
        newCreditPage.filterInput("2");
        switchWindow.switchToOldWindow(newKdUoWindow);
        newCreditPage.updateParameter();
        newCreditPage.fillEIBCE("33");
        newCreditPage.updateParameter();
        newCreditPage.fillEIBCR("33");
        newCreditPage.updateParameter();
        newCreditPage.fillEIBCS();
        newCreditPage.filterInputClick();
        newCreditPage.filterInput("2");
        switchWindow.switchToOldWindow(newKdUoWindow);
        newCreditPage.updateParameter();
        newCreditPage.fillEIBCW("33");
        newCreditPage.updateParameter();
        newCreditPage.fillEIBIE("33");
        newCreditPage.updateParameter();
        newCreditPage.fillEIBIS();
        newCreditPage.filterInput("NO");
        switchWindow.switchToOldWindow(newKdUoWindow);
        newCreditPage.updateParameter();
        newCreditPage.fillEIBND("33 тест");
        newCreditPage.updateParameter();
        newCreditPage.fillEIBNE("33 тест");
        newCreditPage.updateParameter();
        newCreditPage.fillEIBPF();
        newCreditPage.filterInputClick();
        newCreditPage.filterInput("1");
        switchWindow.switchToOldWindow(newKdUoWindow);
        newCreditPage.updateParameter();
        newCreditPage.fillEIBSF();
        newCreditPage.filterInputClick();
        newCreditPage.filterInput("1");
        switchWindow.switchToOldWindow(newKdUoWindow);
        newCreditPage.updateParameter();
        newCreditPage.fillEIBTV("33");
        newCreditPage.updateParameter();
        newCreditPage.notary();
        newCreditPage.filterInputClick();
        newCreditPage.filterInput("2134");
        switchWindow.switchToOldWindow(newKdUoWindow);
        newCreditPage.updateParameter();
        //Нажимаем на кнопку "Зберігти"
        newCreditPage.saveButtonClick();
        newCreditPage.confirmOfCreditCreate();
        String newCreditRefUo = newCreditPage.getREF();
        switchWindow.closeWindow(newKdUoWindow);
        switchWindow.switchToOldWindow(briefcaseNewKdUoWindow);
        switchWindow.switchToMainFrame();
        briefcaseNewCreditPage.pressRefreshBriefcase();
        //Авторизація
        BriefcaseWorkCreditPage.chooseCredit(newCreditRefUo);
        briefcaseNewCreditPage.creditAuthorization(ConfigProperties.getTestProperty("autorizationtype"));
        switchWindow.switchToDefaultContent();


/*
        String numSum = "449";
        String firstPaymentDate = "01/08/2018";
*/

        //Портфель Робочих КД ФО
        searchPage.searchFunction("Портфель РОБОЧИХ кредитів ЮО", "$RM_UCCK");
        switchWindow.switchToMainFrame();
        //Робота з фільтром
        filterBeforFillingTable.clearFilter();
        filterBeforFillingTable.setUserFilter(newCreditRefUo, "ND");
        filterBeforFillingTable.furtherButtonClick();
        //Портфель Робочих кредитів(Побудава ГПК та Графіку подій по портфелю)
        String workCreditOfLegalEntityBriefcaseWindow = getWebDriver().getWindowHandle();
        BriefcaseWorkCreditPage.chooseCredit(newCreditRefUo);
        BriefcaseWorkCreditPage.buildRepaymentSchedule();
        switchWindow.forceSwitchToWindow(workCreditOfLegalEntityBriefcaseWindow);
        switchWindow.windowMaximize();
        String gpkUoWindow = getWebDriver().getWindowHandle();
        BriefcaseWorkCreditPage.getTableName();
        BriefcaseWorkCreditPage.matchingSumInGpkUo(numSum+".00");
        switchWindow.closeWindow(gpkUoWindow);
        switchWindow.switchToOldWindow(workCreditOfLegalEntityBriefcaseWindow);
        switchWindow.switchToMainFrame();
        BriefcaseWorkCreditPage.chooseCredit(newCreditRefUo);
        BriefcaseWorkCreditPage.eventsTimetableOfBriefcaseButtonUo();
        switchWindow.forceSwitchToWindow(workCreditOfLegalEntityBriefcaseWindow);
        switchWindow.windowMaximize();
        BriefcaseWorkCreditPage.chooseInterval(firstPaymentDate);
        filterBeforFillingTable.clearFilter();
        filterBeforFillingTable.setUserFilter(newCreditRefUo, "ND");
        filterBeforFillingTable.furtherButtonClick();
        String EventsTimetableUoWindow = getWebDriver().getWindowHandle();
        BriefcaseWorkCreditPage.progressBar();
        if( base.equals("OBMMFOT1"))
        {
           int sizeCollection = 72;
           BriefcaseWorkCreditPage.checkEventsTimetableOfBriefcase(numSum, sizeCollection);
        }
        else {
            int sizeCollection = 54;
            BriefcaseWorkCreditPage.checkEventsTimetableOfBriefcase(numSum, sizeCollection);
        }
        switchWindow.closeWindow(EventsTimetableUoWindow);
        switchWindow.switchToOldWindow(workCreditOfLegalEntityBriefcaseWindow);
        switchWindow.switchToDefaultContent();
    }
//    @Ignore
    @Test
    public void kreditFoTest() {
        open("/");
        loginPage.prof();
        String base = loginPage.getPolygon();
        searchPage.searchFunction("Портфель НОВИХ кредитів ФО", "$RM_WCCK");
        switchWindow.switchToMainFrame();
        //Кнопка Новый КД(переключение на окно Нового КД)
        String briefcaseNewKdFoWindow = getWebDriver().getWindowHandle();
        briefcaseNewCreditPage.pressCreateNewKD();
        switchWindow.forceSwitchToWindow(briefcaseNewKdFoWindow);
        switchWindow.windowMaximize();
        // !!Заполнение полей КД!!
        // Вкладка Параметри КД
        String newKdFoWindow = getWebDriver().getWindowHandle();
        String numSum = calculation.randomNum();
        newCreditPage.fillNumSum(numSum, numSum);
        newCreditPage.fillInitiative(ConfigProperties.getTestProperty("branch"));
        newCreditPage.okpoButtonClick();
        newCreditPage.filterInputClick();
        newCreditPage.filterInput(ConfigProperties.getTestProperty("rnkfo"));
        switchWindow.switchToOldWindow(newKdFoWindow);
        newCreditPage.ratesButtonClick();
        newCreditPage.filterInputClick();
        newCreditPage.filterInput("9999");
        newCreditPage.typeOfCredit("ФЛ стандарт");
        newCreditPage.goalOfCredit("Поточна дiяльнiсть");
        newCreditPage.productOfCredit1();
        switchWindow.switchToOldWindow(newKdFoWindow);
        newCreditPage.productOfCredit2();
        newCreditPage.filterInput(ConfigProperties.getTestProperty("productfo"));
        //Вкладка Дані про погашення
        String firstPaymentDate = newCreditPage.getConclusionDate();
        newCreditPage.firstPaymentDate(firstPaymentDate);
        //Вкладка Дод. параметри КД
        newCreditPage.creditInsurance();
        newCreditPage.filterInput("NO");
        switchWindow.switchToOldWindow(newKdFoWindow);
        newCreditPage.updateParameter();
        newCreditPage.creditProduct();
        newCreditPage.filterInputClick();
        newCreditPage.filterInput("2");
        switchWindow.switchToOldWindow(newKdFoWindow);
        newCreditPage.updateParameter();
        newCreditPage.notary();
        newCreditPage.filterInputClick();
        newCreditPage.filterInput("2134");
        switchWindow.switchToOldWindow(newKdFoWindow);
        newCreditPage.updateParameter();
        //Нажимаем на кнопку "Зберігти"
        newCreditPage.saveButtonClick();
        newCreditPage.confirmOfCreditCreate();
        String newCreditRefFo = newCreditPage.getREF();
        System.out.println(newCreditRefFo);
        switchWindow.closeWindow(newKdFoWindow);
        switchWindow.switchToOldWindow(briefcaseNewKdFoWindow);
        switchWindow.switchToMainFrame();
        briefcaseNewCreditPage.pressRefreshBriefcase();
        //Авторизація
        BriefcaseWorkCreditPage.chooseCredit(newCreditRefFo);
        briefcaseNewCreditPage.creditAuthorization(ConfigProperties.getTestProperty("autorizationtype"));
        switchWindow.switchToDefaultContent();


/*
        String numSum = "449";
        String firstPaymentDate = "01/08/2018";
*/

        //Портфель Робочих КД ФО
        searchPage.searchFunction("Портфель РОБОЧИХ кредитів ФО", "$RM_WCCK");
        switchWindow.switchToMainFrame();
        //Робота з фільтром
        filterBeforFillingTable.clearFilter();
        filterBeforFillingTable.setUserFilter(newCreditRefFo, "ND");
        filterBeforFillingTable.furtherButtonClick();
        //Портфель Робочих кредитів(Побудава ГПК та Графіку подій по портфелю)
        String workCreditFoBriefcaseWindow = getWebDriver().getWindowHandle();
        BriefcaseWorkCreditPage.chooseCredit(newCreditRefFo);
        BriefcaseWorkCreditPage.buildRepaymentSchedule();
        switchWindow.forceSwitchToWindow(workCreditFoBriefcaseWindow);
        switchWindow.windowMaximize();
        String gpkFoWindow = getWebDriver().getWindowHandle();
        BriefcaseWorkCreditPage.getTableName();
        BriefcaseWorkCreditPage.matchingSumInGpkFo(numSum+".00");
        switchWindow.closeWindow(gpkFoWindow);
        switchWindow.switchToOldWindow(workCreditFoBriefcaseWindow);
        switchWindow.switchToMainFrame();
        BriefcaseWorkCreditPage.chooseCredit(newCreditRefFo);
        BriefcaseWorkCreditPage.eventsTimetableOfBriefcaseButtonFo();
        switchWindow.forceSwitchToWindow(workCreditFoBriefcaseWindow);
        switchWindow.windowMaximize();
        BriefcaseWorkCreditPage.chooseInterval(firstPaymentDate);
        filterBeforFillingTable.clearFilter();
        filterBeforFillingTable.setUserFilter(newCreditRefFo, "ND");
        filterBeforFillingTable.furtherButtonClick();
        String EventsTimetableFoWindow = getWebDriver().getWindowHandle();
        BriefcaseWorkCreditPage.progressBar();
        if( base.equals("OBMMFOT1"))
        {
            int sizeCollection = 72;
            BriefcaseWorkCreditPage.checkEventsTimetableOfBriefcase(numSum, sizeCollection);
        }
        else {
            int sizeCollection = 54;
            BriefcaseWorkCreditPage.checkEventsTimetableOfBriefcase(numSum, sizeCollection);
        }
        switchWindow.closeWindow(EventsTimetableFoWindow);
        switchWindow.switchToOldWindow(workCreditFoBriefcaseWindow);
        switchWindow.switchToDefaultContent();
    }
}

