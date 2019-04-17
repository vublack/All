package com.bars;

import com.bars.generalСlasses.SearchPage;
import com.bars.generalСlasses.SwitchWindowOrFrame;
import com.bars.helperClasses.Calculation;
import com.bars.helperClasses.ConfigProperties;
import com.bars.helperClasses.ReadingFromFile;
import com.bars.registrationClientAndACC.*;
import org.junit.Test;

import java.io.IOException;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

// Реєстрація фізичної особи, редагування картки клієнта ФОП, видалення ФОП
// Відкриття, редагування, видалення рахунку ФОП
public class RegistrationFOPTest extends BaseLoginTest{
    private static SearchPage searchPage = new SearchPage();
    private static TransitionToRegistration transitionToReg = new TransitionToRegistration();
    private static BasicDetails basicDetails = new BasicDetails();
    private static ClientDetails clientDetails = new ClientDetails();
    private static AdditionaClientlInfo additionaClientlInfo = new AdditionaClientlInfo();
    private static AdditionalClientDetails additionalClientDetails = new AdditionalClientDetails();
    private static Calculation calculation = new Calculation();
    private static CustomerAccounts customerAccounts = new CustomerAccounts();
    private static SwitchWindowOrFrame switchWindowOrFrame = new SwitchWindowOrFrame();
    private static EconomDetails economDetails = new EconomDetails();

    @Test
    public void createAndDelFOPCardTest(){
        String mainWin = getWebDriver().getWindowHandle();
        switchWindowOrFrame.closeFaliTestWindow();
        switchWindowOrFrame.switchToOldWindow(mainWin);

        searchPage.searchFunction("Реєстрація клієнтів і Рахунків", "1939");
        transitionToReg.goingToRegister ("999999999");
    //      Basic details
        // IPN
        basicDetails.enterOKPO(ConfigProperties.getTestProperty("okpofo"));
        basicDetails.enterFOPfIO( "Рауль Гонсалез Юланко" );
        // Clien adress
        basicDetails.enterAddress("08700" , "Київська обл.", "Обухівський район", "Обухівв", "Варвари", "54");

        transitionToReg.clickClientDetailBtn();
        clientDetails.enterDocumentDetails("Овручським районним управлінням", "МО",calculation.randomNumWithBorder(100000, 999999),"10102010","05022018","10101992" );
        clientDetails.enterNumberPhone("5648978");

        // Перехід на вкладку Економ нормативи
        transitionToReg.clickEconomDetailsBtn();
        economDetails.enterEconNormforFOP("14200", "N8010");

        //      Additional information
        transitionToReg.clickAdditionalInformationBtn();
        additionaClientlInfo.fillingISP();

        //         Additional details
        transitionToReg.clickAdditionalDetailsBtn();
        additionalClientDetails.enterGeneral();
        additionalClientDetails.enterFinMon( "Українець", "05022017", "05032017","Дашкевич О.М., тел.46-45" , "Заробітна плата");
        //      press the "Register" button
        transitionToReg.saveClientCard();
        transitionToReg.NewRNKwriteTofile();
        transitionToReg.confirmationReg();

        // Закрытие карточки клиента
        searchPage.searchFunction("Реєстрація клієнтів і Рахунків", "1939");
        transitionToReg.filterClientbyRNK(ReadingFromFile.read( "ClientRNK.txt" ));
        transitionToReg.closeClient();

        // проверка закрытия клиента
        searchPage.searchFunction("Реєстрація клієнтів і Рахунків", "1939");
        transitionToReg.filterClientbyRNK(ReadingFromFile.read( "ClientRNK.txt" ));
        transitionToReg.checkClose();
    }

    @Test
    public void customerFOPaccountTest() throws IOException {
        String mainWin = getWebDriver().getWindowHandle();
        switchWindowOrFrame.closeFaliTestWindow();
        switchWindowOrFrame.switchToOldWindow(mainWin);
        searchPage.searchFunction("Реєстрація клієнтів і Рахунків", "1939");
        //Find client
        transitionToReg.filterClientbyRNK(ConfigProperties.getTestProperty("rnkfop"));
        //Open customer accounts
        transitionToReg.openCustomerAccounts();
        customerAccounts.createCustAcc( "2600");
        customerAccounts.specparamFOP( "1" );
        customerAccounts.saveOptions();
        customerAccounts.editCustFoAcc( "213" , ReadingFromFile.read("NewAcc.txt"));
        customerAccounts.checkSpecparamTab();
        customerAccounts.saveOptionsEdit ();
        customerAccounts.closeCustFoAcc(ReadingFromFile.read("NewAcc.txt"));
    }
    @Test
    public void editingFOPClientCardTest(){
        String mainWin = getWebDriver().getWindowHandle();
        switchWindowOrFrame.closeFaliTestWindow();
        switchWindowOrFrame.switchToOldWindow(mainWin);
        searchPage.searchFunction("Реєстрація клієнтів і Рахунків", "1939");
        //Find client
        transitionToReg.filterClientbyRNK(ConfigProperties.getTestProperty("rnkfop"));
        transitionToReg.clickSearchRowNum(ConfigProperties.getTestProperty("rnkfop"));
        basicDetails.enterEcodeAndNumDog("564654");
        transitionToReg.clickTaxpayerDetalisBtn();
        transitionToReg.clickClientDetailBtn();
        clientDetails.editingClientDetail("Боярка", "044546698" );
        transitionToReg.clickAdditionalInformationBtn();
        additionaClientlInfo.editingDetail("ок", "Херсон", "40", "50", "15", "16", "123", "Ок");
        transitionToReg.clickAdditionalDetailsBtn();
        additionalClientDetails.enterGeneral();
        additionalClientDetails.enterFinMon( "Українець", "05022017", "05032017","Дашкевич О.М., тел.46-45" , "Заробітна плата");
        additionalClientDetails.enterOther();
        additionalClientDetails.enterforCreditRegister("1", "0000000000", "Хорощший", "7000", "7000");
        transitionToReg.clickConnectedPeopleBtn();
        transitionToReg.clickClientSegmentsBtn();
        transitionToReg.clickCDOBtn();
        transitionToReg.saveClientCard();
        transitionToReg.confirmationReg();
        searchPage.searchFunction("Реєстрація клієнтів і Рахунків", "1939");
        //Find client
        transitionToReg.filterClientbyRNK(ConfigProperties.getTestProperty("rnkfo"));
        transitionToReg.checkNumdogClient(ReadingFromFile.read("NumDogClient.txt"));

    }
}
