import java.io.*;
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

             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             BufferedWriter out = new BufferedWriter(
                     new OutputStreamWriter(
                             new BufferedOutputStream(clientSocket.getOutputStream()), "UTF-8")
             );

             String s;
             String path = "";
             boolean pathExists = false;

             // reads input stream
             while ((s = in.readLine()) != null) {
                 System.out.println(s);

                 // analyzing first line of input stream
                 // example: GET /sample HTTP/1.1
                 if (s.contains("GET")) {
                     int indexOfFirstDash = s.indexOf("/") + 1;
                     int indexOfLastSpace = s.lastIndexOf(" ");

                     // gets the path value
                     // in the example above, the value would be "sample"
                     path = s.substring(indexOfFirstDash, indexOfLastSpace);
                 }

                 if (s.isEmpty()) {
                     break;
                 }
             }

             // checks if there is a path
             pathExists = !path.equals("");

             // sets response according to path
             // any other URL other than root should return 404
             String httpResponse;
             if (pathExists) {
                 httpResponse = "HTTP/1.1 404 Not Found\r\n\r\n" + "404 Not Found";
             } else {
                 httpResponse = "HTTP/1.1 200 OK\r\n\r\n" + "Welcome";
             }

             // writes response
             out.write(httpResponse);

             // closes the connection
             System.err.println("[ -- Client disconnected -- ]");
             out.close();
             in.close();
             clientSocket.close();
         }
    }
}
