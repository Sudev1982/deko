package service.dataReadWrite.formats;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.User;
import service.dataReadWrite.AbstractReadWrite;
import service.dataReadWrite.DataReadWrite;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class JsonDataReaderWriter extends AbstractReadWrite implements DataReadWrite {

    public List<User> readData() {
        List<User> jsonData = null;

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String dataRead = readFile("data/users.json");
            jsonData = Arrays.asList(objectMapper.readValue(dataRead, User[].class));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonData;
    }


    public void writeData(List<User> users) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            //objectMapper.setTimeZone(TimeZone.getDefault());
            //objectMapper.setDateFormat(new StdDateFormat().withColonInTimeZone(true));
            String json = objectMapper.writeValueAsString(users);
            createFile("output/users.json", json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
