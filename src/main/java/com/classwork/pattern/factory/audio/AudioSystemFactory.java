package com.classwork.pattern.factory.audio;

public interface AudioSystemFactory {

    AudioSystem createBasic();

    AudioSystem createHighEnd();
}
