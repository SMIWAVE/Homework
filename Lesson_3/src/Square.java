public class Square extends Figures{
    double a;
    String name;

    public Square() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void square(String zalivka,String edge){
        System.out.println(getName() + ": цвет заливки: " + zalivka + ". Цвет граней: " + edge + ".");
    }

    @Override
    public void perimetr(double a) {
        double p = 2 * a;
        System.out.println(getName() + ": периметр квадрата равен " + p);
    }

    @Override
    public void area(double a) {
        double s = a * a;
        System.out.println(getName() + ": площадь квадрата равен " + s);
    }
}
