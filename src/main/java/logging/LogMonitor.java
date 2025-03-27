package logging;

import java.io.*;
import java.util.Scanner;

public class LogMonitor {

    public static void main(String[] args) throws IOException {
        System.out.println("Hello, World!");

        try {
            File file = new File("src/main/resources/logs.log");
            System.out.println(logParser(file));
        } catch (IOException e) {
            throw new FileNotFoundException();
        }

    }


    public static String logParser(File file) throws IOException {
        StringBuilder sb = new StringBuilder();

        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            sb.append(line).append("\n");
        }
        scanner.close();
        return sb.toString();
    }
}