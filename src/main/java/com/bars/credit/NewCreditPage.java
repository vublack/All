package com.bars.credit;

import com.bars.generalСlasses.SwitchWindowOrFrame;
import com.codeborne.selenide.SelenideElement;
import org.apache.tika.metadata.Office;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.*;


public class NewCreditPage {
    private SwitchWindowOrFrame switchWindowOrFrame = page(SwitchWindowOrFrame.class);

            // Вкладка Параметри КД
    public void fillNumSum(String num, String sum){
        $x("//*[@ng-model='credit.numValue']").shouldBe(visible).setValue(num);
        $x("(//*[text()='Початкова сума']/following::*[@class='k-formatted-value k-input'])[1]").shouldBe(visible).click();
        $x("//*[@k-ng-model='credit.sumValue']").setValue(sum);
    }
    public void fillInitiative(String initiative){
        SelenideElement initiator=$("#inptBranch").shouldBe(visible);
        executeJavaScript("arguments[0].removeAttribute('disabled');",initiator);
        initiator.shouldBe(visible).setValue(initiative);

    }

    public void filterInput(String znach){
        $x("//input[@data-bind='value:filters[0].value']").shouldBe(visible).setValue(znach).pressEnter();
    }
    public void filterInput2(String znach){
        $x("(//input[@data-bind='value:filters[0].value'])[2]").shouldBe(visible).setValue(znach).pressEnter();
    }
    public void filterInputClick(){
        $x("//div[text()='Рядки із записами']/following-sibling::span[@class='k-widget k-numerictextbox']").shouldBe(visible).click();
    }

    public void okpoRNKchoose(String oKPOchoose, String rNKchoose){
        executeJavaScript("$('#refCust').val(arguments[0])", oKPOchoose);
        executeJavaScript("$('#inptRnk').val(arguments[0])", rNKchoose);
        executeJavaScript("$(\"#refCust\").trigger(\"change\");\n" +
                                "$(\"#inptRnk\").trigger(\"change\");");

    }
    public void ratesInput(String rate){
        SelenideElement rateValue = $(byAttribute("k-ng-model", "credit.rateAValue"));
        executeJavaScript("arguments[0].setAttribute('style', 'display: inline-block')",rateValue);
        rateValue.shouldBe(visible).setValue(rate);
    }
    public void ratesButtonClick(){
        $x("//input[@id='refBaseNameRate']/preceding-sibling::button").shouldBe(visible).click();
        switchWindowOrFrame.switchToWindow2();
        $x("//th[@data-field='BR_ID']/a[@class='k-grid-filter']").shouldBe(visible).click();
    }
    public void typeOfCredit(String creditType){
        $x("//span[text()='Самостійно залучені кошти']/preceding::span[@class='k-select'][1]").shouldBe(visible).click();
        String type = String.format("//li[text()='%s']", creditType);
        $x(type).shouldBe(visible).click();
    }
    public void goalOfCredit(String creditGoal){
        $x("(//*[text()='Продукт']/following::span[@class='k-select'])[1]").shouldBe(visible).click();
        String goal = String.format("//li[text()='%s']", creditGoal);
        $x(goal).shouldBe(visible).click();
    }
    public void productOfCredit1(String creditProguct){
        executeJavaScript("$('#refProd').val(arguments[0])", creditProguct);
        executeJavaScript("$(\"#refProd\").trigger(\"change\");");
/*
        $x("//input[@id='refProd']/following-sibling::button").shouldBe(visible).click();
        switchWindowOrFrame.switchToWindow2();
        $x("//button[text()='Відмінити']").shouldBe(visible).click();
 */   }
/*
    public void productOfCredit2(){
        $x("//input[@id='refProd']/following-sibling::button").shouldBe(visible).click();
        switchWindowOrFrame.switchToWindow2();
        $x("//th[@data-field='ID']/a[@class='k-grid-filter']").shouldBe(visible).click();
    }
*/

    public void chooseGKD(){
//    void chooseGKD(String gKD){
//        $x("(//label[text()='Приналежність до ГКД:']/following::span[@class='k-select'])[1]")).shouldBe(visible).click();
//        String gkdMembership = String.format("((//li[@class='k-item ng-scope'])[text()='%s'])", gKD);
//        $x(gkdMembership)).shouldBe(visible).click();
        executeJavaScript("$('[k-ng-model=\"credit.belongtoGKD\"]').data('kendoDropDownList').select(1);");
        executeJavaScript("$('[k-ng-model=\"credit.belongtoGKD\"]').data('kendoDropDownList').trigger('change');");
    }

    public String getConclusionDate(){
        String conclusionDateOfKD = $x("//input[@k-ng-model='credit.conslValue']").getValue();
        System.out.println("firstPaymentDate = " + conclusionDateOfKD);
        return conclusionDateOfKD;
    }
    //Вкладка Дані про погашення
    public void firstPaymentDate(String firstDate){
        $x("//*[text()='Дані про погашення']").shouldBe(visible).click();
        $x("//input[@name='tbDayOfPay']/preceding-sibling::input").shouldBe(visible).click();
        $x("//input[@name='tbDayOfPay']").shouldBe(visible).setValue("1");
        $x("//input[@name='dpFirtsPayDate']").shouldBe(visible).click();
        $x("//input[@name='dpFirtsPayDate']").sendKeys(firstDate);
    }
    //Вкладка Дод. параметри КД
    public void pressFilterByCode(){
        $x("(//th[text()='Код реквізиту']/a)").shouldBe(visible).click();
    }
        //Основні
    public void additionalParamTab(){
        $x("//span[text()='Дод. параметри КД']").shouldBe(visible).click();
    }
     public void creditInsurance(String creditInsurance){
        $x("(//*[text()='Страхування кредиту']/following::a)[1]").shouldBe(visible).click();
        switchWindowOrFrame.switchToWindow2();
        $x("//*[text()='Відмінити']").shouldBe(visible).click();
//        $x("//th[@data-field='ID']/a[@class='k-grid-filter']").pressEscape();
        $x("//*[text()='INSCC']/following::input").shouldBe(visible).setValue(creditInsurance);

    }
    public void marketRate(String marketRate){
        $x("(//*[text()='INTRT']/following::a)[1]").shouldBe(visible).click();
        $x("(//*[text()='INTRT']/following::input)[1]").shouldBe(visible).setValue(marketRate);
    }

    public void s260(){
        $x("(//*[text()='Код iндив.споживання за цiлями S260']/following::a)[1]").shouldBe(visible).click();
        switchWindowOrFrame.switchToWindow2();
        $x("//th[@data-field='S260']/a[@class='k-grid-filter']").shouldBe(visible).click();
    }
    public void partnerPresent(){
        $x("(//*[text()='Наявність партнеру(Так/Ні)']/following::a)[1]").shouldBe(visible).click();
        switchWindowOrFrame.switchToWindow2();
        $x("//th[@data-field='ID']/a[@class='k-grid-filter']").shouldBe(visible).click();
    }
    public void сentralOfficeContract(){
        $x("(//*[text()='Договір співробітництва заключено на рівні ЦА']/following::a)[1]").shouldBe(visible).click();
        switchWindowOrFrame.switchToWindow2();
        $x("//th[@data-field='ID']/a[@class='k-grid-filter']").shouldBe(visible).click();
    }

        //Бюро Кредит.Історій(Спец)
    public void contractStatus(){
        $x("//span[text()='Бюро Кредит.Історій(Спец)']").shouldBe(visible).click();
        $x("(//*[text()='CIG_D13 Статус договору']/following::a)[1]").shouldBe(visible).click();
        switchWindowOrFrame.switchToWindow2();
        $x("//th[@data-field='ID']/a[@class='k-grid-filter']").shouldBe(visible).click();
    }

        //Додаткові
    public void creditProduct(){
        $x("//span[text()='Додаткові']").shouldBe(visible).click();
        $x("(//*[text()='Кредитний продукт']/following::a)[1]").shouldBe(visible).click();
        switchWindowOrFrame.switchToWindow2();
        $x("//th[@data-field='CPROD_ID']/a[@class='k-grid-filter']").shouldBe(visible).click();
    }
    public void fillEIBCB(){
        $x("(//*[text()='EIBCB']/following::a)[1]").shouldBe(visible).click();
        switchWindowOrFrame.switchToWindow2();
        $x("//th[@data-field='COLBB_ID']/a[@class='k-grid-filter']").shouldBe(visible).click();
    }
    public void fillEIBCE(String eibValue){
        $x("(//*[text()='EIBCE']/following::a)[1]").shouldBe(visible).click();
        $x("(//*[text()='EIBCE']/following::input)[2]").shouldBe(visible).setValue(eibValue);
    }
    public void fillEIBCR(String eibValue){
        $x("(//*[text()='EIBCR']/following::a)[1]").shouldBe(visible).click();
        $x("(//*[text()='EIBCR']/following::input)[2]").shouldBe(visible).setValue(eibValue);
    }
    public void fillEIBCS(){
        $x("(//*[text()='EIBCS']/following::a)[1]").shouldBe(visible).click();
        switchWindowOrFrame.switchToWindow2();
        $x("//th[@data-field='CUSSEG_ID']/a[@class='k-grid-filter']").shouldBe(visible).click();
    }
    public void fillEIBCW(String eibValue){
        $x("(//*[text()='EIBCW']/following::a)[1]").shouldBe(visible).click();
        $x("(//*[text()='EIBCW']/following::input)[2]").shouldBe(visible).setValue(eibValue);
    }
    public void fillEIBIE(String eibValue){
        $x("(//*[text()='EIBIE']/following::a)[1]").shouldBe(visible).click();
        $x("(//*[text()='EIBIE']/following::input)[2]").shouldBe(visible).setValue(eibValue);
    }
    public void fillEIBIS(){
        $x("(//*[text()='EIBIS']/following::a)[1]").shouldBe(visible).click();
        switchWindowOrFrame.switchToWindow2();
        $x("//th[@data-field='ID']/a[@class='k-grid-filter']").shouldBe(visible).click();
    }
    public void fillEIBND(String eibValue){
        $x("(//*[text()='EIBND']/following::a)[1]").shouldBe(visible).click();
        $x("(//*[text()='EIBND']/following::input)[1]").shouldBe(visible).setValue(eibValue);
    }
    public void fillEIBNE(String eibValue){
        $x("(//*[text()='EIBNE']/following::a)[1]").shouldBe(visible).click();
        $x("(//*[text()='EIBNE']/following::input)[1]").shouldBe(visible).setValue(eibValue);
    }
    public void fillEIBPF(){
        $x("(//*[text()='EIBNE']/following::a[@title='Перейдіть на наступну сторінку'])[1]").shouldBe(visible).click();
        $x("(//*[text()='EIBPF']/following::a)[1]").shouldBe(visible).click();
        switchWindowOrFrame.switchToWindow2();
        $x("//th[@data-field='PRIFIN_ID']/a[@class='k-grid-filter']").shouldBe(visible).click();
    }
    public void fillEIBSF(){
        $x("(//*[text()='EIBSF']/following::a)[1]").shouldBe(visible).click();
        switchWindowOrFrame.switchToWindow2();
        $x("//th[@data-field='SECFIN_ID']/a[@class='k-grid-filter']").shouldBe(visible).click();
    }
    public void fillEIBTV(String eibValue){
        $x("(//*[text()='EIBTV']/following::a)[1]").shouldBe(visible).click();
        $x("(//*[text()='EIBTV']/following::input)[2]").shouldBe(visible).setValue(eibValue);
    }

        // Застава
    public void notary(){
        $x("//span[text()='Застава']").shouldBe(visible).click();
        $x("(//*[text()='ПІБ нотаріуса']/following::a)[1]").shouldBe(visible).click();
        switchWindowOrFrame.switchToWindow2();
        $x("//th[@data-field='ID']/a[@class='k-grid-filter']").shouldBe(visible).click();
    }
    public void updateParameter(){
        $x("//a[@class='k-button k-button-icontext k-primary k-grid-update']").shouldBe(visible).click();
    }
    //Нажимаем на кнопку "Зберігти"
    public void saveButtonClick(){
        $x("//button[@class='k-button k-toolbar-first-visible k-toolbar-last-visible']").shouldBe(visible).click();
        $x("//button[@class='k-loading-image']").shouldNotBe(exist);
    }
    public void confirmOfCreditCreate(){
        $x("//*[contains(text(), 'Створено КД')]").shouldBe(visible);
        $x("//button[@class='delete-confirm k-button k-primary']").shouldBe(visible).click();
    }
    public String getREF(){
        return $(By.tagName("h1")).shouldBe(visible).getText().replace("Кредитний договір (", "").replace(")", "");
    }

    public String getNBSforSS(String product){
        return product.substring(0,4);
    }

    public String getOB22forSS(String product){
        return product.substring(4);
    }



}
