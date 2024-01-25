public class Main {
    public static void main(String[] args) {
        Box<Apple> boxApple1 = new Box<>(new Apple(),3);
        Box<Orange> boxOrange1 = new Box<>(new Orange(),3);
        Box<Apple> boxApple2 = new Box<>(new Apple(),7);
        Box<Orange> boxOrange2 = new Box<>(new Orange(),3);

        System.out.println(boxApple1.getQuantity());
        System.out.println(boxOrange1.getQuantity());
        System.out.println(boxApple1.getWeight());
        System.out.println(boxOrange1.getWeight());
        System.out.println(boxApple1.compare(boxApple2));
        System.out.println(boxOrange1.compare(boxOrange2));
        System.out.println(boxApple1.compare(boxOrange1));
        System.out.println(boxApple1);
        boxApple1.give(boxApple2,3);
        System.out.println(boxApple1);
        System.out.println(boxApple1.getQuantity());
        boxApple1.add(new Apple());
        boxApple1.add(new Apple());
        System.out.println(boxApple1);
        System.out.println(boxApple1.getQuantity());
        System.out.println(boxApple2.getQuantity());
        System.out.println(boxApple2);
    }
}