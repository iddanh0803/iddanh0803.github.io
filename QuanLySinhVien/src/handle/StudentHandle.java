package handle;

import entity.Student;

import java.util.Scanner;

public class StudentHandle {
    public Student createStudent(Scanner scanner, int i){
        System.out.println("Id: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Name: ");
        String name = scanner.nextLine();
        System.out.println("ScoreMath: ");
        double scoreMath = Double.parseDouble(scanner.nextLine());
        System.out.println("ScorePhysic: ");
        double scorePhysic = Double.parseDouble(scanner.nextLine());
        System.out.println("ScoreChemistry: ");
        double scoreChemistry =Double.parseDouble(scanner.nextLine());
        Student student = new Student(name,scoreMath,scorePhysic,scoreChemistry);
        return student;
    }
    public double avgScore(Student student){
        return (student.getScoreMath() + student.getScorePhysic() + student.getScoreChemistry())/3;
    }
    public String rating(double avg) {
        String rating = " ";
        if (avg >= 8) {
            rating = "Xếp loại A";
        } else if (avg < 8 && avg >= 6.5) {
            rating = "Xếp loại B";
        } else {
            rating = "Xếp loại C";
        }
        return rating ;
    }
    public void dislayStudent(Student[] students){
        for (Student student1:students){

        System.out.println(student1);
        System.out.println(avgScore(student1));
        System.out.println(rating(avgScore(student1)));
        }
    }
    public void getPercent(Student[] students){
        double countA = 0;
        double countB = 0;
        double countC = 0;
        for (int i = 0; i < students.length; i++) {
            if (avgScore(students[i]) >= 8){
                countA++;
            }else if (avgScore(students[i])<8 && avgScore(students[i]) >= 6.5){
                countB++;
            }else {
                countC++;
            }
        }
        System.out.println("Loại A chiếm: " + (countA/students.length)*100+"%");
        System.out.println("Loại B chiếm: " + (countB/students.length)*100+"%");
        System.out.println("Loại C chiếm: " + (countC/students.length)*100+"%");
    }
}
