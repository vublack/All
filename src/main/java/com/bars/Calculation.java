package com.bars;

import java.util.Random;

class Calculation {
    String randomNum(){
        //Вставка рандомного числа
        Random random = new Random();
        int number = random.nextInt(899)+100;
        return String.valueOf(number);
    }
}
