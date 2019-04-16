package com.bars.registrationClientAndACC;

import com.bars.generalСlasses.SwitchWindowOrFrame;
import com.bars.helperClasses.Calculation;
import com.bars.helperClasses.ReadingFromFile;
import com.bars.helperClasses.WritingToFile;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class BasicDetails {

    private static SwitchWindowOrFrame switchWindowOrFrame = new SwitchWindowOrFrame();
    private static Calculation calculation = new Calculation();

    public void enterOKPO(String okpo) {
        switchWindowOrFrame.tabFrameClient( "Tab0" );
        $("#ed_OKPO").shouldBe(visible).setValue(okpo);
    }

    public void enterEcodeAndNumDog(String Ecode) {
        switchWindowOrFrame.tabFrameClient("Tab0");
        String NumDog = calculation.randomNumWithBorder(100000, 999999);
        WritingToFile.filewriting( "NumDogClient.txt", NumDog);
        String numDogFromFile = ReadingFromFile.read("NumDogClient.txt" );
        $("#ed_ND").shouldBe(visible).setValue(numDogFromFile);
        $("#ed_SAB").shouldBe(visible).setValue (Ecode);
    }

    public void enterFIO(String surname, String name, String patronymic) {
        $("#bt_FullDopRekv").shouldBe(visible).click ();
        $("#ed_FIO_MN").shouldBe(visible).setValue(patronymic);
        $("#ed_FIO_LN").shouldBe(visible).setValue(surname);
        $("#ed_FIO_FN").shouldBe(visible).setValue(name);

    }

    public void enterAddress(String index, String region, String area, String settlement, String street, String house) {
        $("#btnOpenWindowAddress").shouldBe(visible).click();
        switchWindowOrFrame.fullAddressFrame();
        $("#legalIndex").shouldBe(visible).setValue ( index);
        $("#legalRegion").shouldBe(visible).setValue ( region);
        $x("//span[@role = 'presentation']/input[@ng-model = 'legalArea']").shouldBe(visible).setValue(area);
        $x("//input[@ng-model = 'legalSettlement']").shouldBe(visible).setValue(settlement);
        $x("//span[@role = 'presentation']/input[@ng-model = 'legalStreet']").shouldBe(visible).setValue(street);
        $x("//input[@ng-model = 'legalHouse']").shouldBe(visible).setValue(house);
        $("#btnSaveAddress").shouldBe(visible).click ();
    }
}
