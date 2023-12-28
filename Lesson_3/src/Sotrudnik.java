public class Sotrudnik {
    public String fio, dolzhnost, email, tel;
    public int age, income;

    public Sotrudnik(String fio, String dolzhnost, String email, String tel, int age, int income) {
        this.fio = fio;
        this.dolzhnost = dolzhnost;
        this.email = email;
        this.tel = tel;
        this.age = age;
        this.income = income;

//        String info = "FIO: " + fio + ". Dolzhnost: " + dolzhnost + ". email: " + email + ". Tel: " + tel + ". Age: " + age + ". Income: " + income;
//        System.out.println(info);
    }

    public Sotrudnik() {
        this.fio = "Ivan";
        this.dolzhnost = "Ivan";
        this.email = "Ivan";
        this.tel = "Ivan";
        this.age = 69;
        this.income = 96;
    }

    public String getValues() {
        String info = "FIO: " + fio + ". Dolzhnost: " + dolzhnost + ". email: " + email + ". Tel: " + tel + ". Age: " + age + ". Income: " + income + "\n";
        System.out.println(info);
        return info;
    }
}
