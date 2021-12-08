public class HttpResponse {
    private static String OK =  "HTTP/1.1 200 OK\r\n\r\n",
            NOT_FOUND = "HTTP/1.1 404 Not Found\r\n\r\n";

    public static String ok() {
        String content = "<h1>Welcome to my Java server! :)</h1>\n";
        return OK + getHtmlBody(content);
    }

    public static String notFound() {
        String content = "<h1>404 - Not Found</h1>";
        return NOT_FOUND + getHtmlBody(content);
    }

    public static String getHtmlBody(String content) {
        return "<html>\n" +
                "<head><title>HttpSocketServer</title></head>\n" +
                "<body>\n" +
                content +
                "</body>\n" +
                "</html>";
    }
}
