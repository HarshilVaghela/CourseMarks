package courseMarks;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * Write a description of class Prereqs here.
 *
 * @author (Harshilkumar Vaghela, 3116318)
 * @date (April 6, 2020, Assignment-4)
 */
public class Prereqs
{
    public static void main(String[] args){
        Course prog1= new Course("ACS-1903","Programming Fundamentals I",null);
        Course prog2=new Course("ACS-1904","Programming Fundamentals II",prog1);
        Course data=new Course("ACS-2947","Data Structures and Algorithms",prog2);
        Course alg=new Course("ACS-3947","Algorithm Design",data);
        Course inter=new Course("ACS-2909","Internet Programming",prog1);
        Course adv=new Course("ACS-3909","Advanced Internet Programming",inter);
        ArrayList <Course> courses=new ArrayList<>();
        courses.add(prog1);
        courses.add(prog2);
        courses.add(data);
        courses.add(alg);
        courses.add(inter);
        courses.add(adv);
        System.out.println("Enter Course number: ");
        Scanner kb=new Scanner(System.in);
        boolean answer=true;
        String input=kb.next();
        String input2="";
        while(answer){
            try{
                input2=validate(input);
                answer=false;
            }
            catch (IllegalArgumentException e){
                answer=true;System.out.println("Invalid course number, please try again");
                input=kb.next();
            }
        }
        boolean k=false;
        for(Course f:courses){
            if (input2.equals(f.getCnum())){
                printCourse(f);k=k||input2.equals(f.getCnum());
            }
        }
        if(!k){
            System.out.println("There isn't such course having this course number.");
        }
    }

    public static String validate(String input){
        boolean d = input.length()==8; 
        if (!d){ 
            throw new IllegalArgumentException("Wrong length!");
        }
        d = input.charAt(3)=='-' ;
        if (!d){ 
            throw new IllegalArgumentException("Dash not in expected place!");
        }
        for (int i=0; i<3 && d; i++){
            d = (Character.isLetter(input.charAt(i)));
            if (!d){
                throw new IllegalArgumentException("Course department aren't written as letters!");
            }
        }
        
        for (int i=4; i<input.length() && d; i++){
            d = (Character.isDigit(input.charAt(i)));
            if (!d){
                throw new IllegalArgumentException("Course number isn't integer!");
            }
        }
        return input;
    }

    public static void printCourse(Course c){
        if(c.getPrereq()!=null){
            System.out.print(c+"\n\tprereq: "+c.getPrereq().getCnum()+" "+c.getPrereq().getCname()+"\n");
            printCourse(c.getPrereq());
        }
        else{
            System.out.print(c+"\n\tno prereq");
        }
    }
}
