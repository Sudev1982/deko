package dataReadWrite.format;

import model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.dataReadWrite.formats.JsonDataReaderWriter;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JsonDataReaderWriterTest {

    private JsonDataReaderWriter jsonDataReaderWriter;
    private List<User> testData;

    @BeforeEach
    public void setUp() {
        jsonDataReaderWriter = new JsonDataReaderWriter();
        testData = new ArrayList<>();
        testData.add(new User(1, "TestOne First", "TestOne Last", "TestOneUser", "Employee", new Date()));
        testData.add(new User(2, "TestTwo First", "TestTwo Last", "TestTwoUser", "Manager", new Date()));

    }

    @AfterEach
    public void cleanUp() {
        File dir = new File("output/");
        for (File file : dir.listFiles()) {
            file.delete();
        }
    }


    @Test
    @DisplayName("readDataFromJsonTesting")
    public void readDataTest() {
        assertNotNull(jsonDataReaderWriter.readData());
    }

    @Test
    @DisplayName("writeDataToJsonTesting")
    public void writeDataTesting() {
        jsonDataReaderWriter.writeData(testData);
        File json = new File("output/users.json");
        assertTrue(json.exists());
    }
}
