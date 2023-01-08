package org.melody.javaIO;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author lizhaohui
 * @since 2023/1/8
 */
public class SystemInAndOut {

    public static void main(String[] args) {
        String path = System.getProperty("user.dir") + "/src/main/resources/static/test1.txt";
        // 使用Files.newInputStream(Paths.get(path))比直接使用FileInputStream效率更高
        try (InputStream input = new BufferedInputStream(Files.newInputStream(Paths.get(path)))){
            System.out.println("file opened...");
        } catch (IOException e) {
            System.err.println("file opening failed...");
            e.printStackTrace();
        }
    }
}
