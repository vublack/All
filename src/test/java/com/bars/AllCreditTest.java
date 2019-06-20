package com.bars;

import com.bars.credit.AccKdPage;
import com.bars.credit.BriefcaseNewCreditPage;
import com.bars.credit.BriefcaseWorkCreditPage;
import com.bars.credit.NewCreditPage;
import com.bars.generalСlasses.FilterBeforFillingTable;
import com.bars.generalСlasses.LoginPage;
import com.bars.generalСlasses.SearchPage;
import com.bars.generalСlasses.SwitchWindowOrFrame;
import com.bars.helperClasses.Calculation;
import com.bars.helperClasses.ConfigProperties;
import com.bars.helperClasses.ReadingFromFile;
import org.junit.Test;

import java.sql.SQLException;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class AllCreditTest extends BaseLoginTest {
    private Calculation calculation = page(Calculation.class);
    private NewCreditPage newCreditPage = page(NewCreditPage.class);
    private static SearchPage searchPage = new SearchPage();
    private static SwitchWindowOrFrame switchWindowOrFrame = new SwitchWindowOrFrame();
    private BriefcaseNewCreditPage briefcaseNewCreditPage = page(BriefcaseNewCreditPage.class);
    private FilterBeforFillingTable filterBeforFillingTable = page(FilterBeforFillingTable.class);
    private AccKdPage accKdPage = page(AccKdPage.class);
    private static LoginPage loginPage = new LoginPage();

//    @Test
//    public void dbconTest() throws SQLException {
//        String projectUrl = System.getProperty(baseUrl);
//        System.out.println(projectUrl);
//        selenide.baseUrl
//        loginPage.prof();
//        String base = loginPage.getPolygon();
//        loginPage.prof();
//
//
//        dBoperation.setupDBconection(base);
//        String a = dBoperation.selectFromDB("select * from cck_ob22 c where c.nbs='2203' and c.ob22='01'", "SD_N");
//        briefcaseWorkCreditPage.checkOB22forODBacc(dBoperation);
//       System.out.println("asdf" + a);
//        dBoperation.closeConn();
//
//
//    }



//    @Ignore
    @Test
    public void creditLegalEntityTest() {
//        String projectUrl = System.getProperty("selenide.baseUrl");
//        System.out.println(projectUrl);
        String mainWin = getWebDriver().getWindowHandle();
        switchWindowOrFrame.closeFaliTestWindow();
        switchWindowOrFrame.switchToOldWindow(mainWin);
        //Страница поиска
        String base = ReadingFromFile.read("Polygon.txt" ).replace("DB ", "");
        searchPage.searchFunction("Портфель НОВИХ кредитів ЮО", "1818");
        if(base.equals("RCMMFO"))
        {
            //Робота з фільтром
            filterBeforFillingTable.clearFilter();
            filterBeforFillingTable.furtherButtonClick();
        }
        //Кнопка Новый КД(переключение на окно Нового КД)
        String briefcaseNewKdUoWindow = getWebDriver().getWindowHandle();
        briefcaseNewCreditPage.pressCreateNewKD();
        switchWindowOrFrame.forceSwitchToWindow2(briefcaseNewKdUoWindow);
        switchWindowOrFrame.windowMaximize();
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
        newCreditPage.productOfCredit1(ConfigProperties.getTestProperty("productuo"));
//        switchWindowOrFrame.switchToOldWindow(newKdUoWindow);
//        newCreditPage.productOfCredit2();
//        newCreditPage.filterInput(ConfigProperties.getTestProperty("productuo"));

        if( base.equals("OBMMFOT")|| base.equals("OBMMFOT1"))
        {
            newCreditPage.chooseGKD();
        }

        //Вкладка Дані про погашення
        String firstPaymentDate = newCreditPage.getConclusionDate();
        newCreditPage.firstPaymentDate(firstPaymentDate);
        //Вкладка Дод. параметри КД
        newCreditPage.additionalParamTab();
        newCreditPage.pressFilterByCode();
        newCreditPage.filterInput("INSCC");
        switchWindowOrFrame.switchToOldWindow(newKdUoWindow);
        newCreditPage.creditInsurance("NO");
        newCreditPage.updateParameter();
        newCreditPage.pressFilterByCode();
        newCreditPage.filterInput("S260");
        newCreditPage.s260();
        newCreditPage.filterInput2("01");
        switchWindowOrFrame.switchToOldWindow(newKdUoWindow);
        newCreditPage.updateParameter();


        newCreditPage.contractStatus();
        newCreditPage.filterInputClick();
        newCreditPage.filterInput2("0");
        switchWindowOrFrame.switchToOldWindow(newKdUoWindow);
        newCreditPage.updateParameter();
        newCreditPage.creditProduct();
        newCreditPage.filterInputClick();
        newCreditPage.filterInput2("2");
        switchWindowOrFrame.switchToOldWindow(newKdUoWindow);
        newCreditPage.updateParameter();
        newCreditPage.fillEIBCB();
        newCreditPage.filterInputClick();
        newCreditPage.filterInput2("2");
        switchWindowOrFrame.switchToOldWindow(newKdUoWindow);
        newCreditPage.updateParameter();
        newCreditPage.fillEIBCE("33");
        newCreditPage.updateParameter();
        newCreditPage.fillEIBCR("33");
        newCreditPage.updateParameter();
        newCreditPage.fillEIBCS();
        newCreditPage.filterInputClick();
        newCreditPage.filterInput2("2");
        switchWindowOrFrame.switchToOldWindow(newKdUoWindow);
        newCreditPage.updateParameter();
        newCreditPage.fillEIBCW("33");
        newCreditPage.updateParameter();
        newCreditPage.fillEIBIE("33");
        newCreditPage.updateParameter();
        newCreditPage.fillEIBIS();
        newCreditPage.filterInput2("NO");
        switchWindowOrFrame.switchToOldWindow(newKdUoWindow);
        newCreditPage.updateParameter();
        newCreditPage.fillEIBND("33 тест");
        newCreditPage.updateParameter();
        newCreditPage.fillEIBNE("33 тест");
        newCreditPage.updateParameter();
        newCreditPage.fillEIBPF();
        newCreditPage.filterInputClick();
        newCreditPage.filterInput2("1");
        switchWindowOrFrame.switchToOldWindow(newKdUoWindow);
        newCreditPage.updateParameter();
        newCreditPage.fillEIBSF();
        newCreditPage.filterInputClick();
        newCreditPage.filterInput2("1");
        switchWindowOrFrame.switchToOldWindow(newKdUoWindow);
        newCreditPage.updateParameter();
        newCreditPage.fillEIBTV("33");
        newCreditPage.updateParameter();
        newCreditPage.notary();
        newCreditPage.filterInputClick();
        newCreditPage.filterInput2("2134");
        switchWindowOrFrame.switchToOldWindow(newKdUoWindow);
        newCreditPage.updateParameter();
        //Нажимаем на кнопку "Зберігти"
        newCreditPage.saveButtonClick();
        newCreditPage.confirmOfCreditCreate();
        String newCreditRefUo = newCreditPage.getREF();
        switchWindowOrFrame.closeWindow(newKdUoWindow);
        switchWindowOrFrame.switchToOldWindow(briefcaseNewKdUoWindow);
        switchWindowOrFrame.mainFrame();
        briefcaseNewCreditPage.pressRefreshBriefcase();
        //Авторизація
        BriefcaseWorkCreditPage.chooseCredit(newCreditRefUo);
        briefcaseNewCreditPage.creditAuthorization(ConfigProperties.getTestProperty("autorizationtype"));
        switchWindowOrFrame.defaultContent();


 /*
        String numSum = "244";
        String firstPaymentDate = "28/02/2019";
        String newCreditRefFo = "19171724401";
 */

        //Портфель Робочих КД ФО
        searchPage.searchFunction("Портфель РОБОЧИХ кредитів ЮО", "1819");
        //Робота з фільтром
        filterBeforFillingTable.clearFilter();
        filterBeforFillingTable.setUserFilter(newCreditRefUo, "ND");
        filterBeforFillingTable.furtherButtonClick();
//Портфель Робочих кредитів(Побудава ГПК та Графіку подій по портфелю)
        String workCreditOfLegalEntityBriefcaseWindow = getWebDriver().getWindowHandle();

        BriefcaseWorkCreditPage.chooseCredit(newCreditRefUo);
        BriefcaseWorkCreditPage.buildRepaymentSchedule();
        switchWindowOrFrame.forceSwitchToWindow2(workCreditOfLegalEntityBriefcaseWindow);
        switchWindowOrFrame.windowMaximize();
        String gpkUoWindow = getWebDriver().getWindowHandle();
        BriefcaseWorkCreditPage.getTableName();
        BriefcaseWorkCreditPage.matchingSumInGpkUo(numSum+".00");
        switchWindowOrFrame.closeWindow(gpkUoWindow);
        switchWindowOrFrame.switchToOldWindow(workCreditOfLegalEntityBriefcaseWindow);
        switchWindowOrFrame.mainFrame();
        BriefcaseWorkCreditPage.chooseCredit(newCreditRefUo);
        BriefcaseWorkCreditPage.eventsTimetableOfBriefcaseButtonUo();
        switchWindowOrFrame.forceSwitchToWindow2(workCreditOfLegalEntityBriefcaseWindow);
        switchWindowOrFrame.windowMaximize();
        BriefcaseWorkCreditPage.chooseInterval(firstPaymentDate);
        filterBeforFillingTable.clearFilter();
        filterBeforFillingTable.setUserFilter(newCreditRefUo, "ND");
        filterBeforFillingTable.furtherButtonClick();
        String EventsTimetableUoWindow = getWebDriver().getWindowHandle();
        BriefcaseWorkCreditPage.progressBar();
        BriefcaseWorkCreditPage.checkEventsTimetableOfBriefcase(numSum);
        switchWindowOrFrame.closeWindow(EventsTimetableUoWindow);
        switchWindowOrFrame.switchToOldWindow(workCreditOfLegalEntityBriefcaseWindow);
//Портфель Робочих кредитів(Перевірка відкриття рахунку SS)
        switchWindowOrFrame.mainFrame();
        BriefcaseWorkCreditPage.chooseCredit(newCreditRefUo);
        BriefcaseWorkCreditPage.AccountsUoButton();
        switchWindowOrFrame.forceSwitchToWindow2(workCreditOfLegalEntityBriefcaseWindow);
        switchWindowOrFrame.windowMaximize();
        String accKdUOwindow = getWebDriver().getWindowHandle();
        accKdPage.checkAccSSopening("productuo");
        switchWindowOrFrame.closeWindow(accKdUOwindow);
        switchWindowOrFrame.switchToOldWindow(workCreditOfLegalEntityBriefcaseWindow);
    }
//    @Ignore
    @Test
    public void kreditFoTest() {
        String mainWin = getWebDriver().getWindowHandle();
        switchWindowOrFrame.closeFaliTestWindow();
        switchWindowOrFrame.switchToOldWindow(mainWin);
        String base = ReadingFromFile.read("Polygon.txt" ).replace("DB ", "");
        System.out.println(base);
        searchPage.searchFunction("Портфель НОВИХ кредитів ФО", "1816");
        //Кнопка Новый КД(переключение на окно Нового КД)
        String briefcaseNewKdFoWindow = getWebDriver().getWindowHandle();
        briefcaseNewCreditPage.pressCreateNewKD();
        switchWindowOrFrame.forceSwitchToWindow2(briefcaseNewKdFoWindow);
        switchWindowOrFrame.windowMaximize();
        // !!Заполнение полей КД!!
        // Вкладка Параметри КД
        String newKdFoWindow = getWebDriver().getWindowHandle();
        String numSum = calculation.randomNum();
        newCreditPage.fillNumSum(numSum, numSum);
        newCreditPage.fillInitiative(ConfigProperties.getTestProperty("branch"));
        newCreditPage.okpoRNKchoose(ConfigProperties.getTestProperty("okpofo"), ConfigProperties.getTestProperty("rnkfo"));
        newCreditPage.ratesInput(ConfigProperties.getTestProperty("rate"));
//        newCreditPage.ratesButtonClick();
//        newCreditPage.filterInputClick();
//        newCreditPage.filterInput("9999");
        newCreditPage.typeOfCredit("ФЛ стандарт");
        newCreditPage.goalOfCredit("Поточна дiяльнiсть");
        newCreditPage.productOfCredit1(ConfigProperties.getTestProperty("productfo"));
/*
        switchWindowOrFrame.switchToOldWindow(newKdFoWindow);
        newCreditPage.productOfCredit2();
        newCreditPage.filterInput(ConfigProperties.getTestProperty("productfo"));
*/
        //Вкладка Дані про погашення
        String firstPaymentDate = newCreditPage.getConclusionDate();
        newCreditPage.firstPaymentDate(firstPaymentDate);
        //Вкладка Дод. параметри КД
        newCreditPage.additionalParamTab();
        newCreditPage.pressFilterByCode();
        newCreditPage.filterInput("INSCC");
        switchWindowOrFrame.switchToOldWindow(newKdFoWindow);
        newCreditPage.creditInsurance("NO");
        newCreditPage.updateParameter();

        newCreditPage.pressFilterByCode();
        newCreditPage.filterInput("INTRT");
        newCreditPage.marketRate("12");
        newCreditPage.updateParameter();

        if( base.equals("OBMMFOT"))
        {
            newCreditPage.pressFilterByCode();
            newCreditPage.filterInput("PARTC");
            newCreditPage.сentralOfficeContract();
            newCreditPage.filterInput2("NO");
            switchWindowOrFrame.switchToOldWindow(newKdFoWindow);
            newCreditPage.updateParameter();
        }
        newCreditPage.pressFilterByCode();
        newCreditPage.filterInput("PARTN");
        newCreditPage.partnerPresent();
        newCreditPage.filterInput2("NO");
        switchWindowOrFrame.switchToOldWindow(newKdFoWindow);
        newCreditPage.updateParameter();
        newCreditPage.creditProduct();
        newCreditPage.filterInputClick();
        newCreditPage.filterInput2("2");
        switchWindowOrFrame.switchToOldWindow(newKdFoWindow);
        newCreditPage.updateParameter();
        newCreditPage.notary();
        newCreditPage.filterInputClick();
        newCreditPage.filterInput2("2134");
        switchWindowOrFrame.switchToOldWindow(newKdFoWindow);
        newCreditPage.updateParameter();
        //Нажимаем на кнопку "Зберігти"
        newCreditPage.saveButtonClick();
        newCreditPage.confirmOfCreditCreate();
        String newCreditRefFo = newCreditPage.getREF();
        System.out.println(newCreditRefFo);
        switchWindowOrFrame.closeWindow(newKdFoWindow);
        switchWindowOrFrame.switchToOldWindow(briefcaseNewKdFoWindow);
        switchWindowOrFrame.mainFrame();
        briefcaseNewCreditPage.pressRefreshBriefcase();
        //Авторизація
        BriefcaseWorkCreditPage.chooseCredit(newCreditRefFo);
        briefcaseNewCreditPage.creditAuthorization(ConfigProperties.getTestProperty("autorizationtype"));
        switchWindowOrFrame.defaultContent();


/*
        String numSum = "244";
        String firstPaymentDate = "28/02/2019";
        String newCreditRefFo = "19171724401";
*/

        //Портфель Робочих КД ФО
        searchPage.searchFunction("Портфель РОБОЧИХ кредитів ФО", "1585");
        //Робота з фільтром
        filterBeforFillingTable.clearFilter();
        filterBeforFillingTable.setUserFilter(newCreditRefFo, "ND");
        filterBeforFillingTable.furtherButtonClick();
        //Портфель Робочих кредитів(Побудава ГПК та Графіку подій по портфелю)
        String workCreditFoBriefcaseWindow = getWebDriver().getWindowHandle();
        BriefcaseWorkCreditPage.chooseCredit(newCreditRefFo);
        BriefcaseWorkCreditPage.buildRepaymentSchedule();
        switchWindowOrFrame.forceSwitchToWindow2(workCreditFoBriefcaseWindow);
        switchWindowOrFrame.windowMaximize();
        String gpkFoWindow = getWebDriver().getWindowHandle();
        BriefcaseWorkCreditPage.getTableName();
        BriefcaseWorkCreditPage.matchingSumInGpkFo(numSum+".00");
        switchWindowOrFrame.closeWindow(gpkFoWindow);
        switchWindowOrFrame.switchToOldWindow(workCreditFoBriefcaseWindow);
        switchWindowOrFrame.mainFrame();
        BriefcaseWorkCreditPage.chooseCredit(newCreditRefFo);
        BriefcaseWorkCreditPage.eventsTimetableOfBriefcaseButtonFo();
        switchWindowOrFrame.forceSwitchToWindow2(workCreditFoBriefcaseWindow);
        switchWindowOrFrame.windowMaximize();
        BriefcaseWorkCreditPage.chooseInterval(firstPaymentDate);
        filterBeforFillingTable.clearFilter();
        filterBeforFillingTable.setUserFilter(newCreditRefFo, "ND");
        filterBeforFillingTable.furtherButtonClick();
        String EventsTimetableFoWindow = getWebDriver().getWindowHandle();
        BriefcaseWorkCreditPage.progressBar();
        BriefcaseWorkCreditPage.checkEventsTimetableOfBriefcase(numSum);
        switchWindowOrFrame.closeWindow(EventsTimetableFoWindow);
        switchWindowOrFrame.switchToOldWindow(workCreditFoBriefcaseWindow);
//Портфель Робочих кредитів(Перевірка відкриття рахунку SS)
        switchWindowOrFrame.mainFrame();
        BriefcaseWorkCreditPage.chooseCredit(newCreditRefFo);
        BriefcaseWorkCreditPage.AccountsFoButton();
        switchWindowOrFrame.forceSwitchToWindow2(workCreditFoBriefcaseWindow);
        switchWindowOrFrame.windowMaximize();
        String accKdUOwindow = getWebDriver().getWindowHandle();
        accKdPage.checkAccSSopening("productfo");
        switchWindowOrFrame.closeWindow(accKdUOwindow);
        switchWindowOrFrame.switchToOldWindow(workCreditFoBriefcaseWindow);

    }

}

