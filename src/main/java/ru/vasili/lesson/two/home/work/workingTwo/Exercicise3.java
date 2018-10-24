package ru.vasili.lesson.two.home.work.workingTwo;

public class Exercicise3 {
    public static int[] changeArray() {
        int[] number = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < number.length; i++) {
            int q = number[i];
            number[i] = q < 6 ? q * 2 : q;
        }
        return number;
    }
}


