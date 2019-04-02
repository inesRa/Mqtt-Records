package Mqtt;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import java.io.IOException;
import java.util.List;


public class mqttPublisher3 {

    public static void main(String[] args) throws IOException {

        String topic        = "/auto/dev";
        int qos             = 2;
        String broker       = "tcp://localhost:1883";
        String clientId     = "3";
        MemoryPersistence persistence = new MemoryPersistence();
        List<List<Double>> route = Coordonées.getCoordonnée("C:\\Users\\ines\\Desktop\\Coords\\route3.json");


        int vitesse =50;
        String message2;
        try {
            MqttClient sampleClient = new MqttClient(broker, clientId, persistence);
            System.out.println("loool");
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setCleanSession(true);
            System.out.println("Connecting to broker: "+broker);
            sampleClient.connect(connOpts);
            System.out.println("Connected");
            System.out.println("Publishing message");
            MqttMessage message = new MqttMessage();
            message.setQos(qos);
            int i =0;
            while(i<route.size()){
                double lon =route.get(i).get(0);
                double lat =route.get(i).get(1);

                message2="{\n" +
                        "      \"device_id\": \"car3\",\n" +
                        "      \"at_time\": \"timestamp\",\n" +
                        "      \"mil_status\": 999,\n" +
                        "      \"fuel_system_status\": 999,\n" +
                        "      \"engine_load\": 999,\n" +
                        "      \"engine_coolant_temperature\": 999,\n" +
                        "      \"short_term_fuel_trim_bank_1\": 999,\n" +
                        "      \"long_term_fuel_trim_bank_1\": 999,\n" +
                        "      \"intake_manifold_pressure\": 999,\n" +
                        "      \"engine_rpm\": 999,\n" +
                        "      \"vehicle_speed\": \""+vitesse+"\",\n" +
                        "      \"timing_advance\": 999,\n" +
                        "      \"intake_air_temperature\": 999,\n" +
                        "      \"maf_air_flow_rate\": 999,\n" +
                        "      \"throttle\": 9999,\n" +
                        "      \"o2_v_6\": 9999,\n" +
                        "      \"o2_t_6\": 9999,\n" +
                        "      \"distance_traveled_with_mil_on\": 999,\n" +
                        "      \"commanded_evaporative_purge\": 999,\n" +
                        "      \"fuel_tank_level_input\": 999,\n" +
                        "      \"warm_ups_since_codes_cleared\": 999,\n" +
                        "      \"distance_traveled_since_codes_cleared\": 999,\n" +
                        "      \"evaporator_system_pressure\": 9999,\n" +
                        "      \"absolute_barometric_pressure\": 999,\n" +
                        "      \"o2_f_a_e_r_c_1_fuel\": 999,\n" +
                        "      \"catalyst_temperature_bank1_sensor1\": 999,\n" +
                        "      \"control_module_voltage\": 9999,\n" +
                        "      \"absolute_load_value\": 9999,\n" +
                        "      \"fuel_air_commanded_equiv_ratio\": 9999,\n" +
                        "      \"relative_throttle_position\": 9999,\n" +
                        "      \"ambient_air_temperature\": 9999,\n" +
                        "      \"absolute_throttle_b\": 9999,\n" +
                        "      \"accelerator_pedal_position_d\": 999,\n" +
                        "      \"accelerator_pedal_position_e\": 9999,\n" +
                        "      \"fuel_type\": 9999,\n" +
                        "      \"fuel_rail_absolute_pressure\": 9999,\n" +
                        "      \"lat\": \""+lat+"\",\n" +
                        "      \"long\": \""+lon+"\"\n" +
                        "    }";
                message.setPayload(message2.getBytes());
                sampleClient.publish(topic, message);
                System.out.println("Message published"+lat+ " & "+ lon);

                vitesse++;
                Thread.sleep(1000);

                i++;
            }


        } catch(MqttException me) {
            System.out.println("reason "+me.getReasonCode());
            System.out.println("msg "+me.getMessage());
            System.out.println("loc "+me.getLocalizedMessage());
            System.out.println("cause "+me.getCause());
            System.out.println("excep "+me);
            me.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}