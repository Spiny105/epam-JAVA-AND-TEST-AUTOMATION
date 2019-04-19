import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextAnalyzer {

    private static final String  regex =
            "\\b" +
                    "(byte|short|int|long" +
            "|char|float|double|if|else|switch|case|default|boolean|while" +
            "|do|break|continue|for|try|catch|finally|throw|throws" +
            "|private|protected|public|import|package|class|interface" +
            "|extends|implements|static|final|void|abstract|native" +
            "|new|return|this|super|synchronized|volatile|const|goto" +
            "|instanceof|enum|assert|transient|strictfp)" +
                    "\\b";

    public static void analyzeAfterBinaryRead(String sourceFile, String destFile) throws IOException {

        StringBuilder builder = new StringBuilder();
        try(FileInputStream reader = new FileInputStream(sourceFile)) {
            int readedByte;
            while ((readedByte = reader.read()) != -1){
                builder.append((char) readedByte);
            }
        }
        catch (IOException ex) {
            throw new IOException("Can't read file " + sourceFile);
        }

        Map<String, Integer> foundWords = wordsSearching(builder.toString());
        builder = new StringBuilder();

        for (String key:
             foundWords.keySet()) {
            builder.append(key + "\t\t\tfound\t" + foundWords.get(key) + "\n");
        }

        try (FileOutputStream writer = new FileOutputStream(destFile,false)){
            writer.write(builder.toString().getBytes());
        }
        catch (IOException ex) {
            throw new IOException("Can't write in file " + destFile);
        }

    }

    public static void analyzeAfterStringsRead(String sourceFile, String destFile) throws IOException {

        StringBuilder builder = new StringBuilder();

        try (BufferedReader  reader = new BufferedReader(new FileReader(sourceFile))) {
                String readedString = "";
                while ((readedString = reader.readLine()) != null) {
                    builder.append(readedString + " ");
                }
            }
        catch (IOException ex) {
            throw new IOException("Can't read file " + sourceFile);
        }

        Map<String, Integer> foundWords = wordsSearching(builder.toString());
        builder = new StringBuilder();

        for (String key:
                foundWords.keySet()) {
            builder.append(key + "\t\t\tfound\t" + foundWords.get(key) + "\n");
        }

        try(FileWriter writer = new FileWriter(destFile,false)){
            writer.write(builder.toString());
        }
        catch (IOException ex){
            new IOException("Can't write in file " + destFile);
        }
    }

    public static Map<String, Integer> wordsSearching(String text) {
        Map<String, Integer> result = new HashMap<String, Integer>();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        String foundWord = "";

        while (matcher.find()) {

            foundWord = matcher.group();
            if (result.containsKey(foundWord)) {
                result.put(foundWord, result.get(foundWord) + 1);
            }
            else {
                result.put(foundWord, 1);
            }
        }

        return result;
    }
}
