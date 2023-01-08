package org.melody.javaNIO;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author lizhaohui
 * @since 2023/1/8
 */
class NIOFilesTest {

    @Test
    void createDir() {
        String p = System.getProperty("user.dir") + "/src/main/resources/static/test1.txt";
        Path path = Paths.get(p);
        try {
            Path newDir = Files.createDirectory(path);
            System.out.println("newDir" + newDir);
        } catch (FileAlreadyExistsException e) {
            System.out.println(e.getFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}