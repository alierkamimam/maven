package Lessons.Week03.Section20.rahulshetty.data;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

public class DataReader {

    public  List<HashMap<String, String>> getJsonDataToMap() throws IOException {

        //read json to string
        String jsonFormat = FileUtils.readFileToString(new File(System.getProperty("user.dir") + "\\src\\test\\java\\Lessons\\Week03\\Section20\\rahulshetty\\data\\PurchaseOrder.json"),
                StandardCharsets.UTF_8);


        //String to Hashmap Jackson DataBind
        ObjectMapper mapper=new ObjectMapper();
        List<HashMap<String,String>> data=mapper.readValue(jsonFormat, new TypeReference<List<HashMap<String, String>>>() {

        });
        return data;



    }
}
