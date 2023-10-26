package com.gfl.builder.stepbuilder;

import com.gfl.builder.stepbuilder.step.*;

import java.time.LocalDateTime;

public class Mail {

    private final String title;
    private final String body;
    private final String senderId;
    private final String receiverId;
    private final LocalDateTime localDateTime;

    private Mail(Builder builder) {
        this.title = builder.title;
        this.body = builder.body;
        this.senderId = builder.senderId;
        this.receiverId = builder.receiverId;
        this.localDateTime = builder.localDateTime;
    }

    public static TitleStep builder() {
        return new Builder();
    }

    public static class Builder implements TitleStep, BodyStep, SenderStep, ReceiverStep, Build {
        private String title;
        private String body;
        private String senderId;
        private String receiverId;
        private LocalDateTime localDateTime = LocalDateTime.now(); // default value

        private Builder() {
        }

        @Override
        public BodyStep setTitle(String title) {
            this.title = title;
            return this;
        }

        @Override
        public SenderStep setBody(String body) {
            this.body = body;
            return this;
        }

        @Override
        public ReceiverStep setSenderId(String senderId) {
            this.senderId = senderId;
            return this;
        }

        @Override
        public Build setReceiverId(String receiverId) {
            this.receiverId = receiverId;
            return this;
        }

        @Override
        public Build setLocalDateTime(LocalDateTime localDateTime) {
            this.localDateTime = localDateTime;
            return this;
        }

        @Override
        public Mail build() {
            return new Mail(this);
        }
    }

    @Override
    public String toString() {
        return "Mail{" +
                "title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", senderId='" + senderId + '\'' +
                ", receiverId='" + receiverId + '\'' +
                ", localDateTime=" + localDateTime +
                '}';
    }

    // getters
}
