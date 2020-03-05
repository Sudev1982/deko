package service.dataReadWrite;

import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public abstract class AbstractReadWrite {

    public String readFile(String filePath) {
        String readData = "";
        if (!StringUtils.isEmpty(filePath)) {
            try {
                byte[] content = Files.readAllBytes(Paths.get(filePath));
                readData = new String(content);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return readData;
    }

    public void createFile(String fileName, String data) {
        try {
            if (!StringUtils.isEmpty(fileName) && !StringUtils.isEmpty(data)) {
                File output = new File(fileName);
                FileWriter fileWriter = new FileWriter(output);
                fileWriter.write(data);
                fileWriter.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
