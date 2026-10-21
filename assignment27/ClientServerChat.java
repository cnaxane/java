/**
 * Assignment 27 - Exercise 1
 * Problem Statement: Create a simple client-server chat application using sockets.
 */

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ClientServerChat {
    private static final int PORT = 6000;

    // Server logic
    public static void startServer() {
        System.out.println("[Chat Server] Starting on port " + PORT + "...");
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("[Chat Server] Waiting for a client to connect...");
            Socket clientSocket = serverSocket.accept();
            System.out.println("[Chat Server] Client connected from " + clientSocket.getRemoteSocketAddress());

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            // Thread to listen for messages from client
            Thread receiveThread = new Thread(() -> {
                try {
                    String clientMsg;
                    while ((clientMsg = in.readLine()) != null) {
                        System.out.println("\n[Client]: " + clientMsg);
                        if ("bye".equalsIgnoreCase(clientMsg.trim())) {
                            System.out.println("[Chat Server] Client initiated disconnect.");
                            break;
                        }
                    }
                } catch (IOException e) {
                    System.out.println("[Chat Server] Connection closed.");
                }
            });
            receiveThread.start();

            // Thread or automated demo responses
            String[] serverResponses = {
                "Hello Client! Welcome to the Java Socket Chat.",
                "I received your message loud and clear.",
                "Good chatting with you! Goodbye."
            };

            for (String resp : serverResponses) {
                Thread.sleep(1200);
                System.out.println("[Chat Server Sending]: " + resp);
                out.println(resp);
            }

            receiveThread.join(3000);
            clientSocket.close();
            System.out.println("[Chat Server] Closed.");
        } catch (Exception e) {
            System.out.println("[Chat Server Error]: " + e.getMessage());
        }
    }

    // Client logic
    public static void startClient() {
        try {
            Thread.sleep(500); // ensure server starts first
            System.out.println("[Chat Client] Connecting to localhost:" + PORT + "...");
            Socket socket = new Socket("localhost", PORT);
            System.out.println("[Chat Client] Successfully connected to server!");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Thread to read messages from server
            Thread receiveThread = new Thread(() -> {
                try {
                    String serverMsg;
                    while ((serverMsg = in.readLine()) != null) {
                        System.out.println("[Server]: " + serverMsg);
                    }
                } catch (IOException e) {
                    System.out.println("[Chat Client] Connection closed by server.");
                }
            });
            receiveThread.start();

            // Send demo messages
            String[] clientMessages = {
                "Hi Server, this is the Client testing the socket chat!",
                "Can you confirm receipt?",
                "bye"
            };

            for (String msg : clientMessages) {
                Thread.sleep(1000);
                System.out.println("[Chat Client Sending]: " + msg);
                out.println(msg);
            }

            receiveThread.join(3000);
            socket.close();
            System.out.println("[Chat Client] Closed.");
        } catch (Exception e) {
            System.out.println("[Chat Client Error]: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Assignment 27: Client-Server Chat Application using Sockets ===");

        if (args.length > 0 && args[0].equalsIgnoreCase("server")) {
            startServer();
        } else if (args.length > 0 && args[0].equalsIgnoreCase("client")) {
            startClient();
        } else {
            // Default: Run an end-to-end multi-threaded demonstration
            System.out.println("Running automated Client-Server chat demonstration...\n");

            Thread serverThread = new Thread(ClientServerChat::startServer, "Server-Thread");
            Thread clientThread = new Thread(ClientServerChat::startClient, "Client-Thread");

            serverThread.start();
            clientThread.start();

            try {
                serverThread.join();
                clientThread.join();
            } catch (InterruptedException e) {
                System.out.println("Execution interrupted: " + e.getMessage());
            }

            System.out.println("\n=== Chat Session Completed Successfully ===");
        }
    }
}
