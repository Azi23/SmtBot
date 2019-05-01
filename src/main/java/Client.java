import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    String message;
    Socket s = new Socket("localhost", 5000);
    InputStream mes=s.getInputStream();
    OutputStream sendMes=s.getOutputStream();

    public Client() throws IOException {

    }
}