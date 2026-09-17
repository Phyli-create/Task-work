/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.moviebookinggui;

/**
 *
 * @author emeris
 */
public class Booking {

    private String customerName;
    private Movie movie;

    // Constructor
    public Booking(String customerName, Movie movie) {
        this.customerName = customerName;
        this.movie = movie;
    }

    // Getters
    public String getCustomerName() {
        return customerName;
    }

    public Movie getMovie() {
        return movie;
    }

    // Booking confirmation
    public String getBookingDetails() {
        return "===== BOOKING CONFIRMATION =====\n"
                + "Customer: " + customerName + "\n"
                + "Movie: " + movie.getTitle() + "\n"
                + "Genre: " + movie.getGenre() + "\n"
                + "Ticket Price: R" + movie.getPrice() + "\n"
                + "Booking successful!";
    }
}
