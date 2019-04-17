package com.bars.registrationClientAndACC;

import com.bars.generalСlasses.SwitchWindowOrFrame;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class EconomDetails {
    private static SwitchWindowOrFrame switchWindowOrFrame = new SwitchWindowOrFrame();

    public void editingEconomDetails(){
        $("#ddl_FS_com").shouldBe(visible).click ();
        switchWindowOrFrame.kContentFrame();
        $x("//*[@title = '32']").shouldBe(visible).doubleClick ();
        switchWindowOrFrame.tabFrameClient( "Tab2" );
        $("#ddl_VED_com").shouldBe(visible).click ();
        switchWindowOrFrame.kContentFrame();
        $x("//*[@title = 'N2529']").shouldBe(visible).doubleClick();
    }

    public void enterEconNormforFOP(String k110, String k070){
        $("#ed_ISE").shouldBe(visible).setValue ( k110 );
        $("#ed_VED").shouldBe(visible).setValue ( k070 );
    }

}
