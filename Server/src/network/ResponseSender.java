package network;

import tools.Request;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.logging.Logger;

public class ResponseSender {


    public void sendAnswer(Request s, SocketChannel channel) throws IOException {

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(s);
        oos.flush();
        byte[] data = bos.toByteArray();
        ByteBuffer buffer = ByteBuffer.wrap(data);
        channel.write(buffer);
//        Request request =new Request(s);
//        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
//        ObjectOutputStream objStream = new ObjectOutputStream(byteStream);
//        ByteBuffer buffer = ByteBuffer.wrap(byteStream.toByteArray());//массив байтов оборачиваем в
//        // буффер (оболочка, позволяющая работать с массивами более удобно)
//        RESPONSE_LOGGER.info("Отправка ответа клиенту");
//        channel.write(buffer);
    }
}
