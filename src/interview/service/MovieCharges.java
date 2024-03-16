package interview.service;

import entitity.MovieRental;

public interface MovieCharges {
	
	double calculateAmount(MovieRental r);
	
	int calculatePointsEarned(MovieRental r);

}
