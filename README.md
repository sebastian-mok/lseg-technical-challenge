
# Log Monitoring Application - LSEG Coding Challenge

## About

This coding challenge aims to do the following:

1. Parse a log file containing details about tasks.
2. Identify each task and its start and end times.
3. Calculate the duration of each task.
4. Output a file that logs a warning if a task takes longer than five minutes, or an error if it takes longer than ten minutes.

## Getting Started

Clone the repo at: `https://github.com/sebastian-mok/lseg-technical-challenge.git`.  
Open the project in IntelliJ to run.

## Classes

### TaskDetails

This class is used to store data about each individual task, including its name, start time, end time, and its total duration.

### LogMonitor

This is the class that contains the main method. It takes the log file as an input and calls the `logParser` method. This method uses a `Scanner` to parse the whole file, splitting up each line into separate data values. If the line contains the start time for a task, it will store the `TaskDetails` data in a hash map, using the PID (variable name `currentTaskID`) as the unique key. If the line contains the end time for a task, it will retrieve the data from the hash map, and subsequently calculate the duration of the task. It will update the `TaskDetails` in the hash map, then add a warning or error to the output if it meets either of the duration conditions.

## Testing

I made three tests for this in order to cover the three different cases for a task: five minutes and under (successful), between five and ten minutes (warning), and over ten minutes (error). I used mock data for these in order to simplify the input data. All three tests are successful in meeting the expected output.

If I had more time, I would have added further tests to cover more situations, such as invalid data values. For example, this could be if the end time of a task occurred before its start time, or if a task somehow had an end time but no start time.

## Outcome

My code successfully runs and meets the requirements set. It produces a log file `output.log` that contains all warning and error messages as required.
