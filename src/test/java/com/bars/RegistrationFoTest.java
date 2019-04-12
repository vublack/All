package com.bars;

import com.bars.generalСlasses.SearchPage;
import com.bars.generalСlasses.SwitchWindowOrFrame;
import com.bars.helperClasses.Calculation;
import com.bars.helperClasses.ConfigProperties;
import com.bars.helperClasses.ReadingFromFile;
import com.bars.registrationClientAndACC.*;
import org.junit.Assert;
import org.junit.Test;

// Реєстрація фізичної особи, редагування картки клієнта ФО, видалення ФО
// Відкриття, редагування, видалення рахунку ФО
public class RegistrationFoTest extends BaseLoginTest{
    private static SearchPage searchPage = new SearchPage();
    private static SwitchWindowOrFrame switchWindowOrFrame = new SwitchWindowOrFrame();
    private static TransitionToRegistration transitionToReg = new TransitionToRegistration();
    private static BasicDetails basicDetails = new BasicDetails();
    private static ClientDetails clientDetails = new ClientDetails();
    private static AdditionaClientlInfo additionaClientlInfo = new AdditionaClientlInfo();
    private static AdditionalClientDetails additionalClientDetails = new AdditionalClientDetails();
    private static Calculation calculation = new Calculation();

    @Test
    public void createAndDelClientCard(){
        String base = ReadingFromFile.read("Polygon.txt" );
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

        //      Additional information
        transitionToReg.clickAdditionalInformationBtn();
        additionaClientlInfo.fillingISP();

        //         Additional details
        transitionToReg.clickAdditionalDetailsBtn();
        additionalClientDetails.enterGeneral();
        additionalClientDetails.enterFinMon( "Українець", "05022017", "05032017","Дашкевич О.М., тел.46-45" , "Заробітна плата");
        additionalClientDetails.enterOther();
        //      press the "Register" button
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


}
