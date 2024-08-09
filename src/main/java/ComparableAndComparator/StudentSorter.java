package ComparableAndComparator;

import java.util.Comparator;

public class StudentSorter implements Comparator<Student> {
    public int compare(Student s1, Student s2) {
         if(s1.getPsp() - s2.getPsp() <0){
            return -1;
        }else{
             return 1;
         }
    }
}
