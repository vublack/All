package com.bars.GeneralСlasses;


import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class SearchPage {
    public void h1() {
        $(By.tagName("h1")).shouldHave(text("Оголошення"));
    }

    public void searchFunction(String functionName, String functionCode) {
        $("#findOpersText").shouldBe(visible).setValue(functionName).pressEnter();
        $x("//div[@id='resultSearch']/descendant::div[@data-codeapp='"+functionCode+"']").shouldBe(visible).click();
    }
    public void chooseBranch(){
        $(".btn_branches").shouldBe(visible).click();
        $x("//div[@id='treeview']/ul/li/ul/li/div/span[2]/span").shouldBe(visible).shouldHave(text("300465")).click();
        getWebDriver().navigate().refresh();
    }
}
