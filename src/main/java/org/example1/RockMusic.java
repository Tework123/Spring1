package org.example1;

import org.springframework.stereotype.Component;

//@Component
public class RockMusic implements Music {
    private TypeMusic typeMusic;
    String[] songs = new String[]{"rock1", "rock2", "rock3"};

    @Override
    public String getSong() {
        System.out.println("rock music...");
        return "rock music...";
    }
}
