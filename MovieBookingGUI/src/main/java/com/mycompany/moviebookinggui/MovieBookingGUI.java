/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.moviebookinggui;

/**
 *
 * @author emeris
 */
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MovieBookingGUI extends JFrame {

    // Movie collection
    private ArrayList<Movie> movies;

    // GUI components
    private JTextField titleField;
    private JTextField genreField;
    private JTextField priceField;
    private JTextField customerField;

    private DefaultListModel<Movie> movieListModel;
    private JList<Movie> movieList;

    private JTextArea confirmationArea;

    // Constructor
    public MovieBookingGUI() {

        movies = new ArrayList<>();

        setTitle("Movie Booking System");
        setSize(650, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Main panel
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        );

        // =========================
        // MOVIE DETAILS
        // =========================

        JPanel moviePanel = new JPanel(new GridLayout(4, 2, 5, 5));

        moviePanel.setBorder(
                BorderFactory.createTitledBorder("Add Movie")
        );

        moviePanel.add(new JLabel("Movie Title:"));
        titleField = new JTextField();
        moviePanel.add(titleField);

        moviePanel.add(new JLabel("Genre:"));
        genreField = new JTextField();
        moviePanel.add(genreField);

        moviePanel.add(new JLabel("Ticket Price:"));
        priceField = new JTextField();
        moviePanel.add(priceField);

        JButton addMovieButton = new JButton("Add Movie");
        moviePanel.add(addMovieButton);

        mainPanel.add(moviePanel, BorderLayout.NORTH);

        // =========================
        // MOVIE LIST
        // =========================

        movieListModel = new DefaultListModel<>();

        movieList = new JList<>(movieListModel);

        movieList.setSelectionMode(
                ListSelectionModel.SINGLE_SELECTION
        );

        JScrollPane movieScrollPane =
                new JScrollPane(movieList);

        movieScrollPane.setBorder(
                BorderFactory.createTitledBorder(
                        "Available Movies"
                )
        );

        mainPanel.add(movieScrollPane, BorderLayout.CENTER);

        // =========================
        // BOOKING SECTION
        // =========================

        JPanel bookingPanel = new JPanel(
                new BorderLayout(5, 5)
        );

        bookingPanel.setBorder(
                BorderFactory.createTitledBorder("Book Movie")
        );

        JPanel customerPanel =
                new JPanel(new FlowLayout(FlowLayout.LEFT));

        customerPanel.add(
                new JLabel("Customer Name:")
        );

        customerField = new JTextField(15);
        customerPanel.add(customerField);

        JButton bookMovieButton =
                new JButton("Book Movie");

        customerPanel.add(bookMovieButton);

        bookingPanel.add(
                customerPanel,
                BorderLayout.NORTH
        );

        // Confirmation area
        confirmationArea = new JTextArea(8, 40);
        confirmationArea.setEditable(false);

        JScrollPane confirmationScrollPane =
                new JScrollPane(confirmationArea);

        confirmationScrollPane.setBorder(
                BorderFactory.createTitledBorder(
                        "Booking Confirmation"
                )
        );

        bookingPanel.add(
                confirmationScrollPane,
                BorderLayout.CENTER
        );

        mainPanel.add(
                bookingPanel,
                BorderLayout.SOUTH
        );

        // =========================
        // ADD MOVIE BUTTON
        // =========================

        addMovieButton.addActionListener(e -> addMovie());

        // =========================
        // BOOK MOVIE BUTTON
        // =========================

        bookMovieButton.addActionListener(e -> bookMovie());

        add(mainPanel);
    }

    // Method to add a movie
    private void addMovie() {

        String title = titleField.getText().trim();
        String genre = genreField.getText().trim();
        String priceText = priceField.getText().trim();

        // Conditional statement
        if (title.isEmpty()
                || genre.isEmpty()
                || priceText.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter all movie details."
            );

            return;
        }

        try {

            double price = Double.parseDouble(priceText);

            if (price <= 0) {

                JOptionPane.showMessageDialog(
                        this,
                        "Ticket price must be greater than 0."
                );

                return;
            }

            Movie movie =
                    new Movie(title, genre, price);

            movies.add(movie);
            movieListModel.addElement(movie);

            // Clear fields
            titleField.setText("");
            genreField.setText("");
            priceField.setText("");

            JOptionPane.showMessageDialog(
                    this,
                    "Movie added successfully!"
            );

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter a valid ticket price."
            );
        }
    }

    // Method to book a movie
    private void bookMovie() {

        String customerName =
                customerField.getText().trim();

        Movie selectedMovie =
                movieList.getSelectedValue();

        // Conditional statements
        if (customerName.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter the customer name."
            );

            return;
        }

        if (selectedMovie == null) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please select a movie."
            );

            return;
        }

        // Create booking object
        Booking booking =
                new Booking(customerName, selectedMovie);

        // Display confirmation
        confirmationArea.setText(
                booking.getBookingDetails()
        );

        customerField.setText("");
    }
}

