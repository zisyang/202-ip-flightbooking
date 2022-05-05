package test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FileCreator {

    Path FilePath;
    ArrayList<String> content;

    public FileCreator(String pathToFile, String extension) {
        FilePath = Paths.get(pathToFile);
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
        if (Files.notExists(FilePath)) {
            System.out.printf("new file '%s' created\n", FilePath);
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
                /*
                 * writer.close()
                 *  closing the resource is handled automatically by the try-with-resources.
                 */
            } catch (Exception e) {
                System.out.println(e);
            }

        }
    }
}
