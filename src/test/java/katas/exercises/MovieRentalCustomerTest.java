package katas.exercises;

import katas.exercises.movieRental.Rental;
import katas.exercises.movieRental.Movie;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MovieRentalCustomerTest {

    @Test
    public void testBasicStatement() {
        MovieRentalCustomer customer = new MovieRentalCustomer("Bob");
        customer.addRental(new Rental(new Movie("Jaws", Movie.REGULAR), 2));
        customer.addRental(new Rental(new Movie("Golden Eye", Movie.REGULAR), 3));
        customer.addRental(new Rental(new Movie("Short New", Movie.NEW_RELEASE), 1));
        customer.addRental(new Rental(new Movie("Long New", Movie.NEW_RELEASE), 2));
        customer.addRental(new Rental(new Movie("Bambi", Movie.CHILDRENS), 3));
        customer.addRental(new Rental(new Movie("Toy Story", Movie.CHILDRENS), 4));

        String expected = "" +
                "Rental Record for Bob\n" +
                "\tJaws\t2.0\n" +
                "\tGolden Eye\t3.5\n" +
                "\tShort New\t3.0\n" +
                "\tLong New\t6.0\n" +
                "\tBambi\t1.5\n" +
                "\tToy Story\t3.0\n" +
                "Amount owed is 19.0\n" +
                "You earned 7 frequent renter points";

        assertEquals(expected, customer.statement());
    }

    @Test
    public void testStatementWithNoRentals() {
        MovieRentalCustomer customer = new MovieRentalCustomer("Alice");

        String expected = "" +
                "Rental Record for Alice\n" +
                "Amount owed is 0.0\n" +
                "You earned 0 frequent renter points";

        assertEquals(expected, customer.statement());
    }

    @Test
    public void testHtmlStatement() {
        MovieRentalCustomer customer = new MovieRentalCustomer("Bob");
        customer.addRental(new Rental(new Movie("Jaws", Movie.REGULAR), 2));
        customer.addRental(new Rental(new Movie("Golden Eye", Movie.REGULAR), 3));
        customer.addRental(new Rental(new Movie("Short New", Movie.NEW_RELEASE), 1));
        customer.addRental(new Rental(new Movie("Long New", Movie.NEW_RELEASE), 2));
        customer.addRental(new Rental(new Movie("Bambi", Movie.CHILDRENS), 3));
        customer.addRental(new Rental(new Movie("Toy Story", Movie.CHILDRENS), 4));

        String expected = "<h1>Rental Record for <em>Bob</em></h1>" +
                "<table>" +
                "<tr><td>Jaws</td><td>2.0</td></tr>" +
                "<tr><td>Golden Eye</td><td>3.5</td></tr>" +
                "<tr><td>Short New</td><td>3.0</td></tr>" +
                "<tr><td>Long New</td><td>6.0</td></tr>" +
                "<tr><td>Bambi</td><td>1.5</td></tr>" +
                "<tr><td>Toy Story</td><td>3.0</td></tr>" +
                "</table>" +
                "<p>Amount owed is <em>19.0</em></p>" +
                "<p>You earned <em>7</em> frequent renter points</p>";

        assertEquals(expected, customer.htmlStatement());
    }

    @Test
    public void testGetThisAmountForRegularMovie() {
        Movie regularMovie = new Movie("Jaws", Movie.REGULAR);
        Rental regularRental = new Rental(regularMovie, 3);
        double amount = new MovieRentalCustomer("Bob").getThisAmount(regularRental);
        assertEquals(3.5, amount); // 2 for the first 2 days, 1.5 for the third day
    }

    @Test
    public void testGetThisAmountForNewReleaseMovie() {
        Movie newReleaseMovie = new Movie("Short New", Movie.NEW_RELEASE);
        Rental newReleaseRental = new Rental(newReleaseMovie, 2);
        double amount = new MovieRentalCustomer("Bob").getThisAmount(newReleaseRental);
        assertEquals(6.0, amount); // 3 per day for 2 days
    }

    @Test
    public void testGetThisAmountForChildrensMovie() {
        Movie childrensMovie = new Movie("Bambi", Movie.CHILDRENS);
        Rental childrensRental = new Rental(childrensMovie, 4);
        double amount = new MovieRentalCustomer("Bob").getThisAmount(childrensRental);
        assertEquals(3, amount); // 1.5 for the first 3 days, 1.5 for the 4th day
    }

    @Test
    public void testFrequentRenterPointsForRegularMovie() {
        Movie regularMovie = new Movie("Jaws", Movie.REGULAR);
        Rental regularRental = new Rental(regularMovie, 3);
        int points = new MovieRentalCustomer("Bob").getFrequentRenterPoints(regularRental);
        assertEquals(1, points); // Regular movie earns 1 point
    }

    @Test
    public void testFrequentRenterPointsForNewReleaseMovie() {
        Movie newReleaseMovie = new Movie("Short New", Movie.NEW_RELEASE);
        Rental newReleaseRental = new Rental(newReleaseMovie, 2);
        int points = new MovieRentalCustomer("Bob").getFrequentRenterPoints(newReleaseRental);
        assertEquals(2, points); // New release movie earns 2 points when rented for 2 days
    }

    @Test
    public void testFrequentRenterPointsForChildrensMovie() {
        Movie childrensMovie = new Movie("Bambi", Movie.CHILDRENS);
        Rental childrensRental = new Rental(childrensMovie, 3);
        int points = new MovieRentalCustomer("Bob").getFrequentRenterPoints(childrensRental);
        assertEquals(1, points); // Children's movie earns 1 point
    }

    @Test
    public void testEmptyRentalStatement() {
        MovieRentalCustomer customer = new MovieRentalCustomer("Empty");
        assertEquals("Rental Record for Empty\nAmount owed is 0.0\nYou earned 0 frequent renter points", customer.statement());
    }

    @Test
    public void testLongRentalPeriod() {
        MovieRentalCustomer customer = new MovieRentalCustomer("John");
        customer.addRental(new Rental(new Movie("The Godfather", Movie.REGULAR), 10));

        String expected = "Rental Record for John\n" +
                "\tThe Godfather\t14.0\n" +
                "Amount owed is 14.0\n" +
                "You earned 1 frequent renter points";

        assertEquals(expected, customer.statement());
    }

    @Test
    public void testMultipleRentalsSameMovie() {
        MovieRentalCustomer customer = new MovieRentalCustomer("John");
        customer.addRental(new Rental(new Movie("Jaws", Movie.REGULAR), 1));
        customer.addRental(new Rental(new Movie("Jaws", Movie.REGULAR), 3));

        String expected = "Rental Record for John\n" +
                "\tJaws\t2.0\n" +
                "\tJaws\t3.5\n" +
                "Amount owed is 5.5\n" +
                "You earned 2 frequent renter points";

        assertEquals(expected, customer.statement());
    }
}
