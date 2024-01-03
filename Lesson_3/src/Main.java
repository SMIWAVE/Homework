public class Main {

    public static void main(String[] args) {
        Sotrudnik Ivanov = new Sotrudnik("Ivanov Ivan", "Nachalnik", "Ivanov@mail.ru", "+3752912345678", 54, 1508);
        Ivanov.getValues();

        Sotrudnik[] persArray = new Sotrudnik[5];
        persArray[0] = new Sotrudnik("Sergey Sergey","ZamNachcalnik","Sergey@mail.ru","+375375375",35,1000);
        persArray[1] = new Sotrudnik("Katya Katya","Buhgalter","Katya@mail.ru","+3753753753753",90,3000);
        persArray[2] = new Sotrudnik("Masha Masha","Dvornik","Masha@mail.ru","+3753753753753",190,4000);
        persArray[3] = new Sotrudnik();
        persArray[4] = new Sotrudnik();
        for (int i = 0; i < persArray.length; i++) {
            persArray[i].getValues();
        }
    }
}