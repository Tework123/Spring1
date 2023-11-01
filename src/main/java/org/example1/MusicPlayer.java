package org.example1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//@Component
public class MusicPlayer {
    @Value("${musicPlayer.name}")
    private String name;
    @Value("${musicPlayer.volume}")
    private int volume;

    private List<Music> musicList = new ArrayList<>();

    public String getName() {
        return name;
    }

    public int getVolume() {
        return volume;
    }


    public MusicPlayer(@Qualifier("rockMusic") Music music1, @Qualifier("metalMusic") Music music2, @Qualifier("classicalMusic") Music music3) {
        this.musicList.add(music1);
        this.musicList.add(music2);
        this.musicList.add(music3);


    }

    public String playMusic(TypeMusic typeMusic) {
        System.out.println("Врубил колбасню");
        Random random = new Random();
        int index = random.nextInt(musicList.size());

        System.out.println("music today: " + musicList.get(index));
        return "Потушил колбасню";


    }
}




