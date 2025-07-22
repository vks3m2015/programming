package interview.service;

import interview.entitity.MovieRental;

public class NewMovieCharges implements MovieCharges{
	
	@Override
	public double calculateAmount(MovieRental r) {
		return r.getDays() * 3;
	}
	
	public int calculatePointsEarned(MovieRental r) {
		return r.getDays() > 2 ? 2: 1;
	}

}
