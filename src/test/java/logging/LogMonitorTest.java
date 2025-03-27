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
        assertEquals("11:35:23,scheduled task 032, START,37980\n11:35:56,scheduled task 032, END,37980\n", LogMonitor.logParser(successfulTask));
    }

    @Test
    public void warningTaskCase() throws IOException {
        assertEquals("11:36:11,scheduled task 796, START,57672\n11:42:18,scheduled task 796, END,57672\n", LogMonitor.logParser(warningTask));
    }

    @Test
    public void errorTaskCase() throws IOException {
        assertEquals("11:47:04,background job djw, START,36709\n11:57:54,background job djw, END,36709\n", LogMonitor.logParser(errorTask));
    }

}