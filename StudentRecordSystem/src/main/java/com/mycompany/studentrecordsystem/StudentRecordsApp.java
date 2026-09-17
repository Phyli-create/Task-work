/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.studentrecordsystem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentRecordsApp {

    static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {

        loadStudents();

        Scanner input = new Scanner(System.in);

        int choice;

        do {
            System.out.println("\n===== STUDENT RECORD SYSTEM =====");
            System.out.println("1. Display all students");
            System.out.println("2. Search student");
            System.out.println("3. Display students by course");
            System.out.println("4. Display passed students");
            System.out.println("5. Display statistics");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = input.nextInt();
            input.nextLine();

            switch (choice) {

                case 1:
                    displayAllStudents();
                    break;

                case 2:
                    searchStudent(input);
                    break;

                case 3:
                    displayByCourse(input);
                    break;

                case 4:
                    displayPassedStudents();
                    break;

                case 5:
                    displayStatistics();
                    break;

                case 6:
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 6);

        input.close();
    }

    // Load students from CSV file
    public static void loadStudents() {

        try {

            BufferedReader reader =
                    new BufferedReader(new FileReader("Readme.txt"));

            String line;

            // Skip header
            reader.readLine();

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                if (data.length >= 5) {

                    String studentID = data[0];
                    String name = data[1];
                    String course = data[2];
                    int year = Integer.parseInt(data[3]);
                    int mark = Integer.parseInt(data[4]);

                    Student student =
                            new Student(studentID, name, course, year, mark);

                    students.add(student);
                }
            }

            reader.close();

            System.out.println(
                    students.size()
                    + " student records loaded successfully."
            );

        } catch (IOException | NumberFormatException e) {

            System.out.println("Error loading student records: "
                    + e.getMessage());
        }
    }

    // CASE 1
    public static void displayAllStudents() {

        System.out.println("\n===== ALL STUDENTS =====");

        for (Student student : students) {
            System.out.println(student);
        }
    }

    // CASE 2
    public static void searchStudent(Scanner input) {

        System.out.print("Enter Student ID: ");
        String id = input.nextLine();

        boolean found = false;

        for (Student student : students) {

            if (student.getStudentID().equalsIgnoreCase(id)) {

                System.out.println(student);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student not found.");
        }
    }

    // CASE 3
    public static void displayByCourse(Scanner input) {

        System.out.print("Enter course: ");
        String course = input.nextLine();

        boolean found = false;

        for (Student student : students) {

            if (student.getCourse().equalsIgnoreCase(course)) {

                System.out.println(student);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No students found for this course.");
        }
    }

    // CASE 4
    public static void displayPassedStudents() {

        System.out.println("\n===== PASSED STUDENTS =====");

        for (Student student : students) {

            if (student.getMark() >= 50) {
                System.out.println(student);
            }
        }
    }

    // CASE 5
    public static void displayStatistics() {

        if (students.isEmpty()) {

            System.out.println("No student records available.");
            return;
        }

        int total = 0;

        for (Student student : students) {
            total += student.getMark();
        }

        double average = (double) total / students.size();

        System.out.println("\n===== STATISTICS =====");
        System.out.println("Number of students: " + students.size());
        System.out.println("Average mark: " + average);
    }
}