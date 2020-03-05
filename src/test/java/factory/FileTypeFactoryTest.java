package factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.dataReadWrite.formats.CsvDataReaderWriter;
import service.dataReadWrite.formats.JsonDataReaderWriter;
import service.dataReadWrite.formats.XmlDataReaderWriter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FileTypeFactoryTest {
    private FileTypeFactory fileTypeFactory;

    @BeforeEach
    public void setUp() {
        fileTypeFactory = new FileTypeFactory();
    }

    @Test
    @DisplayName("csvInstanceFromFactoryTest")
    public void getCsvFormatTypeTest() {
        assertTrue(fileTypeFactory.getFormatType("csv") instanceof CsvDataReaderWriter);
    }

    @Test
    @DisplayName("xmlInstanceFromFactoryTest")
    public void getXmlFormatTypeTest() {
        assertTrue(fileTypeFactory.getFormatType("xml") instanceof XmlDataReaderWriter);
    }

    @Test
    @DisplayName("jsonInstanceFromFactoryTest")
    public void getJsonFormatTypeTest() {
        assertTrue(fileTypeFactory.getFormatType("json") instanceof JsonDataReaderWriter);
    }

    @Test
    @DisplayName("nullFromFactoryTest")
    public void getFormatTypeTest() {
        assertEquals(null, fileTypeFactory.getFormatType("test"));
        assertEquals(null, fileTypeFactory.getFormatType(null));
    }
}
