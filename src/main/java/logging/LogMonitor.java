package logging;

import java.io.*;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class LogMonitor {

    public static void main(String[] args) throws IOException {
        try {
            File file = new File("src/main/resources/logs.log");
            System.out.println(logParser(file));
        } catch (IOException e) {
            throw new FileNotFoundException();
        }

    }


    public static String logParser(File file) throws IOException {

        Scanner scanner = new Scanner(file);
        StringBuilder sb = new StringBuilder();

//        this will store the data for all tasks, using the ID as the key value
        HashMap<Integer, TaskDetails> allTasks = new HashMap<Integer, TaskDetails>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] taskDetailsArray = line.split(",");

//           gets the four pieces of data from the current line in the log
            LocalTime currentTime = LocalTime.parse(taskDetailsArray[0]);
            String currentTaskName = taskDetailsArray[1];
            String startOrEnd = taskDetailsArray[2].trim(); // removing the leading space from the string
            int currentTaskID = Integer.parseInt(taskDetailsArray[3]);

            System.out.println(startOrEnd);


//            sb.append(line).append("\n");
        }
        scanner.close();
        return sb.toString();
    }
}