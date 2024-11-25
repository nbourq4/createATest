package delft;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach; 
import org.junit.jupiter.api.Test;

class GenericClassTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void testDoStuff() {
        GenericClass.doStuff();
        // Standardize newlines to "\n" for consistent testing across different platforms
        String actualOutput = outContent.toString().replace(System.lineSeparator(), "\n").trim();
        String expectedOutput = "    \n".trim();
        assertEquals(expectedOutput, actualOutput, "The output should be four spaces followed by a newline");
    }
}
