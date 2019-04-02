package Mqtt;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Coordonées {
    public static List<List<Double>> getCoordonnée(String file) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Object obj = null;
        Map<String,Object> map = mapper.readValue(new FileReader(file), Map.class);

        List<List<Double>> coords = (List<List<Double>>) map.get("coordinates");
        return coords;
    }
}
