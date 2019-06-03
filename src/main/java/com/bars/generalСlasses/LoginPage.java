package com.bars.generalСlasses;

import com.bars.helperClasses.Calculation;
import com.bars.helperClasses.DBoperation;
import com.bars.helperClasses.WritingToFile;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;


public class LoginPage {
    private static Calculation calculation = new Calculation();
    private  static DBoperation dBoperation =new DBoperation();
    public void writePolygon(){
        String name = $x ( "//h2" ).shouldBe ( visible ).getText ( );
        WritingToFile.filewriting( "Polygon.txt", name);
    }
    public void fillLoginForm(String login, String password) {
        $("#txtUserName").setValue(login);
        $("#txtPassword").setValue(password).pressEnter();
    }
    public void goOn(){
        $("#btChangDate").shouldBe(visible).click();
    }

    public String getUtl = System.getProperty("selenide.baseUrl");

/*
    public String getDBnameViaUrl() {
        if getUtl.equals("http://10.10.17.50:8080/barsroot"){

        }

        equals("OBMMFOT"))
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        String strDate = formatter.format(date);
        System.out.println("Date Format with MM/dd/yyyy : "+ strDate);
        return strDate;
    }
*/

    public void changeDbBankDate() throws SQLException {
        System.out.println(getUtl);
        dBoperation.setupDBconection("MMFOM");
        dBoperation.updateDB("merge into fdat f\n" +
                        "using (select to_date('"+ calculation.sysdate() +"', 'mm-dd-yyyy') fd, 0 st from dual) t\n" +
                        "on (f.fdat = t.fd)\n" +
                        "when matched then update set stat = t.st\n" +
                        "when not matched then insert  (FDAT, STAT)\n" +
                        "values (t.fd, t.st)");
        dBoperation.updateDB("update branch_attribute_value ba set ba.attribute_value = '"+ calculation.sysdate() +"' where ba.attribute_code = 'BANKDATE'");

        dBoperation.closeConn();
    }
}
