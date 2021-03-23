import Entidad.Payaso;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
public class Receiver {

    private final static String QUEUE_NAME = "entidad";

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
           byte[] byteArray= delivery.getBody();
          try{
              Payaso payaso=(Payaso) deserialize(byteArray);
              System.out.println("[x] Recibí: "+payaso+ " ' ");
          }catch(ClassNotFoundException cn){
              cn.printStackTrace();
          }
        };
        channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> { });
    }
    public static Object deserialize(byte[] byteArray) throws IOException, ClassNotFoundException{
        ByteArrayInputStream in=new ByteArrayInputStream(byteArray);
        ObjectInputStream is=new ObjectInputStream(in);
        return is.readObject();
    }
}