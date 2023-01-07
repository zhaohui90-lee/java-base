package org.melody.javaIO;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * Java IO中的管道为在同一个JVM中运行的两个线程提供了通信的能力。因此，管道也可以是数据的来源或目的地。
 *
 * 不能使用管道与不同JVM(不同进程)中的线程通信。Java中的管道概念与Unix / Linux中的管道概念不同，在Unix / Linux中，运行在不同地址空间中的两个
 * 进程可以通过管道进行通信。在Java中，通信双方必须运行在同一个进程中，而且应该是不同的线程。
 * @author lizhaohui
 * @since 2023/1/7
 */
public class MyPipes {

    public static void main(String[] args) throws IOException {
        PipedOutputStream output = new PipedOutputStream();
        PipedInputStream inputStream = new PipedInputStream(output);

        Thread thread1 = new Thread(() -> {
            try {
                output.write("hello pipes!".getBytes());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    int read = inputStream.read();
                    while (read != -1) {
                        System.out.println(read);
                        read = inputStream.read();
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}
