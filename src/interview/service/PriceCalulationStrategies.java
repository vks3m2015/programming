package interview.service;

import java.util.Map;

import interview.entitity.MovieCode;

public class PriceCalulationStrategies {
	
	private static Map<MovieCode, MovieCharges> priceCalculationStrategy =
			Map.of(MovieCode.NEW, new NewMovieCharges(),
					MovieCode.CHILDRENS, new ChildrenMovieCharges(),
					MovieCode.REGULAR, new RegularMovieCharges());

	public static MovieCharges getStrategy(MovieCode movieCode) {
		return priceCalculationStrategy.get(movieCode);
	}
}
