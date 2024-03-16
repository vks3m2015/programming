package interview.entitity;
public class Movie {
    private String title;
    private MovieCode code;

    public Movie(String title, String code) {

        this.title = title;
        this.code = MovieCode.fromString(code);
    }

    public String getTitle() {
        return title;
    }

    public MovieCode getCode() {
        return code;
    }
}
