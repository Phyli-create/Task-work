/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.studentrecordsystem;

/**
 *
 * @author emeris
 */

public class Student {

    private String studentID;
    private String name;
    private String course;
    private int year;
    private double mark;

    public Student(String studentID, String name, String course, int year, double mark) {
        this.studentID = studentID;
        this.name = name;
        this.course = course;
        this.year = year;
        this.mark = mark;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }

    public int getYear() {
        return year;
    }

    public double getMark() {
        return mark;
    }

    public boolean hasPassed() {
        return mark >= 50;
    }

    @Override
    public String toString() {
        return studentID + " | " + name + " | "
                + course + " | Year " + year
                + " | Mark: " + mark;
    }
}