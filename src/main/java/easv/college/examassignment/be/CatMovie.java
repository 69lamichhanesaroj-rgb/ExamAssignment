package easv.college.examassignment.be;

public class CatMovie {
    private Integer categoryId;
    private Integer movieId;
    private String categoryName;
    private String movieName;

    public CatMovie(Integer categoryId, Integer movieId, String categoryName, String movieName) {
        this.categoryId = categoryId;
        this.movieId = movieId;
        this.categoryName = categoryName;
        this.movieName = movieName;
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

    /* This part might be usable once we start working on the filter stuff, ofc depending on how we do it
    @Override
    public boolean filterEquals(Object object) {
        if (this == object) return true;
        if (!(object instanceof CatMovie catMovie)) return false;
        return Objects.equals(id, catMovie.id);
    }

     @Override
    public String toString() {
        return (insert whatever we need)
    }

    */
}
