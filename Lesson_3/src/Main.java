public class Main {

    public static void main(String[] args) {
        boolean c = checkSumTrue(4, 5);
        checkNumPositive(15);
        boolean b = checkNumPosTru(22);
        strokaNRaz("slovo", 3);
        boolean z = visokosnyyMadness(100);

        int[] array6 = new int[]{1, 0, 1, 1, 0, 1, 0, 1, 0, 1};
        for (int i = 0; i < array6.length; i++) {
            if (array6[i] == 1) {
                array6[i] = 0;
            } else {
                array6[i] = 1;
            }
            System.out.print(array6[i] + ", ");
        }

        System.out.println(" ");

        int[] array100 = new int[100];
        for (int i = 0; i < array100.length; i++) {
            array100[i] = i + 1;
            System.out.print(array100[i] + ", ");
        }

        System.out.println(" ");

        int[] array8 = new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < array8.length; i++) {
            if (array8[i] < 6) {
                array8[i] = array8[i] * 2;
                System.out.print(array8[i] + ", ");
            } else {
                System.out.print(array8[i] + ", ");
            }
        }

        System.out.println(" ");

        int[][] array2x = new int[8][8];
        for (int y = 0; y < array2x.length; y++) {
            System.out.println(" ");
            for (int x = 0; x < array2x[0].length; x++) {
                if (x == y || x + y == 7) {
                    array2x[x][y] = 1;
                    System.out.print(array2x[x][y] + " ");
                } else {
                    System.out.print(array2x[x][y] + " ");
                }
            }
        }

        System.out.println(" ");

        array10(10, 10);
    }

    public static boolean checkSumTrue(int a, int b) {

        int s = a + b;
        boolean c;
        if (s >= 10 && s <= 20) {
            c = true;
            System.out.println("Тру");
        } else {
            c = false;
            System.out.println("Не Тру");
        }
        return c;
    }

    public static void checkNumPositive(int a) {
        int b = a;
        if (b >= 0) {
            System.out.println("Положительное");
        } else
            System.out.println("Отрицательное");
    }

    public static boolean checkNumPosTru(int a) {
        boolean b;
        if (a >= 0) {
            b = true;
            System.out.println("B Tru");
        } else {
            b = false;
            System.out.println("B False");
        }
        return b;
    }

    public static void strokaNRaz(String word, int a) {
        int b;
        for (b = 1; b <= a; b++) {
            System.out.println(word);
        }
    }

    public static boolean visokosnyyMadness(int a) {
        int b = a % 4, c = a % 100, d = a % 400;
        boolean y;
        if (b == 0 && d == 0 && c != 0) {
            y = false;
            System.out.println("Не високосный - Не тру");
        } else {
            y = true;
            System.out.println("Високосный - Тру");
        }
        return y;
    }

    public static int[] array10(int len, int initialValue) {
        int[] arrayIn = new int[len];
        for (int i = 0; i < len; i++) {
            arrayIn[i] = initialValue;
            System.out.print(arrayIn[i] + ", ");
        }
        return arrayIn;
    }
}
