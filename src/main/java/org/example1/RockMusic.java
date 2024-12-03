package org.example1;

import org.springframework.stereotype.Component;

//@Component
public class RockMusic implements Music {
    final private TypeMusic typeMusic = TypeMusic.ROCK;
    private String[] songs = new String[]{"rock1", "rock2", "rock3"};

    @Override
    public String[] getSong() {
        System.out.println("rock music...");
        return this.songs;
    }

    public TypeMusic getTypeMusic() {
        return typeMusic;
    }
}
