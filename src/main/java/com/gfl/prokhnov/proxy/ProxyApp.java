package com.gfl.prokhnov.proxy;

public class ProxyApp {
    public static void main(String[] args) {
        ProxyApp proxyApp = new ProxyApp();
        proxyApp.run();
    }

    private void run() {
        ProcessRunner processRunner = new ProcessRunnerProxy(new ProcessRunnerImpl());
        processRunner.process("Some param");
    }
}
