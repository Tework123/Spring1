package org.example1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

//@Component
public class MusicPlayer {
    @Value("${musicPlayer.name}")
    private String name;
    @Value("${musicPlayer.volume}")
    private int volume;

    public String getName() {
        return name;
    }

    public int getVolume() {
        return volume;
    }

    private Music music1;
    private Music music2;
    private Music music3;


//    @Autowired
    public MusicPlayer(@Qualifier("rockMusic") Music music1,
                       @Qualifier("metalMusic") Music music2,
                       @Qualifier("classicalMusic") Music music3) {
        this.music1 = music1;
        this.music2 = music2;
        this.music3 = music3;

    }

    public String playMusic(TypeMusic typeMusic) {
        System.out.println("Врубил колбасню");
        if (typeMusic == TypeMusic.ROCK) {
            return this.music1.getSong() + "\n" + "Потушил колбасню";
        } else if (typeMusic == TypeMusic.METAL) {
            return this.music2.getSong() + "\n" + "Потушил колбасню";

        } else {
            return this.music3.getSong() + "\n" + "Потушил колбасню";

        }


    }
}




