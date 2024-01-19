package ua.chemerys;

public interface DataSource {

    void writeData(String data);

    String readData();
}
