package com.gfl.prokhnov.example.patterns.proxy;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class ProcessRunnerImpl implements ProcessRunner {

    private static final Logger LOGGER = LogManager.getLogger(ProcessRunnerImpl.class.getName());

    @Override
    public void process(String param) {
        LOGGER.info("Process with param " + param + " start in ProcessRunnerImpl.");
        LOGGER.info("Process with param " + param + " finish in ProcessRunnerImpl.");
    }
}
