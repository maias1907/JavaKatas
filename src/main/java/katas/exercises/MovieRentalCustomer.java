package katas.exercises;

import katas.exercises.movieRental.Movie;
import katas.exercises.movieRental.Rental;

import java.util.ArrayList;
import java.util.List;

/**
 * This source code follows Martin Fowler's book "Refactoring, Improving the Design of Existing Code".
 * When you find you have to add a feature to a program, and the program's code is not
 * structured in a convenient way to add the feature, first refactor the program to make it
 * easy to add the feature, then add the feature.
 *
 * Whenever you do refactoring, you MUST build a solid set of tests for that section of code.
 *
 * The `statement` method prints out a simple text output of a rental statement:
 *
 *      Rental Record for martin
 *        Ran 3.5
 *        Trois Couleurs: Bleu 2.0
 *      Amount owed is 5.5
 *      You earned 2 frequent renter points
 *
 *
 * We want to write an HTML version of the statement method :
 *
 *      <h1>Rental Record for <em>martin</em></h1>
 *      <table>
 *        <tr><td>Ran</td><td>3.5</td></tr>
 *        <tr><td>Trois Couleurs: Bleu</td><td>2.0</td></tr>
 *      </table>
 *      <p>Amount owed is <em>5.5</em></p>
 *      <p>You earned <em>2</em> frequent renter points</p>
 *
 * Carfully think how to refactor this code, and write the corresponding tests under MovieRentalCustomerTest.
 */
public class MovieRentalCustomer {

    private String _name;
    private List<Rental> _rentals = new ArrayList<Rental>();

    public MovieRentalCustomer(String name) {
        _name = name;
    }

    public void addRental(Rental arg) {
        _rentals.add(arg);
    }

    public String getName() {
        return _name;
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        String result = "Rental Record for " + getName() + "\n";

        for (Rental each : _rentals) {
            double thisAmount = 0;

            //determine amounts for each line
            switch (each.getMovie().getPriceCode()) {
                case Movie.REGULAR:
                    thisAmount += 2;
                    if (each.getDaysRented() > 2)
                        thisAmount += (each.getDaysRented() - 2) * 1.5;
                    break;
                case Movie.NEW_RELEASE:
                    thisAmount += each.getDaysRented() * 3;
                    break;
                case Movie.CHILDRENS:
                    thisAmount += 1.5;
                    if (each.getDaysRented() > 3)
                        thisAmount += (each.getDaysRented() - 3) * 1.5;
                    break;
            }

            // add frequent renter points
            frequentRenterPoints++;
            // add bonus for a two day new release rental
            if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDaysRented() > 1)
                frequentRenterPoints++;

            // show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";
            totalAmount += thisAmount;
        }

        // add footer lines
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";

        return result;
    }
}
