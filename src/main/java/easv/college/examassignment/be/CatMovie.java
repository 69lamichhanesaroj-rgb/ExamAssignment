package easv.college.examassignment.be;

public class CatMovie {
    private Integer id;
    private Integer categoryId;
    private Integer movieId;

    public CatMovie(Integer id, Integer categoryId, Integer movieId) {
        this.id = id;
        this.categoryId = categoryId;
        this.movieId = movieId;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
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
