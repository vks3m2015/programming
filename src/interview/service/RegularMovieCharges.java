package interview.service;


import interview.entitity.MovieRental;

public class RegularMovieCharges implements MovieCharges{
	
	@Override
	public double calculateAmount(MovieRental r) {
	    double amount= 2;
		return r.getDays() > 2 ? (((r.getDays() - 2) * 1.5) + amount) : amount;
		
	}
	
	public int calculatePointsEarned(MovieRental r) {
		return 1;
	}

}

