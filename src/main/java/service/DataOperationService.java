package service;

import factory.FileTypeFactory;
import model.User;
import util.Helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataOperationService {

    private static final List<String> fileFormats = new ArrayList<>(Arrays.asList("csv", "xml",
            "json"));
    private FileTypeFactory readerWriterFactory;
    private DataFormatContext dataFormatContext;


    public DataOperationService(FileTypeFactory readerWriterFactory) {
        this.readerWriterFactory = readerWriterFactory;
    }


    public List<User> readAllAvailableData() {
        List<User> userData = new ArrayList<>();
        for (String format : fileFormats) {
            dataFormatContext = new DataFormatContext(readerWriterFactory.getFormatType(format));
            userData.addAll(dataFormatContext.executeRead());
        }
        return userData;
    }


    public void writeDataInAllFormat(List<User> users) {
        for (String format : fileFormats) {
            if (readerWriterFactory.getFormatType(format) != null) {
                dataFormatContext = new DataFormatContext(readerWriterFactory.getFormatType(format));
                dataFormatContext.executeWrite(users);
            }
        }
    }


    public List<User> sortUserData(List<User> userData) {
        return Helper.sortUsers(userData);
    }

}
