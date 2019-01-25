package com.codingpractise;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.Suite;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class CustomerTest {
    Movie regularMovie1 = new Movie("Jurassic park", 0);
    Movie regularMovie2 = new Movie("Black", 0);
    Movie childrenMovie1 = new Movie("Home Alone", 2);
    Movie childrenMovie2 = new Movie("Tom n jerry", 2);
    Movie newReleaseMovie1 = new Movie("Manikarnika", 1);
    Movie newReleaseMovie2 = new Movie("Luka Chhipi", 1);


    @Test
    public void testStatementForRegularMovieOnly() {
        Customer customer = new Customer("rahil");
        customer.addRental(new Rental(regularMovie1, 2));
        customer.addRental(new Rental(regularMovie2, 5));

        String expectedStatement = "Rental Record for rahil\n" +
                "\tJurassic park\t2.0\n" +
                "\tBlack\t6.5\n" +
                "Amount owed is 8.5\n" +
                "You earned 2 frequent renter points";
        String actualStatement = customer.statement() ;
        assertEquals(actualStatement, expectedStatement);

    }

    @Test
    public void testStatementForChilrenMovieOnly() {
        Customer customer = new Customer("rahil");
        customer.addRental(new Rental(childrenMovie1, 2));
        customer.addRental(new Rental(childrenMovie2, 5));

        String expectedStatement = "Rental Record for rahil\n" +
                "\t"+ childrenMovie1.getTitle() + "\t1.5\n" +
                "\t"+ childrenMovie2.getTitle() + "\t4.5\n" +
                "Amount owed is 6.0\n" +
                "You earned 2 frequent renter points";
        String actualStatement = customer.statement() ;
        assertEquals(actualStatement, expectedStatement);

    }

    @Test
    public void testStatementForNewReleaseMovieOnly() {
        Customer customer = new Customer("rahil");
        customer.addRental(new Rental(newReleaseMovie1, 7));
        customer.addRental(new Rental(newReleaseMovie2, 5));

        String expectedStatement = "Rental Record for rahil\n" +
                "\t"+ newReleaseMovie1.getTitle() + "\t21.0\n" +
                "\t"+ newReleaseMovie2.getTitle() + "\t15.0\n" +
                "Amount owed is 36.0\n" +
                "You earned 4 frequent renter points";
        String actualStatement = customer.statement() ;
        assertEquals(actualStatement, expectedStatement);

    }

    @Test
    public void testStatementForMixMovies() {
        Customer customer = new Customer("rahil");
        customer.addRental(new Rental(newReleaseMovie1, 7));
        customer.addRental(new Rental(regularMovie1, 5));
        customer.addRental(new Rental(childrenMovie2, 5));

        String expectedStatement = "Rental Record for rahil\n" +
                "\t"+ newReleaseMovie1.getTitle() + "\t21.0\n" +
                "\t"+ regularMovie1.getTitle() + "\t6.5\n" +
                "\t"+ childrenMovie2.getTitle() + "\t4.5\n" +
                "Amount owed is 32.0\n" +
                "You earned 4 frequent renter points";
        String actualStatement = customer.statement() ;
        assertEquals(actualStatement, expectedStatement);

    }

}