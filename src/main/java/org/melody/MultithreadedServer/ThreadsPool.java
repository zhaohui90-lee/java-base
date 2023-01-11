package org.melody.MultithreadedServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author lizhaohui
 * @since 2023/1/11
 */
public class ThreadsPool implements Runnable{

    protected int serverPort;
    protected ServerSocket serverSocket = null;
    protected boolean isStopped = false;
    protected Thread runningThread = null;
    protected ExecutorService threadPool = Executors.newFixedThreadPool(10);

    public ThreadsPool(int serverPort) {
        this.serverPort = serverPort;
    }

    @Override
    public void run() {
        synchronized (this) {
            this.runningThread = Thread.currentThread();
        }
        openServerSocket();

        while (!isStopped()) {
            Socket clientSocket;
            try {
                clientSocket = this.serverSocket.accept();
            } catch (IOException e) {
                if (isStopped()) {
                    System.out.println("server stopped");
                    break;
                }
                throw new RuntimeException(
                        "Error accepting client connection", e
                );
            }
            this.threadPool.execute(
                    new WorkerRunnable(clientSocket, "thread pool server")
            );
        }
        this.threadPool.shutdown();
        System.out.println("server stopped");
    }

    public synchronized void stop() {
        this.isStopped = true;
        try {
            this.serverSocket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private synchronized boolean isStopped() {
        return this.isStopped;
    }

    private void openServerSocket() {
        try {
            this.serverSocket = new ServerSocket(this.serverPort);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
