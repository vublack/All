package com.bars.generalСlasses;

import com.bars.helperClasses.WritingToFile;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;


public class LoginPage {
    public void writePolygon(){
        String name = $x ( "//h2" ).shouldBe ( visible ).getText ( );
        WritingToFile.Filewriting( "Polygon.txt", name);
    }
    public void fillLoginForm(String login, String password) {
        $("#txtUserName").setValue(login);
        $("#txtPassword").setValue(password).pressEnter();
    }
    public void goOn(){
        $("#btChangDate").shouldBe(visible).click();
    }
}
