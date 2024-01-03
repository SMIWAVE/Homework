public class Main {

    public static void main(String[] args) {
        Zhivotnoe Barsik = new Zhivotnoe();
        Barsik.setName("Barsik");
        Barsik.swim(150);
        Barsik.run(330);
        Cat Murzik = new Cat(10);
        Cat Chad = new Cat(15);
        Murzik.setName("Murzik");
        Murzik.swim(1000);
        Murzik.run(199);
        Murzik.pokushal(12);
        Dog Sharik = new Dog();
        Sharik.setName("Sharik");
        Sharik.swim(9);
        Sharik.run(600);
        Cat[] Party = new Cat[4];
        Party[0] = new Cat(10);
        Party[1] = new Cat(11);
        Party[2] = new Cat(12);
        Party[3] = new Cat(13);
        for (int i = 0; i < Party.length; i++) {
            Party[i].setName("Obzhora " + i);
            Party[i].pokushal(11);
        }
        System.out.println(Cat.countCat);
        System.out.println(Dog.countDog);
        System.out.println(Zhivotnoe.countZhiv);

        Triangle Triangle_1 = new Triangle();
        Triangle_1.setName("Первый треугольник");
        Triangle_1.triangle("Синий","Красный");
        Triangle_1.perimetr(3.0,4.0,5.0);
        Triangle_1.area(3.0,4.0,5.0);

        Circle Circle_1 = new Circle();
        Circle_1.setName("Ктулху круг");
        Circle_1.circle("Зеленый","Желтый");
        Circle_1.perimetr(4.0);
        Circle_1.area(4.0);

        Square Square_1 = new Square();
        Square_1.setName("Губка Боб");
        Square_1.square("Желтый","Желтый");
        Square_1.perimetr(5.0);
        Square_1.area(5.0);
    }
}