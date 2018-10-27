package ru.vasili.lesson.two.home.work.PracticalExercise;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Practical0 {
    static Random random = new Random ( );
    static Scanner sc = new Scanner (System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.print ("Сделаите выбор:\n" + "1. Поиграть в игру: угадай число, у вас будет 3 попытки. \n2. Выйти. \n");
            try {
                switch (sc.nextInt ( )) {
                    case (1):
                        TumbersGame ( );
                        break;
                    default:
                        return;
                }
            } catch (Exception e) {
                System.out.println ("Введено некорректное значение или символ, попробуите занаво.");
                sc.next ( );
            }
        }
    }

    static void TumbersGame() {
        do {
            int count = 0;
            final int min = 0;
            final int rang = +10;
            final int f = min + (int) (Math.random ( ) * rang);
            while (count < 3) {
                System.out.print (
                        "Загадаите число от 0 до 9, попытка №" + (count + 1) + "): ");
                try {
                    int g = sc.nextInt ( );
                    if (f == g) {
                        System.out.println ("Поздравляем вы угадали число!");
                        break;
                    } else {
                        System.out.println ("Загадоное число " + ((g > f) ?
                                "Меньше." : "Больше"));
                        count++;
                    }
                } catch (Exception e) {
                    System.out.println ("Введено некорректное значение или символ, попробуите занаво.");
                    sc.next ( );
                }
            }
            if (count == 3)
                System.out.println ("Попытки коньчились, вы проиграли");
            System.out.print ("Начать игру заново? или выти в главное меню. 1 - да / 0 - нет:  ");
        } while (sc.next ( ).equals ("1"));
    }
}


