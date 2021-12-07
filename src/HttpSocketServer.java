import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

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
         }
    }
}
