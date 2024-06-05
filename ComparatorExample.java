package Lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ComparatorExample {

    public static void main(String[] args) {
        Person p1 = new Person();
        p1.setName("Dinesh");
        p1.setAge(30);

        Person p2 = new Person();
        p2.setName("Chithu");
        p2.setAge(25);

        Person p3 = new Person();
        p3.setName("Yaazhl Kutti");
        p3.setAge(1);

        List<Person> people = Arrays.asList(
            p1,p2,p3
        );
        people.sort(new Comparator<Person>() {
            @Override
            public int compare(Person p1,Person p2)
            {
                return Integer.compare(p1.getAge(), p2.getAge());
            }
            
        });

        System.out.println(people);
        System.out.println("Lambda Sort");

        List<Person> lambda_person = Arrays.asList(
            p1,p2,p3
        );
        lambda_person.sort( (po1,po2) -> Integer.compare(po1.getAge(), po2.getAge()));
        System.out.println(lambda_person);
        System.out.println("Sort by Method Comparator");
        List<Person> method_person = Arrays.asList(
            p1,p2,p3
        );
        method_person.sort(Comparator.comparing(Person::getAge));
        System.out.println(method_person);

        System.out.println("Multple Criteria");
        List<Person> list_people = Arrays.asList(
            new Person("Alice", 30),
            new Person("Bob", 25),
            new Person("Charlie", 35),
            new Person("Bob", 20)
        );
        list_people.sort(Comparator.comparing(Person::getName)
                            .thenComparing(Person::getAge));
        System.out.println(list_people);


        


    }
    
}
