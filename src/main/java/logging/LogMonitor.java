package logging;

import java.io.*;
import java.time.Duration;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Scanner;

public class LogMonitor {

    public static void main(String[] args) throws IOException {
        try {
            File file = new File("src/main/resources/logs.log");

            String output = logParser(file);
            System.out.println(output);

            File outputFile = new File("output.log");
            if (!outputFile.exists()) {
                outputFile.createNewFile();
            }

            FileWriter fw = new FileWriter(outputFile.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(output);
            bw.close();

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

//            if we are getting the start time, create a new TaskDetails object and add it to the hash map allTasks
            if (startOrEnd.equals("START")) {
                TaskDetails tdToAdd = new TaskDetails();
                tdToAdd.setStartTime(currentTime);
                tdToAdd.setTaskName(currentTaskName);

                allTasks.put(currentTaskID, tdToAdd);

//            if we are getting the end time instead
            } else {
//                get the task details stored in the hash map and add in the end time and duration for the task
                TaskDetails tdToGet = allTasks.get(currentTaskID);
                tdToGet.setEndTime(currentTime);

                long duration = Duration.between(tdToGet.getStartTime(), currentTime).getSeconds();
                tdToGet.setDurationInSeconds(duration);

//                updates the value in the hash map
                allTasks.replace(currentTaskID, tdToGet);

//                prints an error if longer than 10 minutes (600 seconds)
                if (duration > 600) {
                    String msg = "ERROR: Duration of task with ID " + currentTaskID + " has exceeded 10 minutes.\n";
                    sb.append(msg);
//                 prints a warning if longer than 5 minutes (300 seconds)
                } else if (duration > 300) {
                    String msg = "WARNING: Duration of task with ID " + currentTaskID + " has exceeded 5 minutes.\n";
                    sb.append(msg);
                }
            }

        }
        scanner.close();
        return sb.toString();
    }
}