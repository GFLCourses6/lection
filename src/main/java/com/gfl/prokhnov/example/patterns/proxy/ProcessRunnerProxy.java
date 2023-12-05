package com.gfl.prokhnov.example.patterns.proxy;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class ProcessRunnerProxy implements ProcessRunner {
    private static final Logger LOGGER = LogManager.getLogger(ProcessRunnerProxy.class.getName());

    private ProcessRunnerImpl objectImpl;

    public ProcessRunnerProxy(ProcessRunnerImpl objectImpl) {
        this.objectImpl = objectImpl;
    }

    @Override
    public void process(String param) {
        LOGGER.info("Process with param " + param + " start in ProcessRunnerProxy.");

        if (objectImpl == null) {
            objectImpl = new ProcessRunnerImpl();
        }
        objectImpl.process(param);

        LOGGER.info("Process with param " + param + " finish in ProcessRunnerProxy.");
    }
}
