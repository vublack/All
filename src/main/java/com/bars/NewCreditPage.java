package com.bars;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;


class NewCreditPage {
    private SwitchWindow switchWindow = page(SwitchWindow.class);

            // Вкладка Параметри КД
    void fillNumSum(String num, String sum){
        $(byXpath("//*[@ng-model='credit.numValue']")).shouldBe(visible).setValue(num);
        $(byXpath("(//*[text()='Початкова сума']/following::*[@class='k-formatted-value k-input'])[1]")).shouldBe(visible).click();
        $(byXpath("//*[@k-ng-model='credit.sumValue']")).setValue(sum);
    }
    void fillInitiative(String initiative){
        SelenideElement initiator=$("#inptBranch").shouldBe(visible);
        executeJavaScript("arguments[0].removeAttribute('disabled');",initiator);
        initiator.shouldBe(visible).setValue(initiative);

    }
/*    void initiativeButtonClick(){
        $x("//label[text()='Ініціатива']//following-sibling::button").shouldBe(visible).click();
        switchWindow.switchToWindow();
        $x("//*[text()='Довідник: ']").shouldBe(visible).click();
        SelenideElement filterBranch = $x("//th[@data-field='BRANCH']/a[@class='k-grid-filter']").shouldBe(visible);
        executeJavaScript("arguments[0].setAttribute('style', 'overflow: visible')",filterBranch);
        executeJavaScript("arguments[0].click()",filterBranch);
    }*/
    void filterInput(String znach){
        $(byXpath("//input[@data-bind='value:filters[0].value']")).shouldBe(visible).setValue(znach).pressEnter();
    }
    void filterInputClick(){
        $(byXpath("//div[text()='Рядки із записами']/following-sibling::span[@class='k-widget k-numerictextbox']")).shouldBe(visible).click();
    }
    void okpoButtonClick(){
        $(byXpath("//label[text()='OKПO']/preceding::button[@class='pf-icon pf-16 pf-book k-button'][1]")).shouldBe(visible).click();
        switchWindow.switchToWindow();
        $x("(//div[contains(@title,'Клієнт')])[3]").shouldBe(visible).click();
        $(byXpath("//th[@data-field='RNK']/a[@class='k-grid-filter']")).shouldBe(visible).click();
    }
    void okpoRNKchoose(String oKPOchoose, String rNKchoose){
        executeJavaScript("$('#refCust').val(arguments[0])", oKPOchoose);
        executeJavaScript("$('#inptRnk').val(arguments[0])", rNKchoose);
        executeJavaScript("$(\"#refCust\").trigger(\"change\");\n" +
                                "$(\"#inptRnk\").trigger(\"change\");");

    }
    void ratesInput(String rate){
        SelenideElement rateValue = $(byAttribute("k-ng-model", "credit.rateAValue"));
        executeJavaScript("arguments[0].setAttribute('style', 'display: inline-block')",rateValue);
        rateValue.shouldBe(visible).setValue(rate);
    }
    void ratesButtonClick(){
        $x("//input[@id='refBaseNameRate']/preceding-sibling::button").shouldBe(visible).click();
        switchWindow.switchToWindow();
        $x("//th[@data-field='BR_ID']/a[@class='k-grid-filter']").shouldBe(visible).click();
    }
    void typeOfCredit(String creditType){
        $(byXpath("//span[text()='Самостійно залучені кошти']/preceding::span[@class='k-select'][1]")).shouldBe(visible).click();
        String type = String.format("//li[text()='%s']", creditType);
        $(byXpath(type)).shouldBe(visible).click();
    }
    void goalOfCredit(String creditGoal){
        $(byXpath("(//*[text()='Продукт']/following::span[@class='k-select'])[1]")).shouldBe(visible).click();
        String goal = String.format("//li[text()='%s']", creditGoal);
        $(byXpath(goal)).shouldBe(visible).click();
    }
    void productOfCredit1(){
        $(byXpath("//input[@id='refProd']/following-sibling::button")).shouldBe(visible).click();
        switchWindow.switchToWindow();
        $(byXpath("//button[text()='Відмінити']")).shouldBe(visible).click();
    }
    void productOfCredit2(){
        $(byXpath("//input[@id='refProd']/following-sibling::button")).shouldBe(visible).click();
        switchWindow.switchToWindow();
        $(byXpath("//th[@data-field='ID']/a[@class='k-grid-filter']")).shouldBe(visible).click();
    }

    void chooseGKD(){
//    void chooseGKD(String gKD){
//        $(byXpath("(//label[text()='Приналежність до ГКД:']/following::span[@class='k-select'])[1]")).shouldBe(visible).click();
//        String gkdMembership = String.format("((//li[@class='k-item ng-scope'])[text()='%s'])", gKD);
//        $(byXpath(gkdMembership)).shouldBe(visible).click();
        executeJavaScript("$('[k-ng-model=\"credit.belongtoGKD\"]').data('kendoDropDownList').select(1);");
        executeJavaScript("$('[k-ng-model=\"credit.belongtoGKD\"]').data('kendoDropDownList').trigger('change');");
    }

    String getConclusionDate(){
        String conclusionDateOfKD = $(byXpath("//input[@k-ng-model='credit.conslValue']")).getValue();
        System.out.println("firstPaymentDate = " + conclusionDateOfKD);
        return conclusionDateOfKD;
    }
    //Вкладка Дані про погашення
    void firstPaymentDate(String firstDate){
        $(byXpath("//*[text()='Дані про погашення']")).shouldBe(visible).click();
        $(byXpath("//input[@name='tbDayOfPay']/preceding-sibling::input")).shouldBe(visible).click();
        $(byXpath("//input[@name='tbDayOfPay']")).shouldBe(visible).setValue("1");
        $(byXpath("//input[@name='dpFirtsPayDate']")).shouldBe(visible).click();
        $(byXpath("//input[@name='dpFirtsPayDate']")).sendKeys(firstDate);
    }
    //Вкладка Дод. параметри КД
        //Основні
    void creditInsurance(){
        $(byXpath("//span[text()='Дод. параметри КД']")).shouldBe(visible).click();
        $(byXpath("(//*[text()='Страхування кредиту']/following::a)[1]")).shouldBe(visible).click();
        switchWindow.switchToWindow();
        $(byXpath("//th[@data-field='ID']/a[@class='k-grid-filter']")).shouldBe(visible).click();
    }
        //Бюро Кредит.Історій(Спец)
        void contractStatus(){
        $(byXpath("//span[text()='Бюро Кредит.Історій(Спец)']")).shouldBe(visible).click();
        $(byXpath("(//*[text()='CIG_D13 Статус договору']/following::a)[1]")).shouldBe(visible).click();
        switchWindow.switchToWindow();
        $(byXpath("//th[@data-field='ID']/a[@class='k-grid-filter']")).shouldBe(visible).click();
    }
        //Додаткові
        void creditProduct(){
        $(byXpath("//span[text()='Додаткові']")).shouldBe(visible).click();
        $(byXpath("(//*[text()='Кредитний продукт']/following::a)[1]")).shouldBe(visible).click();
        switchWindow.switchToWindow();
        $(byXpath("//th[@data-field='CPROD_ID']/a[@class='k-grid-filter']")).shouldBe(visible).click();
    }
    void fillEIBCB(){
        $(byXpath("(//*[text()='EIBCB']/following::a)[1]")).shouldBe(visible).click();
        switchWindow.switchToWindow();
        $(byXpath("//th[@data-field='COLBB_ID']/a[@class='k-grid-filter']")).shouldBe(visible).click();
    }
    void fillEIBCE(String eibValue){
        $(byXpath("(//*[text()='EIBCE']/following::a)[1]")).shouldBe(visible).click();
        $(byXpath("(//*[text()='EIBCE']/following::input)[2]")).shouldBe(visible).setValue(eibValue);
    }
    void fillEIBCR(String eibValue){
        $(byXpath("(//*[text()='EIBCR']/following::a)[1]")).shouldBe(visible).click();
        $(byXpath("(//*[text()='EIBCR']/following::input)[2]")).shouldBe(visible).setValue(eibValue);
    }
    void fillEIBCS(){
        $(byXpath("(//*[text()='EIBCS']/following::a)[1]")).shouldBe(visible).click();
        switchWindow.switchToWindow();
        $(byXpath("//th[@data-field='CUSSEG_ID']/a[@class='k-grid-filter']")).shouldBe(visible).click();
    }
    void fillEIBCW(String eibValue){
        $(byXpath("(//*[text()='EIBCW']/following::a)[1]")).shouldBe(visible).click();
        $(byXpath("(//*[text()='EIBCW']/following::input)[2]")).shouldBe(visible).setValue(eibValue);
    }
    void fillEIBIE(String eibValue){
        $(byXpath("(//*[text()='EIBIE']/following::a)[1]")).shouldBe(visible).click();
        $(byXpath("(//*[text()='EIBIE']/following::input)[2]")).shouldBe(visible).setValue(eibValue);
    }
    void fillEIBIS(){
        $(byXpath("(//*[text()='EIBIS']/following::a)[1]")).shouldBe(visible).click();
        switchWindow.switchToWindow();
        $(byXpath("//th[@data-field='ID']/a[@class='k-grid-filter']")).shouldBe(visible).click();
    }
    void fillEIBND(String eibValue){
        $(byXpath("(//*[text()='EIBND']/following::a)[1]")).shouldBe(visible).click();
        $(byXpath("(//*[text()='EIBND']/following::input)[1]")).shouldBe(visible).setValue(eibValue);
    }
    void fillEIBNE(String eibValue){
        $(byXpath("(//*[text()='EIBNE']/following::a)[1]")).shouldBe(visible).click();
        $(byXpath("(//*[text()='EIBNE']/following::input)[1]")).shouldBe(visible).setValue(eibValue);
    }
    void fillEIBPF(){
        $(byXpath("(//*[text()='EIBNE']/following::a[@title='Перейдіть на наступну сторінку'])[1]")).shouldBe(visible).click();
        $(byXpath("(//*[text()='EIBPF']/following::a)[1]")).shouldBe(visible).click();
        switchWindow.switchToWindow();
        $(byXpath("//th[@data-field='PRIFIN_ID']/a[@class='k-grid-filter']")).shouldBe(visible).click();
    }
    void fillEIBSF(){
        $(byXpath("(//*[text()='EIBSF']/following::a)[1]")).shouldBe(visible).click();
        switchWindow.switchToWindow();
        $(byXpath("//th[@data-field='SECFIN_ID']/a[@class='k-grid-filter']")).shouldBe(visible).click();
    }
    void fillEIBTV(String eibValue){
        $(byXpath("(//*[text()='EIBTV']/following::a)[1]")).shouldBe(visible).click();
        $(byXpath("(//*[text()='EIBTV']/following::input)[2]")).shouldBe(visible).setValue(eibValue);
    }

        // Застава
    void notary(){
        $(byXpath("//span[text()='Застава']")).shouldBe(visible).click();
        $(byXpath("(//*[text()='ПІБ нотаріуса']/following::a)[1]")).shouldBe(visible).click();
        switchWindow.switchToWindow();
        $(byXpath("//th[@data-field='ID']/a[@class='k-grid-filter']")).shouldBe(visible).click();
    }
    void updateParameter(){
        $(byXpath("//a[@class='k-button k-button-icontext k-primary k-grid-update']")).shouldBe(visible).click();
    }
    //Нажимаем на кнопку "Зберігти"
    void saveButtonClick(){
        $(byXpath("//button[@class='k-button k-toolbar-first-visible k-toolbar-last-visible']")).shouldBe(visible).click();
        $(byXpath("//button[@class='k-loading-image']")).shouldNotBe(exist);
    }
    void confirmOfCreditCreate(){
        $(byXpath("//*[contains(text(), 'Створено КД')]")).shouldBe(visible);
        $(byXpath("//button[@class='delete-confirm k-button k-primary']")).shouldBe(visible).click();
    }
    String getREF(){
        return $(By.tagName("h1")).shouldBe(visible).getText().replace("Кредитний договір (", "").replace(")", "");
    }


}
