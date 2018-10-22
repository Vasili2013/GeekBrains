package ru.vasili.lesson.two.home.work.workingTwo;

public class Exercise1 {

    public static void main(String[] args) {
        final int[] BitRan = new int[41];
        int rang = 2;

        int f = (int) (Math.random() * rang);
        for (int i = 0; i < 41; i++) {
            BitRan[i] = f;
        }
        class Revers extends Exercise1 {
            public void invertArray() {
                for (int i = 0; i < BitRan.length; i++) {
                    if (BitRan[i] == 1) {
                        BitRan[i] = 0;
                    } else {
                        BitRan[i] = 1;
//вроде так красиво=)
                    }
                }
            }
        }
    }
}