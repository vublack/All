package com.bars;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static org.apache.logging.log4j.MarkerManager.exists;

public class ReadingFromFile {

    public static String read(String fileName) {
        //Этот спец. объект для построения строки
        StringBuilder sb = new StringBuilder();

        exists("src/main/resources/"+fileName);

        try {
            //Объект для чтения файла в буфер
            File file = new File("src/main/resources/"+fileName);
            BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile()));
            try {
                //В цикле построчно считываем файл
                String s;
                while ((s = in.readLine()) != null) {
                    sb.append(s);
                    // sb.append("\n");
                }
            } finally {
                //Также не забываем закрыть файл
                in.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }

        //Возвращаем полученный текст с файла
        return sb.toString();
    }
}