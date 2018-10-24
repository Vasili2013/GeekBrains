package ru.vasili.lesson.two.home.work.workingTwo;

public class Exercicise4 {
    public static int[][] main(String[] args) {
        static int[][] fillDiagonalArray ( int[][] array){
            int length = array.length;
            int firstItem;
            int lastItem;
            int firstArray;
            int lastArray;

            for (int i = 0; i < length; i++) {
                firstItem = i;
                lastItem = length - i - 1;

                firstArray = array[i][firstItem];
                lastArray = array[i][lastItem];

                if (firstArray != 1 && lastArray != 1) {
                    array[i][firstItem] = 1;
                    array[i][lastItem] = 1;
                }
            }
            return array;
        }
    }
}
