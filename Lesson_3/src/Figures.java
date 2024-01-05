public class Figures implements Tasks{
    public String zalivka,edge;
    public double s;

    public Figures(){
    }

    public Figures(String zalivka, String edge){
        System.out.println("Цвет фигуры " + zalivka);
        System.out.println("Цвет границы " + edge);
    }
}
