package org.example.di.service;

import java.io.File;

public class FileIntegrationServiceImpl implements FileIntegrationService {
    @Override
    public String getFileNameByPath(String path) {
        File f = new File(path);
        System.out.println(f.getName());
        return f.getName();
    }
}
