import java.io.IOException;

import static org.junit.Assert.*;

public class TextAnalyzerTest {

    final String SOURCE_TEST_FILE_PATH = "C:\\Users\\leont\\IdeaProjects\\testcore\\Homework_2\\src\\main\\java\\TestClass.java";
    final String DEST_BINARY_TEST_FILE_PATH = "C:\\Users\\leont\\IdeaProjects\\testcore\\Homework_2\\src\\main\\java\\test_results\\Binary_write_test_result.txt";
    final String DEST_STRING_TEST_FILE_PATH = "C:\\Users\\leont\\IdeaProjects\\testcore\\Homework_2\\src\\main\\java\\test_results\\String_write_test_result.txt";

    @org.junit.Before
    public void setUp() throws Exception {
    }

    @org.junit.After
    public void tearDown() throws Exception {

    }

    @org.junit.Test
    public void analyzeAfterBinaryRead(){
        try {
            TextAnalyzer.analyzeAfterBinaryRead(SOURCE_TEST_FILE_PATH, DEST_BINARY_TEST_FILE_PATH);
        }
        catch (Exception e){}
    }

    @org.junit.Test
    public void analyzeAfterStringsRead() {
        try {
            TextAnalyzer.analyzeAfterStringsRead(SOURCE_TEST_FILE_PATH, DEST_STRING_TEST_FILE_PATH);
        }
        catch (Exception e){}
    }
}