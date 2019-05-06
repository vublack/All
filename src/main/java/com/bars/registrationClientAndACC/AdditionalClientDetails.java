package com.bars.registrationClientAndACC;

import com.bars.generalСlasses.SwitchWindowOrFrame;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class AdditionalClientDetails {

    private static SwitchWindowOrFrame switchWindowOrFrame = new SwitchWindowOrFrame();

    public void enterGeneral(){
        switchWindowOrFrame.tabFrameClient("Tab5");
//        $("#gvMain_ctl02_imgEdHelp").shouldBe(visible).click ();
        $x("(//td[text()='Код виду клiєнта']/following::*[@title='Довідник'])[1]").shouldBe(visible).click();
        switchWindowOrFrame.kContentFrame();
        $x("//div[@title = '2']").shouldBe(visible).click ();
        $x("//button[@class = 'delete-confirm k-button k-primary']").shouldBe(visible).click ();
        /*
        if (ReadingFromFile.read ( "Polygon.txt" ).equals( "DB OBMMFOT" )){
            switchWindowOrFrame.tabFrameClient("Tab5");
            $x("(//td[text()='Дата запису в ЄДР']/following::input)[1]").shouldBe(visible).setValue("24.01.2018");
            $x("(//td[text()='Номер запису в ЄДР']/following::input)[1]").shouldBe(visible).setValue("132");
            }*/
    }

    public void enterFinMonFo(String citizenship, String firstFilldData, String dateOfIdentification, String identificationOfficer, String sourcesOfMoney){
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

    public void enterFinMonFop(String citizenship, String firstFilldData, String dateOfIdentification, String identificationOfficer, String sourcesOfMoney){
        switchWindowOrFrame.tabFrameClient("Tab5");
        $x("//a[contains(text(),'Фін.мон')]").shouldBe(visible).click ();
        $x("(//td[text() = 'Висн. щодо наявн.у кл-та потенц. та реал. фін.можл.для провед. опер.']/following::input[@title='Довідник'])[1]").shouldBe(visible).click ();
        switchWindowOrFrame.kContentFrame();
        $x("//td[contains(text(),'Відсутні')]").shouldBe(visible).click ();
        $x("//button[@class = 'delete-confirm k-button k-primary']").shouldBe(visible).click ();

        switchWindowOrFrame.tabFrameClient("Tab5");
        $x("(//td[text() = 'Ідентифікація клієнта проведена']/following::input[@title='Довідник'])[1]").shouldBe(visible).click ();
        switchWindowOrFrame.kContentFrame();
        $x("//div[@title = 'YES']").shouldBe(visible).click ();
        $x("//button[@class = 'delete-confirm k-button k-primary']").shouldBe(visible).click ();

        switchWindowOrFrame.tabFrameClient("Tab5");
        $x("(//td[text() = 'Належнiсть до публiчних дiячiв']/following::input[@title='Довідник'])[1]").shouldBe(visible).click ();
        switchWindowOrFrame.kContentFrame();
        $x("//div[@title = 'YES']").shouldBe(visible).click ();
        $x("//button[@class = 'delete-confirm k-button k-primary']").shouldBe(visible).click ();

        switchWindowOrFrame.tabFrameClient("Tab5");
        $x("(//td[text() = 'Оцінка репутації клієнта']/following::input[@title='Довідник'])[1]").shouldBe(visible).click ();
        switchWindowOrFrame.kContentFrame();
        $x("//tr[@class = 'k-alt']/td").shouldBe(visible).click ();
        $x("//button[@class = 'delete-confirm k-button k-primary']").shouldBe(visible).click ();

        switchWindowOrFrame.tabFrameClient("Tab5");
        $x("(//td[text() = 'Оцінка фін.стану: висновок']/following::input[@title='Довідник'])[1]").shouldBe(visible).click ();
        switchWindowOrFrame.kContentFrame();
        $x("//div[@title = 'Задовільний']").shouldBe(visible).click ();
        $x("//button[@class = 'delete-confirm k-button k-primary']").shouldBe(visible).click ();

        switchWindowOrFrame.tabFrameClient("Tab5");
//        $x("(//td[text() = 'Відомості про виконавчий орган']/following::input)[1]").shouldBe(visible).setValue ("DDD");
        $x("(//td[text() = 'Громадянство']/following::input)[1]").shouldBe(visible).setValue ( citizenship );
        $x("(//td[text() = 'Дата первинного заповнення анкети']/following::input)[1]").shouldBe(visible).click();
        $x("(//td[text() = 'Дата первинного заповнення анкети']/following::input)[1]").shouldBe(visible).sendKeys(firstFilldData);

        $x("(//td[text() = 'Дата проведеної iдентифiкацiї/уточнення інформації']/following::input)[1]").shouldBe(visible).click ();
        $x("(//td[text() = 'Дата проведеної iдентифiкацiї/уточнення інформації']/following::input)[1]").shouldBe(visible).sendKeys(dateOfIdentification);

        $x("(//td[text() = 'ПІБ та тел. працівника, відповідальн. за ідент-цію і вивчення клієнта']/following::input)[1]").shouldBe(visible).setValue (identificationOfficer);
        $x("(//td[text() = 'Характеристика джерел надходжень коштiв']/following::input)[1]").shouldBe(visible).setValue (sourcesOfMoney);



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
        $x("//button[@class = 'delete-confirm k-button k-primary']").shouldBe(visible).click ();
        switchWindowOrFrame.tabFrameClient("Tab5");
        $("#gvMain_ctl08_imgEdHelp").shouldBe(visible).click ();
        switchWindowOrFrame.kContentFrame();
        $x("//div[@title = '5']").shouldBe(visible).click ();
        $x("//button[@class = 'delete-confirm k-button k-primary']").shouldBe(visible).click ();
        switchWindowOrFrame.tabFrameClient("Tab5");
        $("#gvMain_ctl09_imgEdHelp").shouldBe(visible).click ();
        switchWindowOrFrame.kContentFrame();
        $x("//div[@title = '2']").shouldBe(visible).click ();
        $x("//button[@class = 'delete-confirm k-button k-primary']").shouldBe(visible).click ();
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
