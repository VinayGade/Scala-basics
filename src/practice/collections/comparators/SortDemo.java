package practice.collections.comparators;

import java.util.*;

class Student{
    private int id;
    private String fname;
    private double cgpa;
    public Student(int id, String fname, double cgpa) {
        super();
        this.id = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }
    public int getId() {
        return id;
    }
    public String getFname() {
        return fname;
    }
    public double getCgpa() {
        return cgpa;
    }
}

public class SortDemo {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());

        List<Student> studentList = new ArrayList<Student>();
        while(testCases>0){
            int id = in.nextInt();
            String fname = in.next();
            double cgpa = in.nextDouble();

            Student st = new Student(id, fname, cgpa);
            studentList.add(st);

            testCases--;
        }

        Collections.sort(studentList, (o1, o2) ->
                (o1.getCgpa() == o2.getCgpa()) ?
                        ((o1.getFname().compareTo(o2.getFname()) == 0)?
                                ( o1.getId()<o2.getId() ? 1: -1 ):
                        (o1.getFname().compareTo(o2.getFname()))):
                        (o1.getCgpa() < o2.getCgpa() ? 1 : -1));

        for(Student st: studentList){
            System.out.println(st.getFname());
        }
    }
}
