public class Zhivotnoe {
    String name;
    public static int countZhiv;

    public Zhivotnoe() {
        countZhiv++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void swim(int dlina){
        System.out.println(getName() + " проплыл " + dlina + " m.");
    }

    public void run(int dlina){
        System.out.println(getName() + " пробежал " + dlina + " m.");

    }
}
