package utilities;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class JSONReader {
    JSONParser parser = new JSONParser();
    public String readJson(String fileName,String key) throws IOException, ParseException {
        Object obj = parser.parse(new FileReader("src/test/resourses/TestData/"+fileName));
        JSONObject jsonObject =  (JSONObject) obj;
        return ((String) jsonObject.get(key));
    }
}



