import java.util.ArrayList;
import java.util.List;

class Person {
    private String name;
    private List<Person> children;

    public Person(String name, int birthYear, String gender) {
        this.name = name;
        this.children = new ArrayList<>();
    }

    public void addChild(Person child) {
        children.add(child);
    }

    public List<Person> getChildren() {
        return children;
    }

    public String getName() {
        return name;
    }

    public String getBirthYear() {
        return null;
    }
}

class GenealogyTree {
    private List<Person> people;

    public GenealogyTree() {
        people = new ArrayList<>();
    }

    public void addPerson(Person person) {
        people.add(person);
    }

    public List<Person> findChildren(String personName) {
        for (Person person : people) {
            if (person.getName().equals(personName)) {
                return person.getChildren();
            }
        }
        return null;
    }
}

public class main {
    public static void main(String[] args) {
        GenealogyTree tree = new GenealogyTree();

        // Добавляем людей в древо
        Person person1 = new Person("Иван", 1950, "М");
        Person person2 = new Person("Мария", 1955, "Ж");
        Person person3 = new Person("Алексей", 1980, "М");
        Person person4 = new Person("Елена", 1985, "Ж");

        // Связываем родителей с детьми
        person1.addChild(person3);
        person2.addChild(person3);
        person2.addChild(person4);

        // Добавляем людей в генеалогическое древо
        tree.addPerson(person1);
        tree.addPerson(person2);
        tree.addPerson(person3);
        tree.addPerson(person4);

        // Поиск детей выбранного человека
        String selectedPersonName = "Мария";
        List<Person> children = tree.findChildren(selectedPersonName);

        if (children != null) {
            System.out.println("Дети " + selectedPersonName + ":");
            for (Person child : children) {
                System.out.println(child.getName() + " (" + child.getBirthYear() + ")");
            }
        } else {
            System.out.println("Дети " + selectedPersonName + " не найдены.");
        }
    }
}