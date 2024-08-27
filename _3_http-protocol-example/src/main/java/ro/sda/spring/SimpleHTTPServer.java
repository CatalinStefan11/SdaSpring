package ro.sda.spring;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;

public class SimpleHTTPServer {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(8080);

        System.out.println("Listening for connections on port 8080...");

        while(true) {
            try(Socket socket = serverSocket.accept()){
                LocalDate today = LocalDate.now();
                String httpResponse = "HTTP/1.1 200 OK\r\n\n\n" + today;
                socket.getOutputStream().write(httpResponse.getBytes(StandardCharsets.UTF_8));
            }
        }
    }
}