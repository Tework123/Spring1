package org.example1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestSpring {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                SpringConfig.class
        );


        Computer computer = context.getBean("computer", Computer.class);
        computer.getMusicPlayer().playMusic(TypeMusic.METAL);
        System.out.println(computer.getMusicPlayer().getName());
        System.out.println(computer.getMusicPlayer().getVolume());

        ClassicalMusic classicalMusic = context.getBean("classicalMusic", ClassicalMusic.class);
        ClassicalMusic classicalMusic2 = context.getBean("classicalMusic", ClassicalMusic.class);
        System.out.println(classicalMusic2 == classicalMusic);


        context.close();
    }
}
