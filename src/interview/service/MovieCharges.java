package interview.service;

import interview.entitity.MovieRental;

public interface MovieCharges {
	
	double calculateAmount(MovieRental r);
	
	int calculatePointsEarned(MovieRental r);

}
