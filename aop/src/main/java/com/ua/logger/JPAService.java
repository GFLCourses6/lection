package com.ua.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class JPAService {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(JPAService.class);

    public String save(String message) {
        LOGGER.info("saving ... {}", message);
        return message;
    }
}
