package org.example1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );

        ClassicalMusic classical = context.getBean("musicBean", ClassicalMusic.class);


        context.close();
    }
}
