package com.bars.registrationClientAndACC;

import com.bars.generalСlasses.SwitchWindowOrFrame;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class BasicDetails {

    private static SwitchWindowOrFrame switchWindowOrFrame = new SwitchWindowOrFrame();

    public void enterOKPO(String okpo) {
        switchWindowOrFrame.tabFrameClient( "Tab0" );
        $("#ed_OKPO").shouldBe(visible).setValue(okpo);
    }

    public void enterSAB(String sab) {
        switchWindowOrFrame.tabFrameClient("Tab0");
        $("#ed_SAB").shouldBe(visible).setValue ( sab);
    }

    public void enterFIO(String surname, String name, String patronymic) {
        $("#bt_FullDopRekv").shouldBe(visible).click ();
        $("#ed_FIO_LN").shouldBe(visible).setValue(surname);
        $("#ed_FIO_FN").shouldBe(visible).setValue(name);
        $("#ed_FIO_MN").shouldBe(visible).setValue(patronymic);
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
