package service.dataReadWrite.formats;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import model.User;
import model.Users;
import service.dataReadWrite.AbstractReadWrite;
import service.dataReadWrite.DataReadWrite;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class XmlDataReaderWriter extends AbstractReadWrite implements DataReadWrite {

    public List<User> readData() {
        List<User> xmlData = null;
        try {
            XmlMapper xmlMapper = new XmlMapper();
            String dataRead = readFile("data/users.xml");
            xmlData = Arrays.asList(xmlMapper.readValue(dataRead, User[].class));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return xmlData;
    }


    public void writeData(List<User> users) {
        try {
            XmlMapper xmlMapper = new XmlMapper();
            Users userWrapper = new Users(users);
            String xml = xmlMapper.writeValueAsString(userWrapper);
            createFile("output/users.xml", xml);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
