import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class TextAnalyzerTest {

    @Test
    public void wordsSearchingIfElseTest() {

        int expectedNumberOfWords = 2;
        String text = "if{\n//some operators\n}\nelse{\nanother operators\n}";

        Map<String, Integer> foundWords = TextAnalyzer.wordsSearching(text);

        assertEquals("Wrong number of key words", expectedNumberOfWords, foundWords.size());
    }

    @Test
    public void wordsSearchingKeyWordInTheMiddleOfAnotherWordTest() {

        int expectedNumberOfWords = 0;
        String text = "someClassSome keyWordForInAnotherWord";

        Map<String, Integer> foundWords = TextAnalyzer.wordsSearching(text);

        assertEquals("Wrong number of key words", expectedNumberOfWords, foundWords.size());
    }

    @Test
    public void wordsSearchingSemicolonTest() {

        int expectedNumberOfWords = 3;
        String text = ";implements; ;keyWordForInAnotherWord; ;;;;;;; \n;;;; public long";

        Map<String, Integer> foundWords = TextAnalyzer.wordsSearching(text);

        assertEquals("Wrong number of key words", expectedNumberOfWords, foundWords.size());
        assertTrue("Wrong word contains in collection", foundWords.containsKey("implements"));
        assertTrue("Wrong word contains in collection", foundWords.containsKey("public"));
        assertTrue("Wrong word contains in collection", foundWords.containsKey("long"));
    }

    @Test
    public void wordsSearchingAllWordsTest() {

        int expectedNumberOfWords = 50;
        String text = "byte short int long " +
        "char float double if else switch case default boolean while " +
        "do break continue for try catch finally throw throws " +
        "private protected public import package class interface " +
                "extends implements static final void abstract native " +
        "new return this super synchronized volatile const goto " +
             "instanceof enum assert transient strictfp ";

        Map<String, Integer> foundWords = TextAnalyzer.wordsSearching(text);

        assertEquals("Wrong number of key words", expectedNumberOfWords, foundWords.size());
    }
}