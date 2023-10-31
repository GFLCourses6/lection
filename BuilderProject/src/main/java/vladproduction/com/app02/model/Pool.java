package vladproduction.com.app02.model;

public class Pool {

    private final String poolName;
    private final int m3;

    public Pool(String poolName, int m3) {
        this.poolName = poolName;
        this.m3 = m3;
    }

    public String getPoolName() {
        return poolName;
    }

    @Override
    public String toString() {
        return poolName + "(" + m3 + " m3)";
    }
}
