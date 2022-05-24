package courseMarks;


/**
 * Write a description of class Student here.
 *
 * @author (Harshilkumar Vaghela, 3116318)
 * @date (April 6, 2020, Assignment-4)
 */
public class Student implements Comparable<Student>
{
    private String name;
    private int studentNumber;
    private double finalMark;
    public Student(String n,int s,double f){
        name=n;
        studentNumber=s;
        finalMark=f;
    }

    public Student(){
        this("unknown",0,0);
    }

    public String getName(){
        return name;
    }

    public String getGrade(){
        String m="";
        if(finalMark<=100){
            m=(finalMark>=90? "A+":finalMark>=85?"A":finalMark>=80?"A-":finalMark>=75?"B+":finalMark>=70?"B":finalMark>=65?"C+":
                finalMark>=60?"C":finalMark>=50?"D":"F");
        }
        return m;
    }

    public double getFinalMark(){
        return finalMark;
    }

    public int compareTo(Student s){
        return name.compareTo(s.name);
    }

    public String toString(){
        return name+"\t"+studentNumber+"\t"+finalMark+"\t"+getGrade();
    }

}
