package org.melody.Multithreaded;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author lizhaohui
 * @since 2023/1/10
 */
public class WorkerRunnable implements Runnable{

    protected Socket clientSocket = null;
    protected String serverText = null;

    public WorkerRunnable(Socket clientSocket, String serverText) {
        this.clientSocket = clientSocket;
        this.serverText = serverText;
    }

    @Override
    public void run() {
        try {
            InputStream inputStream = clientSocket.getInputStream();
            OutputStream outputStream = clientSocket.getOutputStream();
            long time = System.currentTimeMillis();
            outputStream.write(("HTTP/1.1 200 OK\n\nWorkerRunnable: " +
                    this.serverText + " - " +
                    time +
                    "").getBytes());
            outputStream.close();
            inputStream.close();
            System.out.println("Request processed: " + time);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
