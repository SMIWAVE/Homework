import java.util.ArrayList;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        String[] wordArray = new String[]{"берсерк", "викинг", "гитлер", "домашка", "домашка", "домашка", "конь", "слово", "мем", "слово"};
        ArrayList<String> unicWordArray = new ArrayList();

        for(int i = 0; i < wordArray.length; ++i) {
            String word = wordArray[i];
            if (!unicWordArray.contains(word)) {
                unicWordArray.add(word);
            }
        }
        System.out.println(unicWordArray);
        
        Iterator unic = unicWordArray.iterator();

        while(unic.hasNext()) {
            String word = (String)unic.next();
            int wordcount = 0;

            for(int i = 0; i < wordArray.length; ++i) {
                if (word.equals(wordArray[i])) {
                    ++wordcount;
                }
            }

            System.out.println(word + " " + wordcount);
        }

        TelSprav.add("Тарасиков", "+3752910");
        TelSprav.add("Пузиков", "+3752920");
        TelSprav.add("Тарасиков", "+3752911");
        TelSprav.add("Иванский", "+3753315");
        TelSprav.add("Тарасиков", "+3753333");
        TelSprav.add("Бласковиц", "+3754499");
        System.out.println(TelSprav.telSprav.toString());
        TelSprav.get("Иванский");
        TelSprav.get("Тарасиков");
    }
}

