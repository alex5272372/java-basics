package hw13;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Logger {
    private static final String FILE_NAME = "application.log";

    private static void write(String type, String message) {
        Date d = new Date();
        String text = String.format("%tY/%tm/%td %tH:%tM:%tS [%s] %s\n", d, d, d, d, d, d, type, message);

        try {
            FileWriter writer = new FileWriter(FILE_NAME, true);
            BufferedWriter bufferWriter = new BufferedWriter(writer);
            bufferWriter.write(text);
            bufferWriter.close();
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void info(String message) {
        System.out.println(message);
        write("DEBUG", message);
    }

    public static void error(String message) {
        System.out.println("ERROR: " + message);
        write("ERROR", message);
    }
}
