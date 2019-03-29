package com.bars;
import com.bars.credit.AccKdPage;
import com.bars.credit.BriefcaseNewCreditPage;
import com.bars.credit.BriefcaseWorkCreditPage;
import com.bars.credit.NewCreditPage;
import com.codeborne.selenide.junit.ScreenShooter;
import com.codeborne.selenide.junit.TextReport;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import java.sql.SQLException;
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
    private AccKdPage accKdPage = page(AccKdPage.class);
    private DBoperation dBoperation = page(DBoperation.class);
    private BriefcaseWorkCreditPage briefcaseWorkCreditPage= new BriefcaseWorkCreditPage();

//    private BriefcaseWorkCreditPage briefcaseWorkCreditPage = page(BriefcaseWorkCreditPage.class);
    @Rule
    public ScreenShooter screenShooter = ScreenShooter.failedTests().to("test-results/reports");
    @Rule
    public TestRule report = new TextReport().onFailedTest(true).onSucceededTest(false);
/*
    @Test
    public void dbconTest() throws SQLException{
        loginPage.prof();
        String base = loginPage.getPolygon();
        loginPage.prof();


        dBoperation.setupDBconection(base);
        String a = dBoperation.selectFromDB("select * from cck_ob22 c where c.nbs='2203' and c.ob22='01'", "SD_N");
        briefcaseWorkCreditPage.checkOB22forODBacc(dBoperation);
       System.out.println("asdf" + a);
        dBoperation.closeConn();


    }
*/
//    @Ignore
    @Test
    public void creditLegalEntityTest() {
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
        switchWindow.forceSwitchToWindow2(briefcaseNewKdUoWindow);
        switchWindow.windowMaximize();
        // !!Заполнение полей КД!!
        // Вкладка Параметри КД
        String newKdUoWindow = getWebDriver().getWindowHandle();
        String numSum = calculation.randomNum();
        newCreditPage.fillNumSum(numSum, numSum);
        newCreditPage.fillInitiative(ConfigProperties.getTestProperty("branch"));
        newCreditPage.okpoRNKchoose(ConfigProperties.getTestProperty("okpouo"), ConfigProperties.getTestProperty("rnkuo"));
        newCreditPage.ratesInput(ConfigProperties.getTestProperty("rate"));
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
        newCreditPage.s260();
        newCreditPage.filterInput("01");
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

/*
        filterBeforFillingTable.setUserFilter("19171634401", "ND");
*/
        filterBeforFillingTable.furtherButtonClick();
//Портфель Робочих кредитів(Побудава ГПК та Графіку подій по портфелю)
        String workCreditOfLegalEntityBriefcaseWindow = getWebDriver().getWindowHandle();

        BriefcaseWorkCreditPage.chooseCredit(newCreditRefUo);
        BriefcaseWorkCreditPage.buildRepaymentSchedule();
        switchWindow.forceSwitchToWindow2(workCreditOfLegalEntityBriefcaseWindow);
        switchWindow.windowMaximize();
        String gpkUoWindow = getWebDriver().getWindowHandle();
        BriefcaseWorkCreditPage.getTableName();
        BriefcaseWorkCreditPage.matchingSumInGpkUo(numSum+".00");
        switchWindow.closeWindow(gpkUoWindow);

        switchWindow.switchToOldWindow(workCreditOfLegalEntityBriefcaseWindow);
        switchWindow.switchToMainFrame();
        BriefcaseWorkCreditPage.chooseCredit(newCreditRefUo);
        BriefcaseWorkCreditPage.eventsTimetableOfBriefcaseButtonUo();
        switchWindow.forceSwitchToWindow2(workCreditOfLegalEntityBriefcaseWindow);
        switchWindow.windowMaximize();
        BriefcaseWorkCreditPage.chooseInterval(firstPaymentDate);
        filterBeforFillingTable.clearFilter();
        filterBeforFillingTable.setUserFilter(newCreditRefUo, "ND");
        filterBeforFillingTable.furtherButtonClick();
        String EventsTimetableUoWindow = getWebDriver().getWindowHandle();
        BriefcaseWorkCreditPage.progressBar();
        BriefcaseWorkCreditPage.checkEventsTimetableOfBriefcase(numSum, 72);
        switchWindow.closeWindow(EventsTimetableUoWindow);
        switchWindow.switchToOldWindow(workCreditOfLegalEntityBriefcaseWindow);
//Портфель Робочих кредитів(Перевірка відкриття рахунку SS)
        switchWindow.switchToMainFrame();
        BriefcaseWorkCreditPage.chooseCredit(newCreditRefUo);
/*
        BriefcaseWorkCreditPage.chooseCredit("19171634401");
*/
        BriefcaseWorkCreditPage.AccountsUoButton();
        switchWindow.forceSwitchToWindow2(workCreditOfLegalEntityBriefcaseWindow);
        switchWindow.windowMaximize();
        String accKdUOwindow = getWebDriver().getWindowHandle();
        accKdPage.checkAccSSopening("productuo");
        switchWindow.closeWindow(accKdUOwindow);
        switchWindow.switchToOldWindow(workCreditOfLegalEntityBriefcaseWindow);


    }
//    @Ignore
    @Test
    public void kreditFoTest() {
//        open("/");
        loginPage.prof();
        String base = loginPage.getPolygon();
        searchPage.searchFunction("Портфель НОВИХ кредитів ФО", "$RM_WCCK");
        switchWindow.switchToMainFrame();
        //Кнопка Новый КД(переключение на окно Нового КД)
        String briefcaseNewKdFoWindow = getWebDriver().getWindowHandle();
        briefcaseNewCreditPage.pressCreateNewKD();
        switchWindow.forceSwitchToWindow2(briefcaseNewKdFoWindow);
        switchWindow.windowMaximize();
        // !!Заполнение полей КД!!
        // Вкладка Параметри КД
        String newKdFoWindow = getWebDriver().getWindowHandle();
        String numSum = calculation.randomNum();
        newCreditPage.fillNumSum(numSum, numSum);
        newCreditPage.fillInitiative(ConfigProperties.getTestProperty("branch"));
        newCreditPage.okpoRNKchoose(ConfigProperties.getTestProperty("okpofo"), ConfigProperties.getTestProperty("rnkfo"));
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
        newCreditPage.partnerPresent();
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
        switchWindow.forceSwitchToWindow2(workCreditFoBriefcaseWindow);
        switchWindow.windowMaximize();
        String gpkFoWindow = getWebDriver().getWindowHandle();
        BriefcaseWorkCreditPage.getTableName();
        BriefcaseWorkCreditPage.matchingSumInGpkFo(numSum+".00");
        switchWindow.closeWindow(gpkFoWindow);
        switchWindow.switchToOldWindow(workCreditFoBriefcaseWindow);
        switchWindow.switchToMainFrame();
        BriefcaseWorkCreditPage.chooseCredit(newCreditRefFo);
        BriefcaseWorkCreditPage.eventsTimetableOfBriefcaseButtonFo();
        switchWindow.forceSwitchToWindow2(workCreditFoBriefcaseWindow);
        switchWindow.windowMaximize();
        BriefcaseWorkCreditPage.chooseInterval(firstPaymentDate);
        filterBeforFillingTable.clearFilter();
        filterBeforFillingTable.setUserFilter(newCreditRefFo, "ND");
        filterBeforFillingTable.furtherButtonClick();
        String EventsTimetableFoWindow = getWebDriver().getWindowHandle();
        BriefcaseWorkCreditPage.progressBar();
        String auTipe = ConfigProperties.getTestProperty("autorizationtype");
        if( base.equals("OBMMFOT") || auTipe.equals("1") || base.equals("OBMMFOT1") )
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
//Портфель Робочих кредитів(Перевірка відкриття рахунку SS)
        switchWindow.switchToMainFrame();
        BriefcaseWorkCreditPage.chooseCredit(newCreditRefFo);
        BriefcaseWorkCreditPage.AccountsFoButton();
        switchWindow.forceSwitchToWindow2(workCreditFoBriefcaseWindow);
        switchWindow.windowMaximize();
        String accKdUOwindow = getWebDriver().getWindowHandle();
        accKdPage.checkAccSSopening("productfo");
        switchWindow.closeWindow(accKdUOwindow);
        switchWindow.switchToOldWindow(workCreditFoBriefcaseWindow);

    }

}

