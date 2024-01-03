public class Triangle extends Figures{
    public double a, b, c;
    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Triangle(){
    }

    public void triangle(String zalivka, String edge) {
        System.out.println(getName() + ": цвет заливки: " + zalivka + ". Цвет граней: " + edge + ".");
    }

    @Override
    public void perimetr(double a, double b, double c) {
        double p = a + b + c;
        System.out.println(getName() + ": периметр треугольника равен " + p);
    }

    @Override
    public void area(double a, double b, double c) {
        double s = (a + b + c) / 2;
        double area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
        System.out.println(getName() + ": Площадь треугольника равна " + area);
    }
}
