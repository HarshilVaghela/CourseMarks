package courseMarks;

import java.util.Comparator;
/**
 * Write a description of class StudentRegistration here.
 *
 * @author (Harshilkumar Vaghela, 3116318)
 * @date (April 6, 2020, Assignment-4)
 */
public class OrderByFinalMark implements Comparator<Student>
{
 public int compare(Student s1,Student s2){
    return (s2.getFinalMark()-s1.getFinalMark()>0?+1:s2.getFinalMark()-s1.getFinalMark()<0?-1:0);
    }  
}
