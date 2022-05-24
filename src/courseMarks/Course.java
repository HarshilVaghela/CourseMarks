package courseMarks;


/**
 * Write a description of class Course here.
 *
 * @author (Harshilkumar Vaghela, 3116318)
 * @date (April 6, 2020, Assignment-4)
 */
public class Course
{
    private String courseNumber;
    private String courseName;
    private Course preRequisite;
    public Course(String cNum,String cName,Course p){
        courseNumber=cNum;
        courseName=cName;
        preRequisite=p;
    }

    public Course(){
        this("unknown","unknown",null);
    }

    public String getCnum(){
        return courseNumber;
    }

    public Course getPrereq(){
        return preRequisite;
    }

    public String getCname(){
        return courseName;
    }

    public String toString(){
        return courseNumber+" "+courseName;
    }
}
