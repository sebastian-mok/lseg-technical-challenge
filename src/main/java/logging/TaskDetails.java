package logging;

import java.time.LocalTime;

public class TaskDetails {

    private String taskName;
    private LocalTime startTime;
    private LocalTime endTime;
    private long durationInSeconds;

    public String getTaskName() {
        return taskName;
    }
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public LocalTime getStartTime() {
        return startTime;
    }
    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }
    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public long getDurationInSeconds() {
        return durationInSeconds;
    }
    public void setDurationInSeconds(long durationInSeconds) {
        this.durationInSeconds = durationInSeconds;
    }

}
