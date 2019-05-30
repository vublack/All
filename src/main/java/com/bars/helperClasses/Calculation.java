package com.bars.helperClasses;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public class Calculation {
    public String randomNum(){
        //Вставка рандомного числа
        Random random = new Random();
        int number = random.nextInt(899)+100;
        return String.valueOf(number);
    }

    public String randomNumWithBorder(int min, int max) {
        int random_number = min + (int) (Math.random() * max);
        String b = String.valueOf(random_number);
        return Arrays.toString( new String[]{b} );
    }
    public String sysdate() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        String strDate = formatter.format(date);
        System.out.println("Date Format with MM/dd/yyyy : "+ strDate);
        return strDate;
    }
}
