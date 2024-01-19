package ua.chemerys;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

public class CompressionDecorator extends DataSourceDecorator {

    private int compLevel = 6;

    public CompressionDecorator(DataSource source) {
        super(source);
    }

    public int getCompressionLevel() {
        return compLevel;
    }

    public void setCompressionLevel(int value) {
        this.compLevel = value;
    }

    @Override
    public void writeData(String data) {
        super.writeData(compress(data));
    }

    @Override
    public String readData() {
        return decompress(super.readData());
    }

    private String compress(String stringData) {

        byte[] data = stringData.getBytes();

        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
             DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream, new Deflater(compLevel))) {

            deflaterOutputStream.write(data);

            /*
             * Resources must be closed manually despite the use of try-with-resources
             * because they must be closed in reverse order
             */

            deflaterOutputStream.close();
            byteArrayOutputStream.close();

            return Base64.getEncoder().encodeToString(byteArrayOutputStream.toByteArray());
        } catch (IOException exception) {
            return "Here is IOException in compress method";
        }
    }

    private String decompress(String stringData) {
        byte[] data = Base64.getDecoder().decode(stringData);

        try (InputStream inputStream = new ByteArrayInputStream(data);
             InflaterInputStream inflaterInputStream = new InflaterInputStream(inputStream);
             ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512)) {
            int streamByte;
            while ((streamByte = inflaterInputStream.read()) != -1) {
                byteArrayOutputStream.write(streamByte);
            }
            return byteArrayOutputStream.toString();
        } catch (IOException exception) {
            return "Here is IOException in decompress method";
        }
    }
}
