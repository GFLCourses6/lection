package com.vladproduction.services;

import java.io.File;

public class FileIntegrationServiceImpl implements FileIntegrationService {
    @Override
    public String getFileNameByPath(String path) {
        File file = new File(path);
        System.out.println(file.getName());
        return file.getName();
    }
}
