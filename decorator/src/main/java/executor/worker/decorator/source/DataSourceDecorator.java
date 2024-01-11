package executor.worker.decorator.source;

public class DataSourceDecorator implements DataSource {
    private final DataSource source;

    DataSourceDecorator(DataSource source) {
        this.source = source;
    }

    @Override
    public void writeData(String data) {
        source.writeData(data);
    }

    @Override
    public String readData() {
        return source.readData();
    }
}
