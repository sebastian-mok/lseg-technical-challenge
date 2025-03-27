package logging;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class LogMonitorTest {


    private final File successfulTask = new File("src/test/resources/successfultask.log");;
    private final File warningTask = new File("src/test/resources/warningtask.log");;
    private final File errorTask = new File("src/test/resources/errortask.log");


    @Test
    public void successfulTaskCase() throws IOException {
        assertEquals("", LogMonitor.logParser(successfulTask));
    }

    @Test
    public void warningTaskCase() throws IOException {
        assertEquals("WARNING: Duration of task with ID 57672 has exceeded 5 minutes.\n", LogMonitor.logParser(warningTask));
    }

    @Test
    public void errorTaskCase() throws IOException {
        assertEquals("ERROR: Duration of task with ID 36709 has exceeded 10 minutes.\n", LogMonitor.logParser(errorTask));
    }

}