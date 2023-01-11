package org.melody.MultithreadedServer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @author lizhaohui
 * @since 2023/1/10
 */
public class SingleThreadedServer implements Runnable{

    protected int serverPort;
    protected ServerSocket serverSocket = null;
    protected boolean isStopped = false;
    protected Thread runningThread = null;

    public SingleThreadedServer(int serverPort) {
        this.serverPort = serverPort;
    }

    @Override
    public void run() {
        synchronized (this) {
            this.runningThread = Thread.currentThread();
            System.out.println("------>new thread");
        }
        openServerSocket();

        while (!isStopped()) {
            System.out.println("----->new socket");
            Socket clientSocket;
            try {
                clientSocket = this.serverSocket.accept();
            } catch (IOException e) {
                if (isStopped()) {
                    System.out.println("server stopped!");
                    return;
                }
                throw new RuntimeException(
                        "Error accepting client connection", e
                );
            }
            try {
                processClientRequest(clientSocket);
            } catch (Exception e) {
                // log
            }
        }
        System.out.println("Server Stopped.");
    }

    private void processClientRequest(Socket clientSocket) throws IOException {
        InputStream inputStream = clientSocket.getInputStream();
        OutputStream outputStream = clientSocket.getOutputStream();
        long time = System.currentTimeMillis();

        byte[] responseDocument = ("<html><body> Singlethreaded Server: "
                + time + "</body></html>").getBytes(StandardCharsets.UTF_8);

        byte[] responseHeader =
                ("HTTP/1.1 200 OK\r\n" +
                        "Content-Type: text/html; charset=UTF-8\r\n" +
                        "Content-Length: " + responseDocument.length +
                        "\r\n\r\n").getBytes(StandardCharsets.UTF_8);

        outputStream.write(responseHeader);
        outputStream.write(responseDocument);
        outputStream.close();
        inputStream.close();
        System.out.println("Request processed: " + time);
    }

    private synchronized boolean isStopped() {
        return this.isStopped;
    }

    public synchronized void stop() {
        this.isStopped = true;
        try {
            this.serverSocket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private void openServerSocket() {
        try {
            this.serverSocket = new ServerSocket(this.serverPort);
        } catch (IOException e) {
            throw new RuntimeException("Cannot open port 8080", e);
        }
    }
}
