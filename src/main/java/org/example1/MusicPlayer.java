package org.example1;

import java.util.ArrayList;
import java.util.List;

public class MusicPlayer {
    private List<Music> musicList = new ArrayList<>();

    private int volume;

    private Music music;
    private String name;


    public List<Music> getMusicList() {
        return musicList;
    }

    public void setMusicList(List<Music> musicList) {
        this.musicList = musicList;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getVolume() {
        return volume;
    }

    public MusicPlayer(Music music) {
        this.music = music;
    }

    //  без аргументов для сеттера в .xml
    public MusicPlayer() {
    }


    public void setMusic(Music music) {
        this.music = music;
    }

    public String playMusic() {
        return this.music.getSong();
    }
}
