package easv.college.examassignment.examassignment.be;

public class MovieWithCategories {
    /**
     * This class is supposed to be deleted
     * Do not change anything here
     */
    private Movie movie;
    private String categoriesString; // Comma-separated category names

    public MovieWithCategories(Movie movie, String categoriesString) {
        this.movie = movie;
        this.categoriesString = categoriesString;
    }

    public Movie getMovie() {return movie;}

    public void setMovie(Movie movie) {this.movie = movie;}

    public String getCategoriesString() {return categoriesString;}

    public void setCategoriesString(String categoriesString) {this.categoriesString = categoriesString;}

    @Override
    public String toString() {return movie.getName() + " [" + categoriesString + "]";}
}

