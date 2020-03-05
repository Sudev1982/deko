package service;

import model.User;
import service.dataReadWrite.DataReadWrite;

import java.util.List;

public class DataFormatContext {
    private DataReadWrite dataReadWrite;

    public DataFormatContext(DataReadWrite dataReadWrite) {
        this.dataReadWrite = dataReadWrite;
    }

    public List<User> executeRead() {
        return dataReadWrite.readData();
    }

    public void executeWrite(List<User> users) {
        dataReadWrite.writeData(users);
    }
}
