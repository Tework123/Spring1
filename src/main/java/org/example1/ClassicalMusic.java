package org.example1;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

//@Component
public class ClassicalMusic implements Music {
    private TypeMusic typeMusic;

    String[] songs = new String[]{"classic1", "classic2", "classic3"};

    @PostConstruct
    public void init() {
        System.out.println("Я родился");
    }

    @PreDestroy
    public void exitDestroy() {
        System.out.println("Я скрючился");
    }

    //  запрещает создавать объекты класса с помощью new
    private ClassicalMusic() {
    }

    public static ClassicalMusic getClassicalMusic() {
        return new ClassicalMusic();
    }


    @Override
    public String getSong() {
        System.out.println("classical music...");
        return "classical music...";
    }
}
