package service.dataReadWrite;

import model.User;

import java.util.List;

public interface DataReadWrite {

    List<User> readData();
    void writeData(List<User> users);

}
