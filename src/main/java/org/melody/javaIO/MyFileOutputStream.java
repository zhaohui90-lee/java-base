package org.melody.javaIO;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author lizhaohui
 * @since 2023/1/6
 */
public class MyFileOutputStream {

    public static void main(String[] args) {
        String path = System.getProperty("user.dir") + "/src/main/resources/static/test.txt";
        // overwrite
        try (FileOutputStream stream = new FileOutputStream(path)) {
            System.out.println(stream);
            String s = "这是一段写入的文本111";
            stream.write(s.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // appending
        // 注意，FileOutputStream是在try关键字后面的括号中声明的。一旦程序流退出try块，无论是否抛出异常，
        // 括号内声明的所有资源都会自动关闭。换句话说，FileOutputStream的close()会自动被调用。
        try (FileOutputStream stream = new FileOutputStream(path, true)){
            System.out.println(stream);
            String s = "这是续写在文本的内容";
            stream.write(s.getBytes());
            // int 表示转义的ASCII
            stream.write(1231111);

            byte[] bytes =  new byte[]{1,2,3,4,5};
            stream.write(bytes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
