package ru.vasili.lesson.two.home.work.workingTwo;

public class Exercise1 {

    public static void main(String[] args) {
        final int[] bitRan = new int[41];
        int rang = 2;

        int f = (int) (Math.random() * rang);
        for (int i = 0; i < 41; i++) {
            bitRan[i] = f;
        }
        class Revers extends Exercise1 {
            public void invertArray() {
                for (int i = 0; i < bitRan.length; i++) {
                    if (bitRan[i] == 1) {
                        bitRan[i] = 0;
                    } else {
                        bitRan[i] = 1;
//куда дели
                    }
                }
            }
        }
    }
}