package interview.service;

import interview.entitity.MovieRental;

public class ChildrenMovieCharges implements MovieCharges{
	
	public double calculateAmount(MovieRental r) {
        double amount= 1.5;
		return r.getDays() > 3 ? (((r.getDays() - 3) * 1.5) + amount) : amount;
	}
	
	public int calculatePointsEarned(MovieRental r) {
		return 1;
	}

}
