package com.bars;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;


class LoginPage {
    public void writePolygon(){
        String name = $x ( "//h2" ).shouldBe ( visible ).getText ( );
        WritingToFile.Filewriting( "Polygon.txt", name);
    }
    void fillLoginForm(String login, String password) {
        $("#txtUserName").setValue(login);
        $("#txtPassword").setValue(password).pressEnter();
        }
    void goOn(){
        $("#btChangDate").shouldBe(visible).click();
        }
}
