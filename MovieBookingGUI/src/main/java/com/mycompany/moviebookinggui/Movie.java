/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.moviebookinggui;

/**
 *
 * @author emeris
 */
public class Movie {

    private String title;
    private String genre;
    private double price;

    // Constructor
    public Movie(String title, String genre, double price) {
        this.title = title;
        this.genre = genre;
        this.price = price;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public double getPrice() {
        return price;
    }

    // Display movie information
    @Override
    public String toString() {
        return title + " | " + genre + " | R" + price;
    }
}

