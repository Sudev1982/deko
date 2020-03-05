package factory;

import service.dataReadWrite.DataReadWrite;
import service.dataReadWrite.formats.CsvDataReaderWriter;
import service.dataReadWrite.formats.JsonDataReaderWriter;
import service.dataReadWrite.formats.XmlDataReaderWriter;

public class FileTypeFactory {
    public DataReadWrite getFormatType(String fileFormat) {

        if (fileFormat == null)
            return null;

        if (fileFormat.equalsIgnoreCase("csv")) {
            return new CsvDataReaderWriter();
        } else if (fileFormat.equalsIgnoreCase("xml")) {
            return new XmlDataReaderWriter();
        } else if (fileFormat.equalsIgnoreCase("json")) {
            return new JsonDataReaderWriter();
        } else
            return null;
    }
}
