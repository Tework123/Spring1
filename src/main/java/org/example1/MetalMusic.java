package org.example1;

import org.springframework.stereotype.Component;

import java.util.Random;

//@Component
public class MetalMusic implements Music {
    final private TypeMusic typeMusic = TypeMusic.METAL;

    private String[] songs = new String[]{"metal1", "metal2", "metal3"};


    @Override
    public String[] getSong() {
        Random random = new Random();
        int index = random.nextInt(songs.length);

        System.out.println("metal music today: " + songs[index]);
        return this.songs;
    }

    public TypeMusic getTypeMusic() {
        return typeMusic;
    }
}
