package test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.logging.Logger;

public class CSVHandler {
    Path FilePath;

    private LinkedList<String> Content = new LinkedList<>();

    public CSVHandler(String pathToFile) {
        this.FilePath = Paths.get(pathToFile);
    }

    public Path getFilePath() {
        return this.FilePath;
    }

    public void setFilePath(Path FilePath) {
        this.FilePath = FilePath;
    }

    public LinkedList<String> getContent() {
        return this.Content;
    }

    public void setContent(LinkedList<String> Content) {
        this.Content = Content;
    }

    public void Load(int skipTopLine) throws Exception {
        if (Files.notExists(FilePath)) {
            throw new FileNotFoundException(FilePath.toString());
        } else if (!Files.isReadable(FilePath)) {
            throw new IOException("File '" + FilePath.toString() + "' is not Readable");
        } else {
            Logger logger = Logger.getAnonymousLogger();

            FileReader in = new FileReader(FilePath.toFile());
            try (BufferedReader reader = new BufferedReader(in)) {

                String line = "";

                while ((line = reader.readLine()) != null) {
                    if (skipTopLine > 0) {
                        skipTopLine--;
                    } else {
                        Content.add(line);
                    }
                }
            } catch (Exception e) {
                logger.severe(e.toString());
            }

        }
    }

}
