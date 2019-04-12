package com.bars.helperClasses;

import java.io.FileWriter;
import java.io.IOException;

public class WritingToFile {

    public static void Filewriting(String filename, String text) {
        try(FileWriter writer = new FileWriter("src/main/resources/"+filename, false)) {
            // запись всей строки
            writer.write(text);
            //запись по символам
            //writer.append('\n');
            //writer.append('E');
            writer.flush();
            //  System.out.println(filename);
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }}
}
