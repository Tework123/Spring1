package org.example1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );

        ClassicalMusic classical = context.getBean("musicBean", ClassicalMusic.class);
        System.out.println(classical.getSong());
        System.out.println("***********");

        ClassicalMusic classical2 = context.getBean("musicBean", ClassicalMusic.class);
        System.out.println(classical2.getSong());
        System.out.println("***********");
        MusicPlayer firstMusicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
        MusicPlayer secondMusicPlayer = context.getBean("musicPlayer", MusicPlayer.class);

        boolean comp = firstMusicPlayer == secondMusicPlayer;
        System.out.println(comp);
        firstMusicPlayer.setVolume(10);
        System.out.println(firstMusicPlayer.getVolume());
        System.out.println(secondMusicPlayer.getVolume());

        System.out.println(firstMusicPlayer.getName());
        System.out.println(firstMusicPlayer.getVolume());
        List<Music> musicList = firstMusicPlayer.getMusicList();


        System.out.println("******");

        for (int i = 0; i < musicList.size(); i++) {
            System.out.println(musicList.get(i).getSong());
        }


        context.close();
    }
}
