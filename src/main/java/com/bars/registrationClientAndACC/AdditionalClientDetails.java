package com.bars.registrationClientAndACC;

import com.bars.generalСlasses.SwitchWindowOrFrame;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class AdditionalClientDetails {

    private static SwitchWindowOrFrame switchWindowOrFrame = new SwitchWindowOrFrame();


    public String getGeneralText(){
        switchWindowOrFrame.tabFrameClient("Tab5");
        return $( By.linkText("Загальні")).getText ();
    }

    public String getFinMonText(){
        switchWindowOrFrame.tabFrameClient("Tab5");
        return $( By.linkText("Фін.мон.")).getText ();
    }

    public String getBPKText(){
        switchWindowOrFrame.tabFrameClient("Tab5");
        return $( By.linkText("БПК")).getText ();
    }

    public String getSanctionsText(){
        switchWindowOrFrame.tabFrameClient("Tab5");
        return $( By.linkText("Санкції")).getText ();
    }

    public String getCreditRegisterText(){
        switchWindowOrFrame.tabFrameClient("Tab5");
        return $( By.linkText("Для Кредитного реєстру")).getText ();
    }

    public String getOtherText(){
        switchWindowOrFrame.tabFrameClient("Tab5");
        return $( By.linkText("Інші")).getText ();
    }

    public String getRiskCriteriaText(){
        switchWindowOrFrame.tabFrameClient("Tab5");
        return $( By.linkText("Критерії ризику")).getText ();
    }

    public void enterGeneral(){
        switchWindowOrFrame.tabFrameClient("Tab5");
        $("#gvMain_ctl02_imgEdHelp").shouldBe(visible).click ();
        switchWindowOrFrame.kContentFrame();
        $x("//div[@title = '2']").shouldBe(visible).click ();
        $x("//button[@class = 'delete-confirm k-button k-primary']").shouldBe(visible).click ();
    }

    public void enterFinMon(String citizenship, String firstFilldData, String dateOfIdentification, String identificationOfficer, String sourcesOfMoney){
        switchWindowOrFrame.tabFrameClient("Tab5");
        $x("//a[contains(text(),'Фін.мон')]").shouldBe(visible).click ();
        $("#gvMain_ctl02_imgEdHelp").shouldBe(visible).click ();
        switchWindowOrFrame.kContentFrame();
        $x("//td[contains(text(),'Відсутні')]").shouldBe(visible).click ();
        $x("//button[@class = 'delete-confirm k-button k-primary']").shouldBe(visible).click ();
        switchWindowOrFrame.tabFrameClient("Tab5");
        $("#gvMain_ctl03_edEdVal").shouldBe(visible).setValue ( citizenship );
        $("#gvMain_ctl04_edEdVal").shouldBe(visible).click();
        $("#gvMain_ctl04_edEdVal").shouldBe(visible).sendKeys(firstFilldData);
        $("#gvMain_ctl05_edEdVal").shouldBe(visible).click ();
        $("#gvMain_ctl05_edEdVal").shouldBe(visible).sendKeys(dateOfIdentification);
        $("#gvMain_ctl10_edEdVal").shouldBe(visible).setValue (identificationOfficer);
        $("#gvMain_ctl11_edEdVal").shouldBe(visible).setValue (sourcesOfMoney);
        $("#gvMain_ctl06_imgEdHelp").shouldBe(visible).click ();
        switchWindowOrFrame.kContentFrame();
        $x("//div[@title = 'YES']").shouldBe(visible).click ();
        $x("//button[@class = 'delete-confirm k-button k-primary']").shouldBe(visible).click ();
        switchWindowOrFrame.tabFrameClient("Tab5");
        $("#gvMain_ctl08_imgEdHelp").shouldBe(visible).click ();
        switchWindowOrFrame.kContentFrame();
        $x("//tr[@class = 'k-alt']/td").shouldBe(visible).click ();
        $x("//button[@class = 'delete-confirm k-button k-primary']").shouldBe(visible).click ();
        switchWindowOrFrame.tabFrameClient("Tab5");
        $("#gvMain_ctl09_imgEdHelp").shouldBe(visible).click ();
        switchWindowOrFrame.kContentFrame();
        $x("//div[@title = 'Задовільний']").shouldBe(visible).click ();
        $x("//button[@class = 'delete-confirm k-button k-primary']").shouldBe(visible).click ();
    }
    public void enterforCreditRegister(String personsDependent,String employerOKPO, String employerName, String unconfirmedIncome, String confirmedIncome){
        switchWindowOrFrame.tabFrameClient("Tab5");
        $( By.linkText("Для Кредитного реєстру")).shouldBe(visible).click();
        $("#gvMain_ctl02_edEdVal").shouldBe(visible).setValue (personsDependent);
        $("#gvMain_ctl03_edEdVal").shouldBe(visible).setValue (employerOKPO);
        $("#gvMain_ctl04_edEdVal").shouldBe(visible).setValue (employerName);
        $("#gvMain_ctl05_edEdVal").shouldBe(visible).setValue (unconfirmedIncome);
        $("#gvMain_ctl07_edEdVal").shouldBe(visible).setValue (confirmedIncome);
        $("#gvMain_ctl06_imgEdHelp").shouldBe(visible).click ();
        switchWindowOrFrame.kContentFrame();
        $x("//div[@title = '5']").shouldBe(visible).click ();
        $("#gvMain_ctl08_imgEdHelp").shouldBe(visible).click ();
        switchWindowOrFrame.kContentFrame();
        $x("//div[@title = '5']").shouldBe(visible).click ();
        $("#gvMain_ctl09_imgEdHelp").shouldBe(visible).click ();
        switchWindowOrFrame.kContentFrame();
        $x("//div[@title = '2']").shouldBe(visible).click ();
    }

    public void enterOther(){
        switchWindowOrFrame.tabFrameClient("Tab5");
        $x("//a[contains(text(),'Інші')]").shouldBe(visible).click ();
        $("#gvMain_ctl03_imgEdHelp").shouldBe(visible).click ();
        switchWindowOrFrame.kContentFrame();
        $x("//div[@title = '1']").shouldBe(visible).click ();
        $x("//button[@class = 'delete-confirm k-button k-primary']").shouldBe(visible).click ();
    }
}
