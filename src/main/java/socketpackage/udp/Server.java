/**
 * FileName: Server
 * Author: xiaoyi
 * Description:    服务器端
 * Date:   2019/12/1418:16
 */

package socketpackage.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.nio.charset.StandardCharsets;

public class Server {

    public static void main(String[] args) throws Exception{
        DatagramSocket datagramSocket = new DatagramSocket(6666);
        while (true)
        {
            byte[] buffer = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            /**
             * 收取一个UDP数据包
              */
            datagramSocket.receive(packet);
            /**
             *  收取到的数据存储在buffer中，由packet.getOffset(), packet.getLength()指定起始位置和长度
             *              将其按UTF-8编码转换为String:
             */
            String s = new String(packet.getData(), packet.getOffset(), packet.getLength(), StandardCharsets.UTF_8);
            System.out.println(s);
            byte[] data = "ACK".getBytes(StandardCharsets.UTF_8);
            packet.setData(data);
            datagramSocket.send(packet);
        }
    }

}
