/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.moviebookingsystem;

/**
 *
 * @author emeris
 */
public class Movie {
    private int movieId;
    private String title;
    private double price;

    public Movie(int movieId, String title, double price) {
        this.movieId = movieId;
        this.title = title;
        this.price = price;
    }

    public int getMovieId() {
        return movieId;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void displayMovie() {
        System.out.println("Movie ID: " + movieId);
        System.out.println("Title: " + title);
        System.out.println("Price: R" + price);
        System.out.println("----------------------");
    }
}
