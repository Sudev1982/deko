package dataReadWrite;

import model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import service.dataReadWrite.AbstractReadWrite;

import java.io.File;
import java.nio.file.NoSuchFileException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AbstractReadWriteTest {

    List<User> testData;
    private AbstractReadWrite abstractReadWrite;

    @BeforeEach
    public void setUp() {
        abstractReadWrite = Mockito.mock(AbstractReadWrite.class, Mockito.CALLS_REAL_METHODS);
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
    @DisplayName("readCsvFileTesting")
    public void readCsvFileTest() {
        assertNotNull(abstractReadWrite.readFile("data/users.csv"));
    }

    @Test
    @DisplayName("readCsvFileWithEmptyPathTesting")
    public void readCsvFilePathEmptyTest() {
        assertEquals("", abstractReadWrite.readFile(""));
    }

    @Test
    @DisplayName("readCsvFileWithNullPathTesting")
    public void readCsvFilePathNullTest() {
        assertEquals("", abstractReadWrite.readFile(null));
    }

    @Test
    @DisplayName("readCsvFileNotAvailableTesting")
    public void readCsvFileNotAvailableTest() {
        Exception e = assertThrows(NoSuchFileException.class, () -> onlyThrowsExceptions());
        assertEquals("An exception was thrown!", e.getMessage());
    }

    public void onlyThrowsExceptions() throws NoSuchFileException {
        throw new NoSuchFileException("An exception was thrown!");
    }

    @Test
    @DisplayName("readXmlFileTesting")
    public void readXmlFileTest() {
        assertNotNull(abstractReadWrite.readFile("data/users.xml"));
    }

    @Test
    @DisplayName("readJsonFileTesting")
    public void readJsonFileTest() {
        assertNotNull(abstractReadWrite.readFile("data/users.json"));
    }


    @Test
    @DisplayName("createCsvFileTesting")
    public void createCsvFileTest() {
        abstractReadWrite.createFile("output/users.csv", "user_id,first_name,last_name,username,user_type,last_login_time\n" +
                "1,\"TestOne First\",\"TestOne Last\",TestOneUser,Employee,\"04-03-2020 10:14:56\"\n" +
                "2,\"TestTwo First\",\"TestTwo Last\",TestTwoUser,Manager,\"04-03-2020 10:14:56\"\n");
        File csv = new File("output/users.csv");
        assertTrue(csv.exists());

    }

    @Test
    @DisplayName("createXmlFileTesting")
    public void createXmlFileTest() {
        abstractReadWrite.createFile("output/users.xml", "<Users><user><userid>1</userid><firstname>TestOne First</firstname><surname>TestOne Last</surname><username>TestOneUser</username><type>Employee</type><lastlogintime>04-03-2020 10:21:06</lastlogintime></user><user><userid>2</userid><firstname>TestTwo First</firstname><surname>TestTwo Last</surname><username>TestTwoUser</username><type>Manager</type><lastlogintime>04-03-2020 10:21:06</lastlogintime></user></Users>");
        File xml = new File("output/users.xml");
        assertTrue(xml.exists());
    }

    @Test
    @DisplayName("createJsonFileTesting")
    public void createJsonFileTest() {
        abstractReadWrite.createFile("output/users.json", "[{\"user_id\":1,\"first_name\":\"TestOne First\",\"last_name\":\"TestOne Last\",\"username\":\"TestOneUser\",\"user_type\":\"Employee\",\"last_login_time\":\"04-03-2020 10:30:30\"},{\"user_id\":2,\"first_name\":\"TestTwo First\",\"last_name\":\"TestTwo Last\",\"username\":\"TestTwoUser\",\"user_type\":\"Manager\",\"last_login_time\":\"04-03-2020 10:30:30\"}]");
        File json = new File("output/users.json");
        assertTrue(json.exists());
    }

    @Test
    @DisplayName("createEmptyPathAndJsonFileTesting")
    public void createEmptyPathAndJsonJsonFileTest() {
        abstractReadWrite.createFile("", "");
        File json = new File("output/users.json");
        assertFalse(json.exists());
    }

    @Test
    @DisplayName("createEmptyJsonFileTesting")
    public void createEmptyJsonJsonFileTest() {
        abstractReadWrite.createFile("output/users.json", "");
        File json = new File("output/users.json");
        assertFalse(json.exists());
    }


}
