package com.bars;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;


class LoginPage {
    public void prof(){
        $("#btnProfile").shouldBe(visible).click();}

    public String getPolygon() {
        return $x("(//*[text()='База даних:']/following::span)[1]").shouldBe(visible).getText();}
    void fillLoginForm(String login, String password) {
        $("#txtUserName").setValue(login);
        $("#txtPassword").setValue(password).pressEnter();
        }
    void goOn(){
        $("#btChangDate").shouldBe(visible).click();
        }
}
