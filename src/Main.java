import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    private static class Student {

        private enum Gender {
            MAN, WOMAN
        }

        public Integer getAge() {
            return age;
        }

        public Gender getGender() {
            return gender;
        }

        private final String name;
        private final Integer age;
        private final Gender gender;

        public Student (String name, Integer age,Gender gender ){
            this.name = name;
            this.age = age;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", gender=" + gender +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Student)) return false;
            Student student = (Student) o;
            return Objects.equals(name, student.name) && Objects.equals(age, student.age) && gender == student.gender;
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age, gender);
        }
    }


    public static void main(String[] args) {

        List<Integer> random = Stream.generate(() -> new Random().nextInt(100))
                .limit(10)
                .filter(i -> i % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(random);

        ArrayList<String> hightask = new ArrayList<>();
        Collections.addAll(hightask,"Highload","High","Load","Highload");
        long count = hightask.stream()
                .filter(s -> s.equals("High"))
                .count();
        String first = hightask.stream()
                .findFirst()
                .orElse(null);
        String last = hightask.stream()
                .skip(3)
                .findFirst()
                .orElse(null);
        System.out.println("Кол-во High " + count + "\n" + "Превый элемент коллекции " + first + "\n" + last);

        ArrayList<String> by_value = new ArrayList<>();
        Collections.addAll(by_value, "f10","a15","f2","f4","f5","b54","a16");
        Object[] alphbet = by_value.stream()
                .sorted(Comparator.comparing((String s) -> s.substring(0, 1))
                .thenComparingInt(s -> Integer.parseInt(s.substring(1))))
                .toArray();

        System.out.println(Arrays.toString(alphbet));

        Collection<Student> students = Arrays.asList(
                new Student("Дмитрий",17, Student.Gender.MAN),
                new Student("Максим",20, Student.Gender.MAN),
                new Student("Екатерина",20, Student.Gender.WOMAN),
                new Student("Михаил",28, Student.Gender.MAN)
        );

                Object[] armyman = students.stream()
                        .filter(student -> student.getGender().equals(Student.Gender.MAN))
                        .filter(student -> student.getAge() >= 18 && student.getAge() <= 27)
                        .toArray();

                Double middleage = students.stream()
                        .filter(student -> student.getGender().equals(Student.Gender.MAN))
                        .mapToDouble(Student::getAge)
                        .average()
                        .orElse(0.0);

        System.out.println(middleage);
        System.out.println(Arrays.toString(armyman));

        Scanner scanner = new Scanner(System.in);
        Object[] logins = Stream.generate(() -> {
                    String input = scanner.nextLine();
                    return input;
                }).takeWhile(n -> !n.isEmpty())
                .filter(n -> n.toString().startsWith("f"))
                .toArray();

        for (Object login : logins) {
            System.out.println(login);
        }

        scanner.close();
    }
}
