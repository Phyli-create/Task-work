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
import java.util.Scanner;

public class MovieBookingSystem implements Bookable {

    private ArrayList<Movie> movies;
    private ArrayList<Customer> customers;
    private ArrayList<Booking> bookings;

    private Scanner scanner;

    public MovieBookingSystem() {
        movies = new ArrayList<>();
        customers = new ArrayList<>();
        bookings = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    // Add a movie
    public void addMovie() {
        System.out.print("Enter movie ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter movie title: ");
        String title = scanner.nextLine();

        System.out.print("Enter movie price: R");
        double price = scanner.nextDouble();

        Movie movie = new Movie(id, title, price);
        movies.add(movie);

        System.out.println("Movie added successfully!");
    }

    // Display movies
    public void displayMovies() {
        if (movies.isEmpty()) {
            System.out.println("No movies available.");
        } else {
            System.out.println("\n===== AVAILABLE MOVIES =====");

            for (Movie movie : movies) {
                movie.displayMovie();
            }
        }
    }

    // Register customer
    public void registerCustomer() {
        System.out.print("Enter customer ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();

        Customer customer = new Customer(id, name);
        customers.add(customer);

        System.out.println("Customer registered successfully!");
    }

    // Book a movie
    @Override
    public void bookMovie(Customer customer, Movie movie) {
        System.out.print("Enter number of tickets: ");
        int tickets = scanner.nextInt();

        if (tickets > 0) {
            Booking booking = new Booking(customer, movie, tickets);

            bookings.add(booking);
            customer.addBooking(booking);

            System.out.println("Movie booked successfully!");
            System.out.println("Total cost: R" + booking.getTotalCost());
        } else {
            System.out.println("Number of tickets must be greater than 0.");
        }
    }

    // Allow customer to make booking
    public void makeBooking() {

        if (customers.isEmpty()) {
            System.out.println("Please register a customer first.");
            return;
        }

        if (movies.isEmpty()) {
            System.out.println("Please add a movie first.");
            return;
        }

        System.out.print("Enter customer ID: ");
        int customerId = scanner.nextInt();

        Customer selectedCustomer = null;

        for (Customer customer : customers) {
            if (customer.getCustomerId() == customerId) {
                selectedCustomer = customer;
                break;
            }
        }

        if (selectedCustomer == null) {
            System.out.println("Customer not found.");
            return;
        }

        displayMovies();

        System.out.print("Enter movie ID: ");
        int movieId = scanner.nextInt();

        Movie selectedMovie = null;

        for (Movie movie : movies) {
            if (movie.getMovieId() == movieId) {
                selectedMovie = movie;
                break;
            }
        }

        if (selectedMovie == null) {
            System.out.println("Movie not found.");
            return;
        }

        bookMovie(selectedCustomer, selectedMovie);
    }

    // Display all bookings
    public void displayBookings() {

        if (bookings.isEmpty()) {
            System.out.println("No bookings available.");
        } else {
            System.out.println("\n===== ALL BOOKINGS =====");

            for (Booking booking : bookings) {
                booking.displayBooking();
            }
        }
    }

    // Calculate customer's total cost
    public void calculateCustomerCost() {

        System.out.print("Enter customer ID: ");
        int customerId = scanner.nextInt();

        Customer selectedCustomer = null;

        for (Customer customer : customers) {
            if (customer.getCustomerId() == customerId) {
                selectedCustomer = customer;
                break;
            }
        }

        if (selectedCustomer == null) {
            System.out.println("Customer not found.");
            return;
        }

        double total = 0;

        for (Booking booking : selectedCustomer.getBookings()) {
            total += booking.getTotalCost();
        }

        System.out.println("Customer: " + selectedCustomer.getName());
        System.out.println("Total booking cost: R" + total);
    }

    // Main menu
    public void run() {

        int choice;

        do {
            System.out.println("\n===== MOVIE BOOKING SYSTEM =====");
            System.out.println("1. Add Movie");
            System.out.println("2. Display Movies");
            System.out.println("3. Register Customer");
            System.out.println("4. Book Movie");
            System.out.println("5. Display All Bookings");
            System.out.println("6. Calculate Customer Total");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    addMovie();
                    break;

                case 2:
                    displayMovies();
                    break;

                case 3:
                    registerCustomer();
                    break;

                case 4:
                    makeBooking();
                    break;

                case 5:
                    displayBookings();
                    break;

                case 6:
                    calculateCustomerCost();
                    break;

                case 7:
                    System.out.println("Thank you for using the Movie Booking System!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 7);
    }

    public static void main(String[] args) {

        MovieBookingSystem system = new MovieBookingSystem();

        system.run();
    }
}