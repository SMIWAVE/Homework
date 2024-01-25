import java.util.ArrayList;
import java.util.Objects;

public class Box<T extends Fruit> {

//    private static Object T;

    @Override
    public String toString() {
        return "Box{" +
                "box=" + box +
                '}';
    }

    private ArrayList<T> box = new ArrayList<>();

    public int getQuantity() {
        return quantity;
    }

    private void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    private int quantity;
    private float boxWeight;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Box)) return false;
        Box<?> box1 = (Box<?>) o;
        return Objects.equals(box, box1.box);
    }

    @Override
    public int hashCode() {
        return Objects.hash(box);
    }

    public Box(T fruit, int quantity) {
        setQuantity(quantity);
        for (int i = 0; i < quantity; i++) {
            box.add(fruit);
        }
        boxWeight = quantity * fruit.getWeight();
    }

    public float getWeight(){
        boxWeight = getQuantity() * box.get(0).getWeight();
        return boxWeight;
    }

    public boolean compare(Box<? extends Fruit> otherBox){
        if (otherBox.getWeight() == this.boxWeight) {
            return true;
        }
        return false;
    }

    public void add(T fruit) {
        box.add(fruit);
        boxWeight += fruit.getWeight();
        quantity++;
    }

    public int give(Box<T> otherBox, int give) {
        T fruit;
        if (this.getQuantity() - give < 0) {
            System.out.println("Нельзя взять больше чем в ящике");
        } else if (this == otherBox) {
            System.out.println("Тот же ящик");
        } else if (!this.box.equals(otherBox)) {
            for (int i = 0; i < give; i++) {
                fruit = this.box.remove(this.box.size() - 1);
                otherBox.add(fruit);
                quantity--;
            }
            return give;
        }
        return 0;
    }
}