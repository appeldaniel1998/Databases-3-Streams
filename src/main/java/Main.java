import javafx.util.Pair;

import java.util.*;

/**
 * Created by Avigail on 5/20/2017.
 */
public class Main {
    public static void main(String[] args) {
        List<Course> courses = new LinkedList<Course>() {{
            add(new Course(30, "Data Structures", 3.5f));
            add(new Course(32, "Geometry", 6));
            add(new Course(35, "Algebra", 2.5f));
            add(new Course(37, "English", 7));
        }};

        List<Student> students = new LinkedList<Student>() {{
            add(
                    new Student("Moshe", 21, 1, new LinkedList<Grade>() {{
                        add(new Grade(courses.stream().filter(c -> c.getId() == 30).findFirst().get(), 67));
                        add(new Grade(courses.stream().filter(c -> c.getId() == 32).findFirst().get(), 89));
                        add(new Grade(courses.stream().filter(c -> c.getId() == 35).findFirst().get(), 67));
                        add(new Grade(courses.stream().filter(c -> c.getId() == 37).findFirst().get(), 89));
                    }})
            );
            add(
                    new Student("Yossi", 26, 2, new LinkedList<Grade>() {{
                        add(new Grade(courses.stream().filter(c -> c.getId() == 30).findFirst().get(), 100));
                        add(new Grade(courses.stream().filter(c -> c.getId() == 32).findFirst().get(), 67));
                        add(new Grade(courses.stream().filter(c -> c.getId() == 35).findFirst().get(), 89));
                    }})
            );
            add(
                    new Student("Natasha", 30, 3, new LinkedList<Grade>() {{
                        add(new Grade(courses.stream().filter(c -> c.getId() == 30).findFirst().get(), 67));
                        add(new Grade(courses.stream().filter(c -> c.getId() == 37).findFirst().get(), 80));

                    }})
            );
        }};

        printStudentInfo(students);

/*Grisha
        students.stream().forEach (s-> System.out.println("ha"));
        students.stream().forEach (s-> s.getGrades().stream().forEach((g) -> System.out.println(g.getValue())));
        System.out.println("\n===============\n");
*/

        //students.stream().forEach(s-> System.out.println(s.getName()+", "+s.getGrades().stream().forEach(grade->grade.getValue())));
        //collectors.summarizingdouble
    }

    public static void printStudentInfo(List<Student> students)
    {
        students.stream().forEach (s-> System.out.println(s.getName()+": "+ s.getGrades().stream().mapToDouble(g-> g.getValue()).average().getAsDouble()));

        //sources:
        //https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html
        //https://www.baeldung.com/java-array-sum-average
    }
}



// filter by course name, su and average per course per student