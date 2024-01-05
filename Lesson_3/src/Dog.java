public class Dog extends Zhivotnoe {
    public static int countDog = 0;

    public Dog() {
        countDog++;
    }

    public void swim(int dlina) {
        if (dlina > 10) {
            System.out.println("Собака столько не плывет");
        } else
            System.out.println(getName() + " проплыл(а) " + dlina + " м.");
    }

    public void run(int dlina) {
        if (dlina > 500) {
            System.out.println("Собака столько не бежит");
        } else
            System.out.println(getName() + " пробежал(а)" + dlina + " м.");
    }
}
