package service.dataReadWrite.formats;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import model.User;
import service.dataReadWrite.AbstractReadWrite;
import service.dataReadWrite.DataReadWrite;

import java.io.IOException;
import java.util.List;

public class CsvDataReaderWriter extends AbstractReadWrite implements DataReadWrite {

    public List<User> readData() {
        List<User> csvData = null;
        try {
            CsvMapper csvMapper = new CsvMapper();
            String dataRead = readFile("data/users.csv");
            MappingIterator<User> data = csvMapper.readerFor(User.class).with(CsvSchema.emptySchema().withHeader()).readValues(dataRead);
            csvData = data.readAll();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return csvData;
    }


    public void writeData(List<User> users) {
        try {
            CsvMapper csvMapper = new CsvMapper();
            CsvSchema schema = csvMapper.schemaFor(User.class).withHeader();
            String csv = csvMapper.writer(schema).writeValueAsString(users);
            createFile("output/users.csv", csv);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
