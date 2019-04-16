package com.bars;

import com.bars.generalСlasses.SearchPage;
import com.bars.helperClasses.Calculation;
import com.bars.helperClasses.ConfigProperties;
import com.bars.helperClasses.ReadingFromFile;
import com.bars.registrationClientAndACC.*;
import org.junit.Test;

import java.io.IOException;

// Реєстрація фізичної особи, редагування картки клієнта ФО, видалення ФО
// Відкриття, редагування, видалення рахунку ФО
public class RegistrationFoTest extends BaseLoginTest{
    private static SearchPage searchPage = new SearchPage();
    private static TransitionToRegistration transitionToReg = new TransitionToRegistration();
    private static BasicDetails basicDetails = new BasicDetails();
    private static ClientDetails clientDetails = new ClientDetails();
    private static AdditionaClientlInfo additionaClientlInfo = new AdditionaClientlInfo();
    private static AdditionalClientDetails additionalClientDetails = new AdditionalClientDetails();
    private static Calculation calculation = new Calculation();
    private static CustomerFoAccounts customerFoAccounts = new CustomerFoAccounts();

    @Test
    public void createAndDelClientCardTest(){
        searchPage.searchFunction("Реєстрація клієнтів і Рахунків", "3039");
        transitionToReg.goingToRegister ("999999999");
    //      Basic details
        // IPN
        basicDetails.enterOKPO(ConfigProperties.getTestProperty("okpofo"));
        basicDetails.enterFIO( "Рінкон","Дієго" , "Дієгович" );
        // Clien adress
        basicDetails.enterAddress("08700" , "Київська обл.", "Обухівський район", "Обухівв", "Варвари", "54");
        transitionToReg.clickClientDetailBtn();
        clientDetails.enterDocumentDetails("Овручським районним управлінням", "МО",calculation.randomNumWithBorder(100000, 999999),"10102010","05022018","10101992" );
        clientDetails.enterNumberPhone("5648978");

        transitionToReg.editingEcomomDetails();

        //      Additional information
        transitionToReg.clickAdditionalInformationBtn();
        additionaClientlInfo.fillingISP();

        //         Additional details
        transitionToReg.clickAdditionalDetailsBtn();
        additionalClientDetails.enterGeneral();
        additionalClientDetails.enterFinMon( "Українець", "05022017", "05032017","Дашкевич О.М., тел.46-45" , "Заробітна плата");
        additionalClientDetails.enterOther();
        //      press the "Register" button
        transitionToReg.saveClientCard();
        transitionToReg.NewRNKwriteTofile();
        transitionToReg.confirmationReg();
        // Закрытие карточки клиента
        searchPage.searchFunction("Реєстрація клієнтів і Рахунків", "3039");
        transitionToReg.filterClientbyRNK(ReadingFromFile.read( "ClientRNK.txt" ));
        transitionToReg.closeClient();

        // проверка закрытия клиента
        searchPage.searchFunction("Реєстрація клієнтів і Рахунків", "3039");
        transitionToReg.filterClientbyRNK(ReadingFromFile.read( "ClientRNK.txt" ));
        transitionToReg.checkClose();
    }

    @Test
    public void customerFoAccountTest() throws IOException {
        searchPage.searchFunction("Реєстрація клієнтів і Рахунків", "3039");
        //Find client
        transitionToReg.filterClientbyRNK(ConfigProperties.getTestProperty("rnkfo"));
        //Open customer accounts
        transitionToReg.openCustomerAccounts();
        customerFoAccounts.createCustAcc( "2620", "1" );
        customerFoAccounts.saveOptions();
        customerFoAccounts.editCustFoAcc( "213" , ReadingFromFile.read( "NewAccFo.txt"));
        customerFoAccounts.checkSpecparamTab();
        customerFoAccounts.saveOptionsEdit ();
        customerFoAccounts.closeCustFoAcc(ReadingFromFile.read("NewAccFo.txt"));
    }
    @Test
    public void editingClientCardTest(){
        searchPage.searchFunction("Реєстрація клієнтів і Рахунків", "3039");
        //Find client
        transitionToReg.filterClientbyRNK(ConfigProperties.getTestProperty("rnkfo"));
        transitionToReg.clickSearchRowNum(ConfigProperties.getTestProperty("rnkfo"));
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
        searchPage.searchFunction("Реєстрація клієнтів і Рахунків", "3039");
        //Find client
        transitionToReg.filterClientbyRNK(ConfigProperties.getTestProperty("rnkfo"));
        transitionToReg.checkNumdogClient(ReadingFromFile.read("NumDogClient.txt"));

    }
}
