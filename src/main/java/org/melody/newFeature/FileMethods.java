package org.melody.newFeature;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @author lizhaohui
 * @since 2023/12/28
 */
public class FileMethods {

    public static void main(String[] args) throws IOException {

        String tempPath = "";

        Path path = Files.writeString(Files.createTempFile(Path.of(tempPath), "demo", ".txt"),
                "This was posted on JD");

        String readString = Files.readString(path);

        assert readString.equals("This was posted on JD");


    }
}
