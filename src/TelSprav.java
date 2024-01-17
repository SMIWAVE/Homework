import java.util.ArrayList;
import java.util.Objects;

public class TelSprav {

    String name, tel;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    static ArrayList<Tel_Info> telSprav = new ArrayList<Tel_Info>();

    @Override
    public String toString() {
        return name + tel;
    }

    public static void add(String name, String tel){
        telSprav.add(new Tel_Info(name,tel));
    }

    public static void get(String name){
        for (Tel_Info entry : telSprav) {
            if (entry.getName().equals(name)) {
                System.out.println(entry.getName() + entry.getTel());
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TelSprav telSprav = (TelSprav) o;
        return Objects.equals(name, telSprav.name) && Objects.equals(tel, telSprav.tel);
    }
}

