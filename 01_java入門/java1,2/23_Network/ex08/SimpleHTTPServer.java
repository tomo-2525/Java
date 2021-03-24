import java.io.*;
import java.net.*;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.io.File;

public class SimpleHTTPServer {

  private final int port;

  public SimpleHTTPServer(int port) {
    this.port = port;
  }

  public void start() {
    // TODO
    // Start a ServerSocker
    // wait for connection
    // then send the corresponding socket to an instance of Handler
    // and let it handle the request

    Socket socket = null;// finallyで閉じるためにtry外で宣言
    ServerSocket serverSock = null;
    try {
      serverSock = new ServerSocket(this.port);

      while (true) {
        socket = serverSock.accept();
        Handler handle = new Handler(socket);
        handle.start();
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {

        if (socket != null) {
          socket.close();
        }

      } catch (IOException e) {
      }

    }
  }

  private class Handler {
    private final Socket connection;

    Handler(Socket connection) {
      this.connection = connection;
    }

    public void start() throws IOException {
      // Get InputStream and OutputStream from the socket.
      //
      // 1. read the request from the client.
      // 2. if it is not starting by "GET" then ignore
      // 3. otherwise, extract the file name from the request.
      // It will look like: "GET /filename.html HTTP/1.1"
      // You can split the string by whitespaces.
      // 4. open the file and reads its content
      // 5. create an HTTP header
      // 6. send the header then the content via the OutputStream

      try {
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        DataOutputStream out = new DataOutputStream(connection.getOutputStream());
        String line;

        if ((line = in.readLine()) != null) {
          System.out.println(line);
          String[] req = line.split(" ");
          String reqMethod = req[0];

          if (reqMethod.equals("GET")) {

            String fileName = req[1];
            fileName = fileName.replaceAll("^/", "");
            File file = new File(fileName);
            // System.out.println(fileName);
            byte[] content;
            if (file.exists()) {

              content = Files.readAllBytes(file.toPath());
            } else {
              File file404 = new File("404.html");
              content = Files.readAllBytes(file404.toPath());
            }
            String headerStr = "HTTP/1.0 200 OK\r\n" + "Server: SimpleHTTPServer\r\n" + "Content-length: "
                + content.length + "\r\n" + "Content-type: text/html" + "; charset=utf-8" + "\r\n\r\n";
            byte[] header = headerStr.getBytes(Charset.forName("UTF-8"));

            out.write(header, 0, header.length);
            out.write(content, 0, content.length);
            out.flush();
          }
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
      return;
    }
  }

  public static void main(String[] args) {
    int port;
    try {
      port = Integer.parseInt(args[0]);
      if (port < 1024 || port > 65535)
        port = 8080;
    } catch (RuntimeException ex) {
      port = 8080;
    }

    try {
      SimpleHTTPServer server = new SimpleHTTPServer(port);
      server.start();

    } catch (ArrayIndexOutOfBoundsException ex) {
      System.out.println("Usage: java SimpleHTTPServer [port]");
    }
  }

}