/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.moviebookingsystem;

/**
 *
 * @author emeris
 */
public class Booking {
    private Customer customer;
    private Movie movie;
    private int numberOfTickets;
    private double totalCost;

    public Booking(Customer customer, Movie movie, int numberOfTickets) {
        this.customer = customer;
        this.movie = movie;
        this.numberOfTickets = numberOfTickets;
        this.totalCost = movie.getPrice() * numberOfTickets;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Movie getMovie() {
        return movie;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void displayBooking() {
        System.out.println("Customer: " + customer.getName());
        System.out.println("Movie: " + movie.getTitle());
        System.out.println("Tickets: " + numberOfTickets);
        System.out.println("Total Cost: R" + totalCost);
        System.out.println("----------------------");
    }
}
