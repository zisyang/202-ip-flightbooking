package test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Logger;

public class FileCreator {

    Path FilePath;
    ArrayList<String> content;

    public FileCreator(String pathToFile, String extension) {
        FilePath = Paths.get(pathToFile.trim());
        OutputFile output = null;
        if (extension.equals("csv")) {
            output = new OutputCSVFactory();
        } else if (extension.equals("txt")) {
            output = new OutputTXTFactory();
        }
        if (output != null) {
            content = output.prepare();
        } else {
            content = new ArrayList<>();
        }
    }

    public void Save(boolean overwriteOK) throws IOException {
        Logger logger = Logger.getAnonymousLogger();

        if (Files.notExists(FilePath)) {
            String msg = "Creating new file " + FilePath.toString();
            logger.info(msg);
            
            if (!FilePath.toFile().createNewFile()) {
                throw new IOException(
                        "File '" + FilePath.toString() + "' cannot be created. Please check permission or system lock");
            }
        } else if (Files.exists(FilePath) && !overwriteOK) {
            throw new FileAlreadyExistsException(FilePath.toString() + " and don't want to overwrite");
        }
        if (!Files.isWritable(FilePath)) {
            throw new IOException("File '" + FilePath.toString() + "' is not Writable");
        } else {
            FileWriter out = new FileWriter(FilePath.toFile());
            try (BufferedWriter writer = new BufferedWriter(out)) {

                for (String line : content) {
                    writer.write(line);
                    writer.newLine();
                }
                
            } catch (Exception e) {
                logger.severe(e.toString());
            }

        }
    }
}
