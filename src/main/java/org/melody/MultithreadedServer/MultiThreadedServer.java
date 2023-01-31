package org.melody.MultithreadedServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author lizhaohui
 * @since 2023/1/10
 */
public class MultiThreadedServer implements Runnable {

    protected int serverPort;
    protected ServerSocket serverSocket = null;
    protected boolean isStopped = false;
    protected Thread runningThread = null;

    public MultiThreadedServer(int serverPort) {
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

            new Thread(
                    new WorkerRunnable(clientSocket, "multiThreadsServer")
            ).start();
        }
        System.out.println("Server Stopped.");
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
