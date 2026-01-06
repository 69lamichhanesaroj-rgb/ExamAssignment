package easv.college.examassignment.be;

import java.util.Objects;

public class CatMovie {
    private Integer id;
    private Integer categoryid;
    private Integer movieid;

    public CatMovie(Integer id, Integer categoryid, Integer movieid) {
        this.id = id;
        this.categoryid = categoryid;
        this.movieid = movieid;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getCategoryid() {
        return categoryid;
    }
    public void setCategoryid(Integer categoryid) {
        this.categoryid = categoryid;
    }
    public Integer getMovieid() {
        return movieid;
    }
    public void setMovieid(Integer movieid) {
        this.movieid = movieid;
    }

    /* This part might be usable once we start working on the filter stuff
    @Override
    public boolean filterEquals(Object object) {
        if (this == object) return true;
        if (!(object instanceof CatMovie catMovie)) return false;
        return Objects.equals(id, catMovie.id);
    }
    */
}
