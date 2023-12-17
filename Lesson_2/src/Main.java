public class Main {

    public static void main(String[] args) {
        checkSumSign();
        printColor();
        compareNumbers();
    }


    public static void printThreeWords(){
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    public static void checkSumSign() {
        printThreeWords();
        int a = 14, b = -16;
        int c = a + b;
        if (c >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    public static  void printColor(){
            int value = 106;
            if (value <= 0) {
                System.out.println("Красный");
            } else if (0 < value && value <= 100) {
                System.out.println("Желтый");
            } else {
                System.out.println("Зеленый");
            }

        }

    public static void compareNumbers() {
        int a = 15,b = 17;
        if (a >= b) {
            System.out.println("a >= b");
        } else
            System.out.println("a < b");
    }




}
