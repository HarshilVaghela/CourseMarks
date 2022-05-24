package courseMarks;

import java.util.Arrays;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
/**
 * Write a description of class CourseMarks2 here.
 *
 * @author (Harshilkumar Vaghela, 3116318)
 * @date (April 6, 2020, Assignment-4)
 */
public class CourseMarks2
{
    public static void main(String [] args) throws FileNotFoundException{
        boolean k=false;
        Scanner kb=new Scanner(System.in);
        Student[] students=new Student[6];
        System.out.println("Enter File name(test/A4.txt)");
        String fileName=kb.next();
        String fileName2="";
        while(!k){
            try{
                Scanner file=new Scanner(new File(fileName));
                System.out.println("File found");
                k=true;
                fileName2=fileName;
            }
            catch(FileNotFoundException e){
                System.out.println("Error, file not found enter new File Name");
                fileName=kb.next();
            }
        }
        Scanner file=new Scanner(new File(fileName2));
        int count=0;
        while(file.hasNext()){            
            String line=file.nextLine();
            Scanner lineScanner=new Scanner(line).useDelimiter(" ");
            students[count]=new Student(lineScanner.next(),lineScanner.nextInt(),lineScanner.nextDouble());count++;
        }
        System.out.println("How would you like to see the student list?\nA. By final mark from highest to lowest");
        System.out.println("B.In alphabetic order\nC.Quit the program.");
        String input2=kb.next().toUpperCase();boolean b=false;
        while(!b){
            b=true;
            switch(input2){
                case"A":quickSortForObjects(students,0,5);
                break;
                case "B":bubbleSortForObjects(students);
                break;
                case "C":System.out.println("The program has ended.");
                break;
                default:System.out.println("The input is invalid. Please enter valid option.");
                b=false;
                input2=kb.next().toUpperCase();
                break;
            }
        }
        if(input2.equals("A")||input2.equals("B")){
            System.out.println("Student\t#\tMark\tGrade");
            for(Student s:students){
                System.out.println(s);
            }
        }
    }

    public static void quickSortForObjects(Student[] a, int start, int end){ OrderByFinalMark k=new OrderByFinalMark();     
        if (start >= end) return;
        Student pivot = a[start];
        int left = start;
        int right = end;
        while (left < right){
            while (right > left && k.compare(a[right],pivot)>0){
                right--;
            }
            if(left==right) break;
            a[left]=a[right];
            left++;
            while (right > left && k.compare(a[left],pivot)<0){
                left++;
            }
            if(left == right) break;
            a[right]=a[left];
            right--;
        }
        a[right]=pivot;
        quickSortForObjects(a, start,   right-1);
        quickSortForObjects(a, right+1, end    );
    }

    public static void bubbleSortForObjects(Student[] a){
        int n = a.length;
        for (int i=0; i<n-1; i++) {
            for (int j=0; j<n-i-1; j++){
                if (a[j].compareTo(a[j+1])>0) {
                    Student temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
    }
}
