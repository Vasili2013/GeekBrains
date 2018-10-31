package ru.vasili.lesson.two.home.work.PracticalExercise;

import java.util.Random;
import java.util.Scanner;

public class Practical0 {
    static Random random = new Random ( );
    static Scanner sc = new Scanner ( System.in );
    static final String User_Sign = "X";
    static final String User_Sign_Second = "O";
    static final String Ai_Sign = "O";
    static final String Not_Sign = "*";
    static int aiLevel = 0;
    static String[][] field;
    static int count = 0;
    private static int saize;

    public static void main ( String[] args ) {
        while (true) {
            System.out.print ( "Сделаите выбор:\n" + "1. Поиграть в игру: угадай число, у вас будет 3 попытки. \n2. Игра в крестики нолики. \n3 Выход:" );
            try {
                switch (sc.nextInt ( )) {
                    case (1):
                        TumbersGame ( );
                        break;
                    case (2):
                        TicTacToeGame ( );
                    default:
                        return;
                }
            } catch (Exception e) {
                System.out.println ( "Введено некорректное значение или символ, попробуите занаво." );
                sc.next ( );
            }
        }
    }

    private static void TumbersGame () {
        do {
            int count = 0;
            final int min = 0;
            final int rang = +10;
            final int f = min + (int) (Math.random ( ) * rang);
            while (count < 3) {
                System.out.print (
                        "Загадаите число от 0 до 9, попытка №" + (count + 1) + "): " );
                try {
                    int g = sc.nextInt ( );
                    if (f == g) {
                        System.out.println ( "Поздравляем вы угадали число!" );
                        break;
                    } else {
                        System.out.println ( "Загадоное число " + ((g > f) ?
                                "Меньше." : "Больше") );
                        count++;
                    }
                } catch (Exception e) {
                    System.out.println ( "Введено некорректное значение или символ, попробуите занаво." );
                    sc.next ( );
                }
            }
            if (count == 3)
                System.out.println ( "Попытки коньчились, вы проиграли" );
            System.out.print ( "Начать игру заново? или выти в главное меню. 1 - да / 0 - нет:  " );
        } while (sc.next ( ).equals ( "1" ));
    }

    public static void TicTacToeGame () {
        System.out.println ( "Крестики Нолики." );
        System.out.println ( "Выберите режим игры: \n" + "1. Игра на двоих. \n" + "2.Против ПК. \n" + "3.Ввернутса в главное меню." );
        while (true) {
            switch (sc.nextInt ( )) {
                case (1):
                    TwoPlayers ( );
                    break;
                case (2):
                    AiSign ( );
                    break;
                case (3):
                default:
            }
        }
    }

    public static void TwoPlayers () {
        Complexity ( );
        initField ( );
        while (true) {
            printField ( );
            userShot ( User_Sign, 1 );
            count++;
            if (checkWin ( User_Sign )) {
                System.out.println ( "Победили крестики игрок" );
                printField ( );
                break;
            }
            userShot ( User_Sign_Second, 2 );
            count++;
            if (checkWin ( User_Sign_Second )) {
                System.out.println ( "Победили нолики игрок" );
                printField ( );
                break;
            }
            if (count == Math.pow ( saize, 2 )) {
                printField ( );
                break;
            }
        }

    }

    public static void AiSign () {
        Complexity ( );
        initField ( );
        while (true) {
            printField ( );
            userShot ( User_Sign, 0 );
            count++;
            if (checkWin ( User_Sign )) {
                System.out.println ( "Победил человек" );
                printField ( );
                break;
            }
            aiShot ( );
            count++;
            if (checkWin ( Ai_Sign )) {
                System.out.println ( "Победил ПК" );
                printField ( );
                break;
            }
            if (count == Math.pow ( saize, 2 )) {
                printField ( );
                break;
            }
        }
    }

    public static void Complexity () {
        System.out.println ( "Выберите уровень сложности: \n" + "1. 3X3 Легко. \n" + "2. 5Х5 Средния. \n" + "3. 10Х10 Тяжёлая. \n" + "4. Своё поле" );
        try {
            switch (sc.nextInt ( )) {
                case (1):
                    saize = 3;
                    break;
                case (2):
                    saize = 5;
                    break;
                case (3):
                    saize = 10;
                    break;
                case (4):
                    saize = sc.nextInt ( );
                    break;

            }
        } catch (Exception e) {
            System.out.println ( "Не коректный символ" );
        }
    }

    public static void initField () {//ПОЛЕ ИГРОВОЕ
        field = new String[saize][saize];
        for (int i = 0; i < saize; i++) {
            for (int j = 0; j < saize; j++) {
                field[i][j] = Not_Sign;
            }
        }
    }

    public static void printField () {
        for (int i = 0; i <= saize; i++) {
            System.out.print ( i + " " );
        }
        System.out.println ( );
        for (int i = 0; i < saize; i++) {
            System.out.print ( (i + 1) + " " );
            for (int j = 0; j < saize; j++) {
                System.out.print ( field[i][j] + " " );
            }
            System.out.println ( );
        }
    }


    public static void aiShot ()                          //ИСКУСТВЕНЫЙ ИНТЕЛЕКТ =)
    {
        int x = -1;
        int y = -1;
        boolean ai_win = false;
        boolean user_win = false;
        if (aiLevel == 2) {
            for (int i = 0; i < saize; i++) {
                for (int j = 0; j < saize; j++) {
                    if (!isCellBusy ( i, j )) {
                        field[i][j] = Ai_Sign;
                        if (checkWin ( User_Sign )) {
                            x = i;
                            y = j;
                            ai_win = true;
                        }
                        field[i][j] = Not_Sign;
                    }
                }
            }
        }
        if (aiLevel > 0) {
            if (!ai_win) {
                for (int i = 0; i < saize; i++) {
                    for (int j = 0; j < saize; j++) {
                        if (!isCellBusy ( i, j )) {
                            field[i][j] = User_Sign_Second;
                            if (checkWin ( User_Sign )) {
                                x = i;
                                y = j;
                                user_win = true;
                            }
                            field[i][j] = Not_Sign;
                        }
                    }
                }
            }
        }
        if (!ai_win && !user_win) {
            do {
                Random rnd = new Random ( );
                x = rnd.nextInt ( saize );
                y = rnd.nextInt ( saize );
            }
            while (isCellBusy ( x, y ));
        }
        field[x][y] = Ai_Sign;
    }

    public static void userShot ( String sign, int i )   // ТУТ НАШ ХОД ПОКАЖУТ
    {
        int x = -1;
        int y = -1;
        do {
            if (i == 0) {
                System.out.println ( "Введите координаты x y (1 - " + saize + "): " );
            } else {
                System.out.println ( "Игрок " + i + ". Введите координаты x y (1 - " + saize + "): " );
            }
            Scanner sc = new Scanner ( System.in );
            x = sc.nextInt ( ) - 1;
            y = sc.nextInt ( ) - 1;
        }
        while (isCellBusy ( x, y ));
        field[x][y] = sign;
    }

    public static boolean isCellBusy ( int x, int y ) //ПРОВЕРКА НА ПУСТОЕ МЕСТО.
    {
        if (x < 0 || y < 0 || x > saize - 1 || y > saize - 1) {
            return false;
        }
        return field[x][y] != Not_Sign;
    }

    public static boolean checkLine ( int start_x, int start_y, int dx, int dy, String sign ) { //ПРОВЕРКА НА ПОБЕДУ
        for (int i = 0; i < saize; i++) {
            if (field[start_x + i * dx][start_y + i * dy] != sign) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkWin ( String sign ) {                          //ПРОВЕРКА НА ПОБЕДУ
        for (int i = 0; i < saize; i++) {

            if (checkLine ( i, 0, 0, 1, sign )) return true;
            if (checkLine ( 0, i, 1, 0, sign )) return true;
        }

        if (checkLine ( 0, 0, 1, 1, sign )) return true;
        if (checkLine ( 0, saize - 1, 1, -1, sign )) return true;
        return false;
    }
}



