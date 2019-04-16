package com.bars.registrationClientAndACC;

import com.bars.generalСlasses.SwitchWindowOrFrame;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;


public class ClientDetails {
    private static SwitchWindowOrFrame switchWindowOrFrame = new SwitchWindowOrFrame();

    public String getHeadingText(){
        switchWindowOrFrame.tabFrameClient("Tab3");
        return $x("//*[@id = 'tblMain']/tbody/tr[1]/td/label").getText();
    }

    public void editingClientDetail(String birthPlace, String workPhone){
        switchWindowOrFrame.tabFrameClient("Tab3");
        $("#ed_BPLACE").shouldBe(visible).setValue (birthPlace);
        $("#ed_TELW").shouldBe(visible).setValue (workPhone);
    }

    public void enterDocumentDetails(String organ, String ser, String numDoc, String passpDate, String datePhoto, String birthday){
        switchWindowOrFrame.tabFrameClient( "Tab3" );
        $("#ddl_PASSP").shouldBe(visible).click ();
        $x("//select[@id = 'ddl_PASSP']/option[@value = '1']").shouldBe(visible).click ();
        $("#ed_ORGAN").shouldBe(visible).setValue(organ);
        $("#ed_SER").shouldBe(visible).setValue (ser);
        $("#ed_NUMDOC").shouldBe(visible).setValue (numDoc);
        $("#ddl_SEX").shouldBe(visible).click ();
        $("#ed_PDATE").shouldBe(visible).click();
        $("#ed_PDATE").shouldBe(visible).sendKeys(passpDate);
        $("#ed_DATE_PHOTO").shouldBe(visible).click();
        $("#ed_DATE_PHOTO").shouldBe(visible).sendKeys(datePhoto);
        $("#ed_BDAY").shouldBe(visible).click();
        $("#ed_BDAY").shouldBe(visible).sendKeys(birthday);
        $x( "//select[@id = 'ddl_SEX']/option[@value = '1']").shouldBe(visible).click();
    }



    public void enterNumberPhone(String tel){
        $("#ed_TELM_CODE").shouldBe(visible).click ();
        switchWindowOrFrame.kContentFrame();
        $x("//div[@title = '92']").shouldBe(visible).doubleClick();
        switchWindowOrFrame.tabFrameClient("Tab3");
        $("#ed_TELM").shouldBe(visible).setValue(tel);
        $("#ed_TELD_CODE").shouldBe(visible).click();
        $("#ed_TELD_CODE").shouldBe(visible).click();
        switchWindowOrFrame.kContentFrame();
        $x("//td[@role = 'gridcell']/div[@title]").shouldBe(visible).doubleClick();
        switchWindowOrFrame.tabFrameClient("Tab3");
        $("#ed_TELD").shouldBe(visible).setValue(tel);
    }
}
