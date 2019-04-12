package com.bars.registrationClientAndACC;

import com.bars.generalСlasses.SwitchWindowOrFrame;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class AdditionaClientlInfo {
    private static SwitchWindowOrFrame switchWindowOrFrame = new SwitchWindowOrFrame();


    public void fillingISP(){
        switchWindowOrFrame.tabFrameClient("Tab4");
        $("#bt_help").shouldBe(visible).click();
        switchWindowOrFrame.kContentFrame();
        $x("//div[@title = '11301']").shouldBe(visible).click();
        $x("//button[@class = 'delete-confirm k-button k-primary']").shouldBe(visible).click();
    }

    public void correctDetail(String notes, String adrAlt, String lim, String limKass, String numDoc, String numPDV, String rnkp, String noteEc){
        switchWindowOrFrame.tabFrameClient("Tab4");
        $("#ed_NOTES").shouldBe(visible).setValue ( notes );
        $("#ed_ADR_ALT").shouldBe(visible).setValue ( adrAlt );
        $("#ed_LIM").shouldBe(visible).setValue ( lim );
        $("#ed_LIM_KASS").shouldBe(visible).setValue ( limKass );
        $("#ed_NOM_DOG").shouldBe(visible).setValue ( numDoc );
        $("#ed_NOMPDV").shouldBe(visible).setValue ( numPDV );
        $("#ed_RNKP").shouldBe(visible).setValue ( rnkp );
        $("#ed_NOTESEC").shouldBe(visible).setValue ( noteEc );
        $("#ddl_CRISK").shouldBe(visible).click ();
        $x("//*[@id = 'ddl_CRISK']/option[@value = '3']").shouldBe(visible).click ();
        $("#ddl_MB").shouldBe(visible).click ();
        $x("//*[@id = 'ddl_MB']/option[@value = '3']").shouldBe(visible).click ();
    }
}
