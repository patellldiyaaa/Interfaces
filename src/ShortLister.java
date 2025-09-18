import javax.swing.JFileChooser;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import static java.nio.file.StandardOpenOption.CREATE;
import java.util.ArrayList;

public class ShortLister {

    public static void main(String[] args) {

        JFileChooser chooser = new JFileChooser();
        File selectedFile;
        String rec = "";
        ArrayList<String> lines = new ArrayList<>();
        ArrayList<String> shortWords = new ArrayList<>();


        Filter filter = new ShortWordFilter();

        try {
            File workingDirectory = new File(System.getProperty("user.dir"), "Desktop");
            chooser.setCurrentDirectory(workingDirectory);

            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                selectedFile = chooser.getSelectedFile();
                Path file = selectedFile.toPath();

                InputStream in = new BufferedInputStream(Files.newInputStream(file, CREATE));
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));


                int line = 0;
                while (reader.ready()) {
                    rec = reader.readLine();
                    lines.add(rec);
                    line++;
                }
                reader.close();


                for (String ln : lines) {

                    String[] words = ln.split("[^A-Za-z]+");
                    for (String w : words) {
                        if (w.isEmpty()) continue;
                        if (filter.accept(w)) {
                            shortWords.add(w);
                        }
                    }
                }


                System.out.println("Short words (< 5 letters):");
                System.out.println("================================");
                for (String w : shortWords) {
                    System.out.println(w);
                }
                System.out.println("================================");
                System.out.println("Total short words: " + shortWords.size());

            } else {
                System.out.println("Failed to choose a file to process");
                System.out.println("Run the program again!");
                System.exit(0);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!!!");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

