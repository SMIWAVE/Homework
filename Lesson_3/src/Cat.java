public class Cat extends Zhivotnoe {
    int nuzhna_eda, eda;
    public static int countCat = 0;
    boolean poel = false;
    public void swim(int dlina) {
        System.out.println(getName() + " не плавает");
    }

    public Cat(int nuzhna_eda){
        countCat++;
        this.nuzhna_eda = nuzhna_eda;
    }

    public void run(int dlina) {
        if (dlina > 200) {
            System.out.println("Кот столько не бежит");
        } else
            System.out.println(getName() + " пробежал" + dlina + " м.");
    }

    public boolean pokushal(int eda){
        if (eda - nuzhna_eda <= 0){
            System.out.println(getName() + " не будет кушать");
        } else if (eda % 2 >= 0) {
            System.out.println(getName() + " кот покушал");
            this.poel = true;
        }
        return poel;
    }
}
