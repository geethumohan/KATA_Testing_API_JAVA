package support;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.json.simple.JSONObject;

import java.io.FileReader;


public class JSONFileParser {
    public static String getJSONFromFile(String path){
        org.json.simple.parser.JSONParser parser = new org.json.simple.parser.JSONParser();
        try {
            Object obj = parser.parse(new FileReader(path));
            JSONObject jsonObject = (JSONObject) obj;
            return jsonObject.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "JSON load failed";
    }

    public static String convertClassDataToJSONString(Object classObj) throws JsonProcessingException {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        return ow.writeValueAsString(classObj);
    }
}
