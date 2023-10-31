package org.example1;

import org.springframework.stereotype.Component;

import java.util.Random;

//@Component
public class MetalMusic implements Music {
    private TypeMusic typeMusic;

    String[] songs = new String[]{"metal1", "metal2", "metal3"};


    @Override
    public String getSong() {
        Random random = new Random();
        int index = random.nextInt(songs.length);

        System.out.println("metal music today: " + songs[index]);
        return "metal music...";
    }
}
