import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import java.io.UnsupportedEncodingException;

import static com.sun.xml.internal.ws.commons.xmlutil.Converter.UTF_8;

public class mqttSub {

    public static void main(String[] args) {

        MqttClient client = null; //Persistence
        try {
            client = new MqttClient(
                    "tcp://localhost:1883", //URI
                    MqttClient.generateClientId(), //ClientId
                    new MemoryPersistence());
        } catch (MqttException e) {
            e.printStackTrace();
        }

        try {
            client.connect();
        } catch (MqttException e) {
            e.printStackTrace();
        }

        try {
            client.publish(
                    "/test/topic", // topic
                    "payload".getBytes(UTF_8), // payload
                    2, // QoS
                    false); // retained?
        } catch (MqttException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }}