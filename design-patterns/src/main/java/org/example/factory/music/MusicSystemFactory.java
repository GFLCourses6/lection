package org.example.factory.music;

public interface MusicSystemFactory<T> {

    T createHighEndMusicSystem();

    T createLowEndMusicSystem();
}
