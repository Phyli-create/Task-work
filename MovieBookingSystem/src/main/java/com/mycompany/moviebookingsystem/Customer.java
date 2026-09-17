/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.moviebookingsystem;

/**
 *
 * @author emeris
 */
import java.util.ArrayList;

public class Customer extends Person {
    private int customerId;
    private ArrayList<Booking> bookings;

    public Customer(int customerId, String name) {
        super(name);
        this.customerId = customerId;
        this.bookings = new ArrayList<>();
    }

    public int getCustomerId() {
        return customerId;
    }

    public ArrayList<Booking> getBookings() {
        return bookings;
    }

    public void addBooking(Booking booking) {
        bookings.add(booking);
    }

}
