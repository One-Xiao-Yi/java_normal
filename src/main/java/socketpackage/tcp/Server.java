/**
 * FileName: Server
 * Author: xiaoyi
 * Description:    服务器端
 * Date:   2019/12/1418:04
 */

package socketpackage.tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Server {

    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket = new ServerSocket(6666);
        System.out.println("server is running...");
        while (true)
        {
            /**
             * 通过无限循环，接受客户端的连接
             * 通过accept接受客户端的socket，创建新线程来处理客户端请求
             */
            Socket socket = serverSocket.accept();
            System.out.println("connected from " + socket.getRemoteSocketAddress());
            Thread thread = new Handler(socket);
            thread.start();
        }
    }

}

class Handler extends Thread
{
    Socket socket;

    Handler(Socket socket)
    {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (InputStream inputStream = socket.getInputStream()){
            try (OutputStream outputStream = socket.getOutputStream()){
                handle(inputStream, outputStream);
            }
        }catch (Exception e)
        {
            try {
                this.socket.close();
            } catch (IOException ioe) {
            }
            System.out.println("client disconnected.");
        }
    }

    private void handle(InputStream input, OutputStream output) throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output, StandardCharsets.UTF_8));
        BufferedReader reader = new BufferedReader(new InputStreamReader(input, StandardCharsets.UTF_8));
        writer.write("hello\n");
        writer.flush();
        for (;;) {
            String s = reader.readLine();
            if (s.equals("bye")) {
                writer.write("bye\n");
                writer.flush();
                break;
            }
            writer.write("ok: " + s + "\n");
            writer.flush();
        }
    }
}
