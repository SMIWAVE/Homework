public class Circle extends Figures {
    double r;
    String name;

    public Circle() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void circle(String zalivka,String edge){
        System.out.println(getName() + ": цвет заливки: " + zalivka + ". Цвет граней: " + edge + ".");
    }

    @Override
    public void perimetr(double r) {
        double p = 2 * 3.14 * r;
        System.out.println(getName() + ": периметр круга равен " + p);
    }

    @Override
    public void area(double r) {
        double s = 3.14 * r * r;
        System.out.println(getName() + ": площадь круга равен " + s);
    }
}
