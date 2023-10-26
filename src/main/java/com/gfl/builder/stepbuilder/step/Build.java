package com.gfl.builder.stepbuilder.step;

import com.gfl.builder.stepbuilder.Mail;

import java.time.LocalDateTime;

public interface Build {

    // contains optional fields' setters
    Build setLocalDateTime(LocalDateTime localDateTime);
    Mail build();
}
