public class Main {
    public static void main(String[] args) {
        int sum;
        String[][] MyArray = new String[][]{
                {"11", "4", "4", "4"},
                {"5", "4", "3", "8"},
                {"3", "5", "1", "5"},
                {"4", "1", "9", "2"},
        };
        sum = MyArraySum(MyArray);
        System.out.println("Сумма всех элементов массива " + sum);
    }

    public static int MyArraySum(String[][] MyArray) throws MyArrayDataException,MyArraySizeException {
        int sum = 0;
        int y = 0, i = 0;

        if (MyArray.length * MyArray[0].length > 16) {
            throw new MyArraySizeException("Массив слишком большой");
        }

        try {
            for (String[] custom : MyArray) {
                for (i = 0;i < custom.length; i++) {
                    sum = sum + Integer.parseInt(custom[i]);
                    }
                y++;
            }
        } catch (NumberFormatException e) {
            throw new MyArrayDataException("Символ либо строка вместо цифры" + "[" + y +"][" + i + "]");
        }
        return sum;
    }
}