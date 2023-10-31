package org.example1;

public class ClassicalMusic implements Music {
    //  запрещает создавать объекты класса с помощью new
    private ClassicalMusic() {
    }

    public static ClassicalMusic getClassicalMusic() {
        return new ClassicalMusic();
    }


    public void doMyInit() {
        System.out.println("Я родился:)");
    }

    public void doMyDestroy() {
        System.out.println("Я умер:(");
    }

    @Override
    public String getSong() {
        return "classical music...";
    }
}
