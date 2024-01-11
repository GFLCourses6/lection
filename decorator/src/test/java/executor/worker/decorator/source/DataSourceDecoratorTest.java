package executor.worker.decorator.source;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DataSourceDecoratorTest {

    private static final String testFileName = "test.txt";
    private static final String testData = "File Data Source";

    FileDataSource fileDataSource;

    @BeforeEach
    public void setup() {
        fileDataSource = new FileDataSource(testFileName);
    }

    @Test
    void testFileDataSource() {
        fileDataSource.writeData(testData);
        String data = fileDataSource.readData();
        assertEquals(testData, data, "Data read from FileDataSource does not match written data");
    }

    @Test
    void testDataSourceDecorator() {
        DataSourceDecorator dataSourceDecorator = new DataSourceDecorator(fileDataSource);
        dataSourceDecorator.writeData(testData);
        String data = dataSourceDecorator.readData();
        assertEquals(testData, data, "Data read from DataSourceDecorator does not match written data");
    }

    @Test
    void testEncryptionDecorator() {
        EncryptionDecorator encryptionDecorator = new EncryptionDecorator(fileDataSource);
        encryptionDecorator.writeData(testData);
        String data = encryptionDecorator.readData();
        assertEquals(testData, data, "Decoded data does not match original data");
    }

    @Test
    void testCompressionDecorator() {
        DataSourceDecorator dataSourceDecorator = new DataSourceDecorator(fileDataSource);
        CompressionDecorator compressionDecorator = new CompressionDecorator(dataSourceDecorator);
        compressionDecorator.writeData(testData);
        String data = compressionDecorator.readData();
        assertEquals(testData, data);
    }

    @Test
    void testDataSourceDecoratorWithEncryptionAndCompression() {
        DataSourceDecorator dataSourceDecorator = new DataSourceDecorator(fileDataSource);
        EncryptionDecorator encryptionDecorator = new EncryptionDecorator(dataSourceDecorator);
        CompressionDecorator compressionDecorator = new CompressionDecorator(encryptionDecorator);
        compressionDecorator.writeData(testData);
        String data = compressionDecorator.readData();
        assertEquals(testData, data);
    }

    @Test
    void testDataSourceDecoratorWithEncryption() {
        DataSourceDecorator dataSourceDecorator = new DataSourceDecorator(fileDataSource);
        EncryptionDecorator encryptionDecorator = new EncryptionDecorator(dataSourceDecorator);
        encryptionDecorator.writeData(testData);
        String data = encryptionDecorator.readData();
        assertEquals(testData, data);
    }

    @Test
    void testEncryptionDecoratorWithCompression() {
        EncryptionDecorator encryptionDecorator = new EncryptionDecorator(fileDataSource);
        CompressionDecorator compressionDecorator = new CompressionDecorator(encryptionDecorator);
        compressionDecorator.writeData(testData);
        String data = compressionDecorator.readData();
        assertEquals(testData, data);
    }


    @AfterAll
    public static void cleanup() {
        File testFile = new File(testFileName);
        if (testFile.exists()) {
            boolean delete = testFile.delete();
            System.out.println(delete);
        }
    }
}
