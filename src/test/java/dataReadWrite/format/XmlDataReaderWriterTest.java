package dataReadWrite.format;

import model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.dataReadWrite.formats.XmlDataReaderWriter;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class XmlDataReaderWriterTest {

    private XmlDataReaderWriter xmlDataReaderWriter;
    private List<User> testData;

    @BeforeEach
    public void setUp() {
        xmlDataReaderWriter = new XmlDataReaderWriter();
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
    @DisplayName("readDataFromXmlTesting")
    public void readDataTest() {
        assertNotNull(xmlDataReaderWriter.readData());
    }

    @Test
    @DisplayName("writeDataToXmlTesting")
    public void writeData() {
        xmlDataReaderWriter.writeData(testData);
        File xml = new File("output/users.xml");
        assertTrue(xml.exists());


    }
}
