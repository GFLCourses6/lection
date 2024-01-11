package executor.worker.decorator.source;

import java.util.Base64;
import java.util.stream.IntStream;

public class EncryptionDecorator extends DataSourceDecorator  {
    EncryptionDecorator(DataSource source) {
        super(source);
    }

    @Override
    public void writeData(String data) {
        super.writeData(encode(data));
    }

    @Override
    public String readData() {
        return decode(super.readData());
    }

    private String encode(String data) {
        byte[] result = data.getBytes();
        IntStream.range(0, result.length).forEach(i -> result[i] += (byte) 1);
        return Base64.getEncoder().encodeToString(result);
    }

    private String decode(String data) {
        byte[] result = Base64.getDecoder().decode(data);
        IntStream.range(0, result.length).forEach(i -> result[i] -= (byte) 1);
        return new String(result);
    }
}
