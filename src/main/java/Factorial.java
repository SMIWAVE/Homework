public class Factorial {

    int factor = 1;

    public int getFactor() {
        System.out.println(factor);
        return factor;
    }

    public Factorial(int number) throws ArithmeticException {
        if (number < 0) {
            throw new ArithmeticException("Факториал определен только для неотрицательных чисел");
        }

        factor = 1;
        for (int i = 1; i <= number; i++) {
            factor *= i;
        }
    }

    @Override
    public String toString() {
        return "Factorial{" +
                "factor=" + factor +
                '}';
    }

}
