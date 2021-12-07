import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URI;

public class HttpSocketServer {

    public static void main(String args[] ) throws IOException {
        // create server socket
        int port = 8081;
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("✨️Listening to port " + port +"...");

        // awaiting client connection
         while(true) {
             Socket clientSocket = serverSocket.accept();
             System.out.println("[ New client connected ]");

             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             BufferedWriter out = new BufferedWriter(
                     new OutputStreamWriter(
                             new BufferedOutputStream(clientSocket.getOutputStream()), "UTF-8")
             );

             String s;
             while ((s = in.readLine()) != null) {
                 System.out.println(s);
                 if (s.isEmpty()) {
                     break;
                 }
             }

             String httpResponse = "HTTP/1.1 200 OK\r\n\r\n" + "Welcome";
             out.write(httpResponse);

             // closing the connection
             System.err.println("[ -- Client disconnected -- ]");
             out.close();
             in.close();
             clientSocket.close();
         }
    }
}
