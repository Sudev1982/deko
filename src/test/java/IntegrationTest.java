import factory.FileTypeFactory;
import model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.DataOperationService;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class IntegrationTest {


    private DataOperationService dataOperationService;


    @BeforeEach
    public void setUP() {
        dataOperationService = new DataOperationService(new FileTypeFactory());
    }

    @Test
    public void testDataRead() {

        List<User> users = dataOperationService.readAllAvailableData();
        assertNotNull(users);
        users = dataOperationService.sortUserData(users);
        assertEquals(1, users.get(0).getUser_id());
        assertEquals(2, users.get(1).getUser_id());
        dataOperationService.writeDataInAllFormat(users);
        File csv = new File("output/users.csv");
        File xml = new File("output/users.xml");
        File json = new File("output/users.json");
        assertTrue(csv.exists());
        assertTrue(xml.exists());
        assertTrue(json.exists());

    }


}
