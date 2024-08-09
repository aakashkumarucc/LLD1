package ComparableAndComparator;

public class Student implements Comparable<Student>{

    private String name;
    private int age;
    private float psp;
    public Student(String name, int age, float psp) {
        this.name = name;
        this.age = age;
        this.psp = psp;
    }
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
    public float getPsp() {
        return psp;
    }
    public void setPsp(float psp) {
        this.psp = psp;
    }
    public int compareTo(Student o) {
        return this.age - o.age;
        //Negative implies = less than
        //Postive imples = greater than

    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", psp=" + psp +
                '}';
    }
}
