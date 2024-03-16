package interview.entitity;

public enum MovieCode {
	REGULAR,NEW, CHILDRENS; 
	
	public static MovieCode fromString(String string) {
		return MovieCode.valueOf(string.toUpperCase());
	}
}
