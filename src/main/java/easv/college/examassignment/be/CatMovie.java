package easv.college.examassignment.be;

public class CatMovie {
    private Integer categoryId;
    private Integer movieId;
    private String categoryName;
    private String movieName;

    public CatMovie(Integer categoryId, Integer movieId) {
        this.categoryId = categoryId;
        this.movieId = movieId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
    public Integer getMovieId() {
        return movieId;
    }
    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }
    public String getCategoryName() {
        return categoryName;
    }
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    public String getMovieName() {
        return movieName;
    }
    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }
}
