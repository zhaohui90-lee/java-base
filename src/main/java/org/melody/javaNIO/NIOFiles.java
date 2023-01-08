package org.melody.javaNIO;

import java.io.IOException;
import java.nio.file.*;

/**
 * @author lizhaohui
 * @since 2023/1/8
 */
public class NIOFiles {

    /**
     * Java NIO (New IO) is an alternative IO API for Java,
     * meaning alternative to the standard Java IO and Java Networking API's.
     * Java NIO offers a different IO programming model than the traditional IO APIs.
     * Note: Sometimes NIO is claimed to mean Non-blocking IO. However, this is not
     * what NIO meant originally. Also, parts of the NIO APIs are actually blocking - e.g.
     * the file APIs - so the label "Non-blocking" would be slightly misleading.
     */
    public static void main(String[] args) {
//        Files.exists()
        String p = System.getProperty("user.dir") + "/src/main/resources/static/test.txt";
        Path path = Paths.get(p);
        System.out.println(path);
        boolean exists = Files.exists(path, LinkOption.NOFOLLOW_LINKS);
        System.out.println(exists);

    }

    public static void createDir() {
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
