import java.io.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class Main {
    public static void main(String[] args) {
        // Создаем список из пяти студентов
        Student[] students = new Student[]{
                new Student("Клинт Капелла", 20, 3.5),
                new Student("П.Джэй Таккер", 22, 3.9),
                new Student("Дэмиан Лилард", 21, 3.7),
                new Student("Крис Браун", 19, 3.2),
                new Student("Джон Харт", 23, 4.0)
        };

        // Сериализуем список в файл в формате JSON
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(new File("students.json"), students);
            System.out.println("Objects serialized to JSON successfully.");
        } catch (IOException e) {
            System.err.println("Error serializing objects to JSON: " + e.getMessage());
        }

        // Десериализуем список из файла JSON
        try {
            ObjectMapper mapper = new ObjectMapper();
            Student[] deserializedStudents = mapper.readValue(new File("students.json"), Student[].class);
            System.out.println("Deserialized student objects:");
            for (Student student : deserializedStudents) {
                System.out.println(student);
            }
        } catch (IOException e) {
            System.err.println("Error deserializing objects from JSON: " + e.getMessage());
        }

        // Сериализуем список в файл в формате XML
        try {
            XmlMapper xmlMapper = new XmlMapper();
            xmlMapper.writeValue(new File("students.xml"), students);
            System.out.println("Objects serialized to XML successfully.");
        } catch (IOException e) {
            System.err.println("Error serializing objects to XML: " + e.getMessage());
        }

        // Десериализуем список из файла XML
        try {
            XmlMapper xmlMapper = new XmlMapper();
            Student[] deserializedStudents = xmlMapper.readValue(new File("students.xml"), Student[].class);
            System.out.println("Deserialized student objects:");
            for (Student student : deserializedStudents) {
                System.out.println(student);
            }
        } catch (IOException e) {
            System.err.println("Error deserializing objects from XML: " + e.getMessage());
        }
    }
}

class Student implements Serializable {
    private String name;
    private int age;
    private transient double GPA;

    public Student() {
    }

    public Student(String name, int age, double GPA) {
        this.name = name;
        this.age = age;
        this.GPA = GPA;
    }

    // Геттеры и сеттеры для полей
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", GPA=" + GPA +
                '}';
    }
}
