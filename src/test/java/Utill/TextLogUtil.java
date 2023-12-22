package Utill;

import java.io.FileWriter;
import java.io.IOException;

public class TextLogUtil {
    FileWriter fileWriter;
    public TextLogUtil(String name) {
        try {
            fileWriter = new FileWriter("resources/output_data/"+name,true);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void logg(String log) {
        try {
            fileWriter.write(log+"\n");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public  void close() {
        try {
            fileWriter.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
