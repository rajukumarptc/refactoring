package com.codingpractise;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
    private String _name;
    private Vector _rentals = new Vector();

    public Customer(String name) {
        _name = name;
    }

    public void addRental(Rental arg) {
        _rentals.addElement(arg);
    }

    public String getName() {
        return _name;
    }

    public String statement() {
        Enumeration rentals = _rentals.elements();
        String result = "Rental Record for " + getName() + "\n";
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            //show figures for this rental
            result += "\t" + each._movie.getMovie().getTitle()+ "\t" + String.valueOf(each.getCharge()) + "\n";
        }
        //add footer lines
        result += "Amount owed is " + String.valueOf(getTotalAmount()) + "\n";
        result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter points";
        return result;
    }

    private int getTotalFrequentRenterPoints() {
        int points = 0;
        Enumeration rentals = _rentals.elements();
        while (rentals.hasMoreElements()){
            Rental each = (Rental) rentals.nextElement();
            points += each.getFrequentRenterPoints();
        }
        return points;
    }

    private double getTotalAmount() {
        double totalAmount = 0;
        Enumeration rentals = _rentals.elements();
        while (rentals.hasMoreElements()){
            Rental each = (Rental) rentals.nextElement();
            totalAmount += each.getCharge();
        }
        return totalAmount;
    }


}