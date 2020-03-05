package service;

import factory.FileTypeFactory;
import model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import service.dataReadWrite.formats.CsvDataReaderWriter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DataOperationServiceTest {

    @InjectMocks
    private DataOperationService dataOperationService;
    @Mock
    private DataFormatContext dataFormatContext;
    @Mock
    private FileTypeFactory readerWriterFactory;
    private List<User> testData;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        testData = new ArrayList<>();
        testData.add(new User(1, "TestOne First", "TestOne Last", "TestOneUser", "Employee", new Date()));
        testData.add(new User(2, "TestTwo First", "TestTwo Last", "TestTwoUser", "Manager", new Date()));
    }

    @Test
    @DisplayName("readAllAvailableDataService")
    public void readAllAvailableDataTest() {
        Mockito.when(readerWriterFactory.getFormatType(Mockito.anyString())).thenReturn(new CsvDataReaderWriter());
        Mockito.when(dataFormatContext.executeRead()).thenReturn(testData);
        assertNotNull(dataOperationService.readAllAvailableData());
        assertEquals(3, dataOperationService.readAllAvailableData().get(0).getUser_id());
    }

}
