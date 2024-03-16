package interview.service;
import java.util.HashMap;

import entitity.Customer;
import entitity.Movie;
import entitity.MovieCode;
import entitity.MovieRental;

public class RentalInfo {

  public String statement(Customer customer) {
    HashMap<String, Movie> movies = new HashMap<>();
    movies.put("F001", new Movie("You've Got Mail", "regular"));
    movies.put("F002", new Movie("Matrix", "regular"));
    movies.put("F003", new Movie("Cars", "childrens"));
    movies.put("F004", new Movie("Fast & Furious X", "new"));

    return processResult(customer, movies);
	/*
	 * double totalAmount = 0; int frequentEnterPoints = 0; String result =
	 * "Rental Record for " + customer.getName() + "\n"; for (MovieRental r :
	 * customer.getRentals()) { double thisAmount = 0;
	 * 
	 * // determine amount for each movie if
	 * (movies.get(r.getMovieId()).getCode().equals("regular")) { thisAmount = 2; if
	 * (r.getDays() > 2) { thisAmount = ((r.getDays() - 2) * 1.5) + thisAmount; } }
	 * if (movies.get(r.getMovieId()).getCode().equals("new")) { thisAmount =
	 * r.getDays() * 3; } if
	 * (movies.get(r.getMovieId()).getCode().equals("childrens")) { thisAmount =
	 * 1.5; if (r.getDays() > 3) { thisAmount = ((r.getDays() - 3) * 1.5) +
	 * thisAmount; } }
	 * 
	 * //add frequent bonus points frequentEnterPoints++; // add bonus for a two day
	 * new release rental if (movies.get(r.getMovieId()).getCode() == "new" &&
	 * r.getDays() > 2) frequentEnterPoints++;
	 * 
	 * //print figures for this rental result += "\t" +
	 * movies.get(r.getMovieId()).getTitle() + "\t" + thisAmount + "\n"; totalAmount
	 * = totalAmount + thisAmount; } // add footer lines result += "Amount owed is "
	 * + totalAmount + "\n"; result += "You earned " + frequentEnterPoints +
	 * " frequent points\n";
	 * 
	 * return result;
	 */
  }
  
  String processResult(Customer customer,  HashMap<String, Movie> movies) {
	  
	  double totalAmount = 0;
	  int frequentEnterPoints = 0;
	  String result = "Rental Record for " + customer.getName() + "\n";
	  for (MovieRental r : customer.getRentals()) {
		  
		  Movie m = movies.get(r.getMovieId());
		  MovieCode movieCode = m.getCode();
		  MovieCharges movieCharges = PriceCalulationStrategies.getStrategy(movieCode);
		  double thisAmount = movieCharges.calculateAmount(r);
		  
		  totalAmount += thisAmount;		  
		
		  //add frequent bonus points
	     frequentEnterPoints += movieCharges.calculatePointsEarned(r);
	     
	      //print figures for this rental
	      result += "\t" + m.getTitle() + "\t" + thisAmount + "\n";
	  }
	    // add footer lines
	    result += "Amount owed is " + totalAmount + "\n";
	    result += "You earned " + frequentEnterPoints + " frequent points\n";
	    return result;
  }
}
